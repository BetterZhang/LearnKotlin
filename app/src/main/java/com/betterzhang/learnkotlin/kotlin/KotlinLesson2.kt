package com.betterzhang.learnkotlin.kotlin

import com.betterzhang.learnkotlin.domain.Customer
import com.betterzhang.learnkotlin.domain.User
import java.io.File

/**
 * Kotlin习惯用法
 * Created by betterzhang on 2017/6/16.
 */
class KotlinLesson2 {

    // 函数的默认参数
    fun foo(a: Int = 0, b: String = "") {

    }

    fun test1() {
        // 过滤list
        val list = listOf(2, 5, -4, 3)
        val positives1 = list.filter { x -> x > 0 }
        val positives2 = list.filter { it > 0 }

        // String内插
        val name = "Xiaoming"
        println("Name $name")
    }

    fun test2(x: Any): String =
        // 类型判断
        when(x) {
            is User -> "User"
            is Customer -> "Customer"
            else -> "Unknown"
    }

    fun test3() {
        // 遍历map/pair型list
        val map = hashMapOf<String, String>()
        map.put("one", "1")
        map.put("two", "2")
        for ((k, v) in map) {
            println("$k -> $v")
        }

        // 使用区间
        for (i in 1..100) {}            // 闭区间，包含100
        for (i in 1 until 100) {}       // 半开区间，不包含100
        for (x in 2..10 step 2) {}
        for (x in 10 downTo 1 step 2) {}
        val x: Int = 5
        if (x in 1..10) {} else {}

        // 只读list
        val list = listOf("a", "b", "c")
        // 只读map
        val map1 = mapOf("a" to 1, "b" to 2, "c" to 3)
        // 访问map
        println(map1["a"])

        // 延迟属性
//        val p: String by lazy {  }

        // 扩展函数
        fun String.spaceToCamelCase() {}
        "Convert this to camelcase".spaceToCamelCase()

    }

    // 创建单例
    object Resource {
        val name = "Name"
    }

    fun test4() {
        // if not null缩写
        val files = File("Test").listFiles()
        println(files?.size)
        // if not null and else缩写
        println(files?.size ?: "empty")

        // if null 执行一个语句
        val data = hashMapOf<String, String>()
        data.put("name", "betterzhang")
        data.put("email", "betterzhang.dev@gmail.com")
        val email = data["email"] ?: throw IllegalStateException("Email is missing")

        // if not null 执行代码
        data?.let {
            // 假如data不为null，代码会执行到此处
        }

        // 映射可空值（如果非空的话）
//        val mapped = data?.let { transformData(it) } ?: defaultValueIfDataIsNull
    }

    // 返回when表达式
    fun transform(color: String): Int {
        return when (color) {
            "Red" -> 0
            "Green" -> 1
            "Blue" -> 2
            else -> throw IllegalArgumentException("Invalid color param value")
        }
    }

    // try/catch表达式
    fun count() {}
    fun test5() {
        val result = try {
            count()
        } catch (e: ArithmeticException) {
            throw IllegalArgumentException(e)
        }
    }

    // if表达式
    fun foo(param: Int) {
        val result = if (param == 1) {
            "one"
        } else if (param == 2) {
            "two"
        } else {
            "three"
        }
    }

    // 返回类型为Unit的方法的Builder风格用法
    fun arrayOfMinusOnes(size: Int): IntArray {
        return IntArray(size).apply { fill(-1) }
    }

    // 单表达式函数
    fun theAnswer() = 42
    // 等价于
    fun theAnswer2(): Int {
        return 42
    }

    // 单表达式函数与其他惯用法一起使用能简化代码，例如和when表达式一起使用
    fun transform2(color: String): Int = when(color) {
        "Red" -> 0
        "Green" -> 1
        "Blue" -> 2
        else -> throw IllegalArgumentException("Invalid color param value")
    }

    // 对一个对象实例调用多个方法
    class Turtle {
        fun penDown() {}
        fun penUp() {}
        fun turn(degrees: Double) {}
        fun forward(pixels: Double) {}
    }

    fun test6() {
        val myTurtle = Turtle()
        // 画一个 100 像素的正方形
        with(myTurtle) {
            penDown()
            for (i in 1..4) {
                forward(100.0)
                turn(90.0)
            }
            penUp()
        }
    }

    // java 7的try with resources
//    val stream = Files.newInputStream(Paths.get("/some/file.txt"))
//    stream.buffered().reader().use { reader ->
//        println(reader.readText())
//    }

    // 对于需要泛型信息的泛型函数的适宜形式
//    inline fun <reified T: Any> Gson.fromJson(json): T = this.fromJson(json, T::class.java)

    // 使用可空布尔值
    fun test7() {
        val b: Boolean? = true
        if (b == true) {

        } else {
            // b是fasle或者为null
        }
    }
}
