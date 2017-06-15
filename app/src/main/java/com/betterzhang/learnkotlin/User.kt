package com.betterzhang.learnkotlin

/**
 * Created by betterzhang on 2017/6/15.
 */

class User {

    var name: String? = null
    var address: String? = null
    var age: Int = 0

    override fun toString(): String {
        return "User{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                '}'
    }

}
