package com.flypig.test

class TestClass (pName : String, pAge : Int){

    constructor(pName : String, pAge : Int, test : Boolean) : this(pName, pAge){

    }

    public var name : String = pName
        get() {
            return field+" pig"
        }
        set(value) {
            field = "fly "+value
        }


    private var age : Int
    init {
        age = pAge
    }
}

open class Base{
    open fun f(){}

    open fun play(){
        println("base play")
    }
}

object SingleInstance1{
    fun test(){
        println("singleInstance test")
    }
}

class SingleInstance2{
    companion object {
        val instance : SingleInstance2 = SingleInstance2();
    }

    fun test(){
        println("singleInstance2 test")
    }
}

abstract class Derived : Base(){
    abstract override fun f();
}

open class Person(name:String){

    constructor(name : String, test : Boolean) : this(name){

    }

    open fun play(){
        println("person play");
    }

}

interface IPlay{
    fun play(){
        println("IPlay play");
    }
}

open class Student(name: String, age : Int) : Person(name), IPlay{

    val studentName : String = name;

    constructor(name : String, age : Int, test : Boolean) : this(name, age){

    }

    override fun play(){
        super<IPlay>.play()

        super<Person>.play()

        println("student play")
    }
}

fun Student.fly() {
    println("student fly extend fun");
}

open class Student2 : Person{

    constructor(name : String, age : Int, test : Boolean) : super(name, test){

    }
}

val Student.newValue : String
    get() {
        return "xxx"
    }


//fun test() : String{
//    var a : Int? = null
//
//    return a?.toString()
//}

val <T> List<T>.lastIndex : Int
    get() = size - 1

fun <T>MutableList<T>.swap(index1:Int, index2:Int){

    if(index1 < 0 || index1 > size){
        return
    }

    if(index2 < 0 || index2 > size){
        return
    }

    val t : T = get(index1)
    set(index1, get(index2))
    set(index1,  t)
}

fun Any?.toString():String{
    if(this == null){
        return "null"
    }
    return this.toString()
}

class CompaionTest{
    companion object {
        fun testCompaion(){
            println("compaion test")
        }
    }
}

fun CompaionTest.Companion.testExtendFun() {
    println("testExtendFun")
}

fun main(args:Array<String>){

    CompaionTest.testCompaion()
    CompaionTest.testExtendFun()


//    println("Class Test")
//    val testClass : TestClass = TestClass("111", 1);
//    println(testClass.name)
//    testClass.name = "xxx"
//    println(testClass.name)
//
//    SingleInstance1.test()
//
//    SingleInstance2.instance.test()
//
//    val student : Student = Student("11", 2)
//
//    var a : Int? = null
//
//    var s : String = a!!.toString()
//    println(test())

    var student:Student = Student("111", 1)
    student.fly()

    var t = null;
    println(t.toString())

}