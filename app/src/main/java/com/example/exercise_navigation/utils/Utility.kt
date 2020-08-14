package com.example.exercise_navigation.utils

/**
 * Created by Maulana Ibrahim on 14/August/2020
 * Email maulibrahim19@gmail.com
 */

fun validationInput(vararg values:String):Boolean{
    for (value in values){
        if (value.isEmpty()){
            return false
        }
    }
    return true
}