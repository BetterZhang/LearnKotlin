package com.betterzhang.learnkotlin.domain

/**
 * POJO类
 * Created by betterzhang on 2017/6/16.
 */
data class Customer(val name: String, val email: String)

// 会为Customer类提供以下功能：
// --equals()
// --hashCode()
// --toString()
// --copy()
// --所有属性的component1()、component2()......等等