package com.flypig.test

suspend fun loadFromServer(): Int{

    try {
        Thread.sleep(1000)
    }catch (e:Exception){
        e.printStackTrace()
    }

    return 11
}

suspend fun computeInBackground(): Int{

    try {
        Thread.sleep(1000)
    }catch (e:Exception){
        e.printStackTrace()
    }

    return 8
}

fun main (args:Array<String>){

    println("hello" +
            "")

}