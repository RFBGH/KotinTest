package com.flypig.test

import kotlin.properties.Delegates
import kotlin.reflect.KProperty

data class Data(val name:String, val age:Int){
    override fun toString(): String {
        return name+" "+age;
    }
}

class Box<T>(t:T){
    val value:T = t
        get() = field

    override fun toString(): String {
        if(value == null){
            return "null"
        }
        return value.toString()
    }
}

fun <T1, T2> fly(t1:T1, t2:T2){

}

enum class Color(val rgb:Int){
    RED(0xFF0000), BLACK(0x000000), BLUE(0x0000FF), GREEN(0x00FF00)
}

enum class ProtocalState{

    WAITING{
        override fun signal() = TALKING
        fun waiting(){
            println("waiting")
        }
    },

    TALKING{
        override fun signal() = WAITING
        fun talking(){
            println("talking")
        }
    };

    abstract fun signal():ProtocalState
}

interface IBase{
    fun print()
}

class BaseImpl:IBase{

    override fun print() {
        println("BaseImpl")
    }

}

class BaseDerived(b:IBase) : IBase by b{

}

class Example{
    var p : String by Delegate()
}

class Delegate{
    operator fun getValue(example: Example, property: KProperty<*>): String {
        return "$example, 这里委托了 ${property.name} 属性 "+property.name+" "
    }

    operator fun setValue(example: Example, property: KProperty<*>, s: String) {
        println("$example 的 ${property.name} 属性赋值为 $s")
    }
}

val lazyValue : String by lazy{
    println("computed")
    "Hello"
}

var observableVar : String by Delegates.observable("11"){
    property, oldValue, newValue -> println("oldvalue "+oldValue+" newValue "+newValue)
}

fun main(arg:Array<String>){
    println("object class test")

    val dat:Data = Data("xxeee", 22)

    val dat2:Data = dat.copy()

    val box : Box<Data> = Box<Data>(Data("name", 11))

    println(dat.toString())
    println(dat2.toString())
    println(box.toString())

    val state : ProtocalState = ProtocalState.WAITING

    val b : IBase = BaseImpl();
    BaseDerived(b).print()

    val sample : Example = Example();

    sample.p = "xxx"
    println(sample.p)

    println(lazyValue)
    println(lazyValue)

    observableVar = "2"
    observableVar = "3"
}