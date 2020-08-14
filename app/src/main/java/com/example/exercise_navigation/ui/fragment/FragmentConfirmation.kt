package com.example.exercise_navigation.ui.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.exercise_navigation.R
import com.example.exercise_navigation.ui.activity.MainActivity
import com.example.exercise_navigation.view_models.TransactionViewModel
import kotlinx.android.synthetic.main.fragment_confirmation.*
import kotlinx.android.synthetic.main.fragment_input_amount.*

class FragmentConfirmation : Fragment(), View.OnClickListener {

    val transactionViewModel by activityViewModels<TransactionViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_confirmation, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnBackToHome.setOnClickListener(this)
        transactionViewModel.transaction.observe(viewLifecycleOwner, Observer {
            tvBank.text = "Bank ${it.bankName}"
            tvAccountNumber.text = "${it.accountNumber} ${it.recepientName.toUpperCase()}"
            tvAmount.text = it.amount.toString()
        })
    }

    override fun onClick(v: View?) {
        when (v) {
            btnBackToHome -> activity?.finish()
        }
    }

}
