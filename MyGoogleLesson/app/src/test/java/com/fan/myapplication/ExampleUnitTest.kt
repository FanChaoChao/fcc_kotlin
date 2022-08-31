package com.fan.myapplication

import kotlinx.coroutines.*
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        CoroutineScope(Dispatchers.).launch{
            val result1 = supendTestFun()
            val result2 = supendTestFun(4)
            println(result1+result2)
            println("这是什么时候执行"+ Thread.currentThread().name)
        }
        println("最外层"+Thread.currentThread().name)
    }
    suspend fun supendTestFun(num:Int = 1):Int{
        return withContext(Dispatchers.IO){
            delay(1000)
            println(Thread.currentThread().name+System.currentTimeMillis())
            num
        }

    }
}