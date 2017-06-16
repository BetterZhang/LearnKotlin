// 定义包
package com.betterzhang.learnkotlin
// 导入包
import java.util.*

/**
 * 基础语法
 * Created by betterzhang on 2017/6/16.
 */
class KotlinLesson1 {

    //**********************定义函数**********************

    // 带有两个Int参数、返回Int的函数
    fun sum1(a: Int, b: Int): Int {
        return a + b
    }

    // 将表达式作为函数体、返回值类型自动推断的函数
    fun sum2(a: Int, b: Int) = a + b

    // 函数返回无意义的值
    fun printSum1(a: Int, b: Int): Unit {
        println("sum of $a and $b is ${a + b}")
    }

    // Unit返回类型可以省略
    fun printSum2(a: Int, b: Int) {
        println("sum of $a and $b is ${a + b}")
    }

    fun main(args: Array<String>) {
        print("sum of 3 and 5 is ")
        println(sum1(3, 5))

        println("sum of 19 and 23 is ${sum1(19, 23)}")

        printSum1(-1, 8)

    }

    //-----------------------End--------------------------

    //*********************定义局部变量*********************

    fun test1() {
        // 一次赋值（只读）的局部变量
        val a: Int = 1      // 立即赋值
        val b = 2           // 自动推断出'Int'类型
        val c: Int          // 如果没有初始值，类型不能省略
        c = 3               // 明确赋值

        println("a = $a, b = $b, c = $c")

        // 可变变量
        var x = 5           // 自动推断出'Int'类型
        x += 1
        println("x = $x")

    }

    //-----------------------End--------------------------

    //*************************注释************************

    // 这是一个行注释
    /*
       这是一个多行的块注释
       /*
            Kotlin的块注释可以嵌套
        */
     */

    //-----------------------End--------------------------

    //*********************使用字符串模板********************

    fun test2() {
        var aa = 1
        // 模板中的简单名称
        val s1 = "aa is $aa"

        aa = 2
        // 模板中的任意表达式
        val s2 = "${s1.replace("is", "was")}, but now is $aa"
        println(s2)

    }

    //-----------------------End--------------------------

    //*********************使用条件表达式********************

    fun max(a: Int, b: Int): Int {
        if (a > b) {
            return a
        } else {
            return b
        }
    }

    // 使用if作为表达式
    fun maxOf(a: Int, b: Int) = if (a > b) a else b

    //-----------------------End--------------------------

    //******************使用可空值及null检测*****************

    fun parseInt(str: String): Int? {
        return str.toIntOrNull()
    }

    fun printProduct(arg1: String, arg2: String) {
        val x = parseInt(arg1)
        val y = parseInt(arg2)

        if (x == null) {
            println("Wrong number format in arg1: '${arg1}'")
            return
        }
        if (y == null) {
            println("Wrong number format in arg2: '${arg2}'")
            return
        }
        println(x * y)
    }

//    fun main(args: Array<String>) {
//        printProduct("6", "7")
//        printProduct("a", "7")
//        printProduct("99", "b")
//    }

    //-----------------------End--------------------------

    //****************使用类型检测及自动类型转换***************

    fun getStringLength1(obj: Any): Int? {
        if (obj is String) {
            return obj.length
        }
        return null
    }

    fun getStringLength2(obj: Any): Int? {
        if (obj !is String) return null
        return obj.length
    }

    fun getStringLength3(obj: Any): Int? {
        if (obj is String && obj.length > 0) {
            return obj.length
        }
        return null
    }

//    fun main(args: Array<String>) {
//        fun printLength(obj: Any) {
//            println("'$obj' string length is ${getStringLength3(obj) ?: "...err, is empty or not a string at all"}")
//        }
//        printLength("Incomprehensibilities")
//        printLength("")
//        printLength(1000)
//    }

    //-----------------------End--------------------------

    //**********************使用for循环*********************

    fun test3() {
        val items1 = listOf("apple", "banana", "kiwi")
        for (item in items1) {
            println(item)
        }

        val item2 = listOf("apple", "banana", "kiwi")
        for (index in item2.indices) {
            println("item at $index is ${item2[index]}")
        }
    }

    //-----------------------End--------------------------

    //*********************使用while循环********************

    fun test4() {
        val item1 = listOf("apple", "banana", "kiwi")
        var index = 0
        while (index < item1.size) {
            println("item at $index is ${item1[index]}")
            index++
        }
    }

    //-----------------------End--------------------------

    //*********************使用when表达式*******************

    fun describe(obj: Any): String =
        when(obj) {
            1           -> "One"
            "Hello"     -> "Greeting"
            is Long     -> "Long"
            !is String  -> "Not a string"
            else        -> "Unknown"
    }

//    fun main(args: Array<String>) {
//        println(describe(1))
//        println(describe("Hello"))
//        println(describe(1000L))
//        println(describe(2))
//        println(describe("other"))
//    }

    //-----------------------End--------------------------

    //*******************使用区间（range）******************

    fun test5() {
        val x = 10
        val y = 9
        // 使用in运算符来检测某个数字是否在指定区间内
        if (x in 1..y + 1) {
            println("fits in range")
        }
        // 检测某个数字是否在指定区间外
        val list = listOf("a", "b", "c")
        if (-1 !in 0..list.lastIndex) {
            println("-1 is out of range")
        }
        if (list.size !in list.indices) {
            println("list size is out of valid list indices range too")
        }
        // 区间迭代
        for (x in 1..5) {
            print(x)
        }
        // 数列迭代
        for (x in 1..10 step 2) {
            print(x)
        }
        for (x in 9 downTo 0 step 3) {
            print(x)
        }
    }

    //-----------------------End--------------------------

    //***********************使用集合***********************

    fun test6() {
        // 对集合进行迭代
        val items = listOf("apple", "banana", "kiwi")
        for (item in items) {
            println(item)
        }

        // 使用in运算符来判断集合内是否包含某实例
        when {
            "orange" in items -> println("juicy")
            "apple"  in items -> println("apple is fine too")
        }

        // 使用lambda表达式来过滤（filter）和映射（map）集合
        val fruits = listOf("banana", "avocado", "apple", "kiwi")
        fruits
            .filter { it.startsWith("a") }
            .sortedBy { it }
            .map { it.toUpperCase() }
            .forEach { println(it) }
    }

    //-----------------------End--------------------------
}