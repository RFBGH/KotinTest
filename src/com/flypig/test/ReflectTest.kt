package com.flypig.test

import kotlin.reflect.KClass
import kotlin.reflect.KFunction
import kotlin.reflect.full.declaredMemberFunctions
import kotlin.reflect.full.declaredMembers
import kotlin.reflect.full.memberProperties
import kotlin.reflect.full.valueParameters
import kotlin.reflect.jvm.isAccessible

class ReflectClass{

    private var pri : String = "privateString"
//        get() = field
//        set(value) {field = value}

    private fun test(param:String){
        println("xxxxx "+param)
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

    val priProperty = clazz.memberProperties.first{it.name.equals("pri")}
    priProperty?.isAccessible = true;

    println(priProperty?.get(reflectClass))
    println(priProperty?.call(reflectClass))


    println(ObjectMapper.parse(reflectClass))

    val testFun: KFunction<*> = clazz.declaredMemberFunctions.first { it.name.equals("test") }

    testFun.isAccessible = true
    testFun.call(reflectClass, " flypig")
}