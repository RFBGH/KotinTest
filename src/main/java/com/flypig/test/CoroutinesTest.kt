package com.flypig.test

import kotlinx.coroutines.*
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.CompletableFuture


suspend fun loadFromServer(): Int{

    println(Thread.currentThread().name+" loadFromServer")
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

fun delay_with_coroutine() {
    runBlocking {
        println("Hello")
        delay(1000)
        println("World")
    }
}

val time = SimpleDateFormat("hh:MM:ss")

suspend fun test0(){

    GlobalScope.launch {
        delay(1000)
        println("${time.format(Date())}  World!")
    }

    println("${time.format(Date())}  Hello, ")
    Thread.sleep(2000)
}

fun delay_with_async(){

    println("delay_with_async")

    val one = GlobalScope.async{
        delay(1000)
        1
    }

    val two = GlobalScope.async {
        delay(2000)
        2
    }

    runBlocking {
        println("${one.await()+two.await()}")
    }
}

suspend fun main() {

//    delay_with_async()

     println(Thread.currentThread().name)
//
     val result = GlobalScope.async { loadFromServer() }.await()
     print(Thread.currentThread().name+" "+result)
//
//     Thread.sleep(2000)
//     delay_with_async()
//     val future = CompletableFuture.supplyAsync({ 1 })
//     future.thenApply { value -> "${value + 2}" }
//             .thenAccept({ value ->
//                 println(value.toString())
//             })
}
