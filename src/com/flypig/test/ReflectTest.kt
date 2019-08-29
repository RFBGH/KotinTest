package com.flypig.test

import java.lang.Exception
import kotlin.reflect.KClass
import kotlin.reflect.KFunction
import kotlin.reflect.KMutableProperty1
import kotlin.reflect.KProperty1
import kotlin.reflect.full.declaredMemberFunctions
import kotlin.reflect.full.declaredMembers
import kotlin.reflect.full.memberProperties
import kotlin.reflect.full.valueParameters
import kotlin.reflect.jvm.isAccessible

class ReflectClass(){

//    constructor(value:String):this(){
//        pri = value
//    }

    private var pri : String = "privateString"
//        get() = field
//        set(value) {field = value}

    private fun test(param:String){
        println("xxxxx "+param)
    }

    override fun toString(): String {
        return "toString "+pri
    }

}

object ObjectMapper {

    fun parse(t:Any):String{

        val props=t::class.memberProperties
        var jsonStr="{${t::class.simpleName}:{"
        props.forEachIndexed { index, it ->
            jsonStr+="\"${it.name}\":\"${it.call(t)}\""+if(index==props.size-1) "" else ","
        }
        jsonStr+="}}"

        return jsonStr
    }
}

fun main(arg:Array<String>){
    println("reflectTest")

    val reflectClass : ReflectClass = ReflectClass()

    val clazz : KClass<ReflectClass> = ReflectClass::class

    val clazz2 = reflectClass.javaClass

    val constructors : List<KFunction<ReflectClass>> = ArrayList(clazz.constructors)
    if(constructors?.size > 0){
        val constructor : KFunction<ReflectClass> = constructors[0];
        val reflect : ReflectClass = constructor.call();
        println("constructor "+reflect)
    }

    val priProperty : KProperty1<ReflectClass, *> = clazz.memberProperties.first{it.name.equals("pri")}
    priProperty.isAccessible = true;

    println(priProperty.get(reflectClass))
    println(priProperty.call(reflectClass))

    if(priProperty is KMutableProperty1<ReflectClass, *>){
        val mutablePriProperty : KMutableProperty1<ReflectClass, String>? = (priProperty as? KMutableProperty1<ReflectClass, String>)
        mutablePriProperty?.set(reflectClass, "flypig xxx")
    }

    println(priProperty.get(reflectClass))

    println(ObjectMapper.parse(reflectClass))

    val testFun: KFunction<*> = clazz.declaredMemberFunctions.first { it.name.equals("test") }

    testFun.isAccessible = true
    testFun.call(reflectClass, " flypig")

    val t1 = ReflectClass::class
    println("Kotlin 类引用${t1}")
    val t2 = ReflectClass::class.java
    println("Java 类引用${t2}")

}