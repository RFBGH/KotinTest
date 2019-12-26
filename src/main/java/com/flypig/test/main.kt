package com.flypig.test

import kotlin.system.measureTimeMillis

fun vars(vararg v : Int){
    for(vt in v){
        println(vt)
    }
}

fun parseInt( value : String) :Int? {
    return null;
}

fun getStringLength(obj:Any):Int?{

    if(obj is String && obj.length > 0){
        return obj.length
    }

    return null
}

fun <T> sort(array:MutableList<T>, compare:(t1:T, t2:T) -> Int){

    for(i in array.indices){

        var min = array[i]
        var j = i+1
        var findIndex : Int = i
        while (j < array.size){

            var temp = array[j]
            if(compare(min, temp) > 0){
                findIndex = j
                min = temp
            }
            j++
        }

        if(findIndex == i){
            continue
        }

        var temp = array[findIndex]
        array[findIndex] = array[i]
        array[i] = temp
    }
}

fun labam(l1:(Int)->Int, l2:(Int)->String, l3:(Int)->Int){

}

class Runoob(i:Int){

    val b:Int;

    init {
        b = i;
    }


    var a:Int = i
        get(){
            return field
        }
        set(value) {
            field = value
        }

    fun foo(){
        println("foo");
    }

    constructor(a : Int, b: Int ):this(a){
        this.a = a;

        val testFun : ()->Unit = this::foo;
        testFun();
    }
}

class Outer{

    val a : Int = 100;

    inner class Inner{

        fun test() = a

        fun innerTest(){
            var o = this@Outer;
            o.a;
        }

    }

}

class TestLateinit{

    lateinit var a : Empty;


    fun test(){

        if(a == null){
            a = Empty();
        }

        a.test();
    }

}

class Empty{
    fun test(){
        println("empty test");
    }
}

interface TestInterface{
    fun test()
}

class Test{

    fun testInterface(test:TestInterface){
        test.test()
    }
}

open class TestInterfaceImpl:TestInterface{
    override fun test() {
        println("testinterface");
    }
}

class SingleInstance{

    companion object {
        var instance : SingleInstance = SingleInstance();
    }

    public fun test(){
        println("single test");
    }
}

interface ITest{
    fun test()
}

class TestA : ITest{
    override fun test() {
        println("testA")
    }
}

class TestB : ITest{
    override fun test() {
        println("testB")
    }
}

fun testThrowFun(){

    throw Exception("hhhhh")

}

fun getObject():String?{
    return "1"
}


fun main (args:Array<String>){



//    val time = measureTimeMillis(fun(){
//
//        val one = loadFromServer()
//
//        val two = computeInBackground()
//
//        println("The result is ${one + two}")
//    })
//
//    println("Completed in $time ms")

//    val s = getObject()
//
//    if(s is CharSequence){
//        println("1111")
//    }else{
//        println("2222")
//    }


//    testThrowFun()

//    val i = 1
//
//    when(i){
//        1 -> println("1")
//        2 -> println("2")
//        else -> println("else")
//    }
//
//    val s:String? = null
//
//    println(s?.length)

//    val testMap:HashMap<Class<out ITest>, String> = HashMap()
//
//    val testA = TestA()
//    val testB = TestB()
//
//    if (testA::class.java == testA.javaClass) {
//        println("xxxx")
//    }else{
//        println("yyyyy")
//    }

//    testMap[testA.javaClass] = "111"
//    testMap[testB.javaClass] = "222"
//
//    println(testMap[testA.javaClass])
//    println(testMap[testB.javaClass])
//
//
//    val myList:List<String> = ArrayList<String>()
//
//    for(i in 0..myList.size){
//        println(i)
//    }
//
//    val xx = 111
//    println("\$xx=$xx")
//
//    labam({i->i}, {i->"xx"+i}, {i -> i})
//
//    println("Hello World")
//    vars(1,3,4,5,7)
//
//    val sum: (Int, Int) -> Int = {x:Int, y:Int -> x + y};
//
//    println(sum(1, 3))
//
//    var a = 1;
//    var s = "a value is $a";
//    println(s)
//
//    var s1 = "s1 value is s replace 2 : ${a.toString().replace("1", "2")}"
//
//    println(s1)
//
//    var age : String? = null;
//    val age1 = age?.toInt();
//
//    println("age1 "+age1)
//
//    for(i in 1..3){
//        print(i)
//    }
//
//    println()
//
//    val i:Int = 1000_10_2;
//    println(i)
//
//    var param1 : Int = 1000;
//    println(param1 === param1)
//
//    var one : Int = 1;
//    println("one shl 1 "+one.shl(1));
//
//    val b = Array<String>(3, { "it is "+it })
//    for(str in b){
//        println(str)
//    }
//
//    var list : MutableList<Int> = mutableListOf(3, 5, 1, 4, 11, 2, 8, 20, 21, 16)
//    sort(list) {t1:Int, t2:Int -> t1 - t2}
//
//    for(item in list){
//        print(item.toString()+" ");
//    }
//    println()
//
//
//    loop@ for(i in 1..100){
//        for(j in 1..100){
//            if(j == 20){
//                break@loop
//            }
//            println("i j "+i+" "+j);
//        }
//    }
//
//    list.forEach { i -> println(i) }
//
////    var v : TestLateinit = TestLateinit();
////    v.test()
//
//    var test:Test = Test();
//
//    test.testInterface(object : TestInterfaceImpl() {
//        override fun test() {
//            super.test();
//            println("other");
//        }
//    })
//
//    SingleInstance.instance.test()
//
//    val map : Map<String, String> = ConcurrentHashMap();
//
//    val pair : Pair<String, String> = Pair("111", "2222");
//    map.plus(pair)
//    map.plus(Pair ("a", "b"))
//    map.minus("a")
//
//    val testList : List<String> = listOf("1", "2", "3")
//
//    var findStr : String? = null;
//
//    testList.forEach {
//        it -> if (it.equals("1")){
//            findStr = it;
//             return@forEach
//        }
//    }
//
//    println("findStr $findStr")
//
//    val zzz = 1;
//    println(zzz.takeIf { it == 2 })
//
//    val intList : List<Int> = arrayListOf(1,2,3,4,5,6)
//    val list1 = intList.take(2)
//    list1.forEach {
//        print(it.toString()+" ")
//    }
//    println()
//
//    val list2 = intList.takeWhile {
//        it < 4
//    }
//    list2.forEach {
//        print(it.toString()+" ")
//    }
//    println()
//




}