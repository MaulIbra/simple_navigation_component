package com.example.exercise_navigation.view_models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.exercise_navigation.models.Transaction

/**
 * Created by Maulana Ibrahim on 14/August/2020
 * Email maulibrahim19@gmail.com
 */

class TransactionViewModel:ViewModel(){

    val transaction:MutableLiveData<Transaction> = MutableLiveData(Transaction())

    fun setName(recepientName:String){
        transaction.value?.recepientName = recepientName
    }

    fun setBankName(bankName:String){
        transaction.value?.bankName = bankName
    }

    fun setAccountNumber(accountNumber:Int){
        transaction.value?.accountNumber = accountNumber
    }

    fun setAmount(amount:Int){
        transaction.value?.amount = amount
    }

}