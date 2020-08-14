package com.example.exercise_navigation.models

/**
 * Created by Maulana Ibrahim on 14/August/2020
 * Email maulibrahim19@gmail.com
 */

data class Transaction(
    var recepientName:String = "",
    var bankName:String = "",
    var accountNumber:Int = 0,
    var amount:Int = 0
)