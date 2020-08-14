package com.example.exercise_navigation.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.exercise_navigation.R
import com.example.exercise_navigation.utils.validationInput
import com.example.exercise_navigation.view_models.TransactionViewModel
import kotlinx.android.synthetic.main.fragment_input_amount.*

class FragmentInputAmount : Fragment(), View.OnClickListener {

    lateinit var navController: NavController
    val transactionViewModel by activityViewModels<TransactionViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_input_amount, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        btnSend.setOnClickListener(this)
        transactionViewModel.transaction.observe(viewLifecycleOwner, Observer {
            tvName.text = "TO : ${it.recepientName}"
        })
    }

    override fun onClick(v: View?) {
        when (v) {
            btnSend -> buttonSendHandler()
        }
    }

    private fun buttonSendHandler() {
        val amount = etAmount.text.toString()
        if (validationInput(amount)) {
            transactionViewModel.setAmount(amount.toInt())
            navController.navigate(R.id.action_fragmentInputAmount_to_fragmentConfirmation)
        } else {
            Toast.makeText(
                context, "Amount Can't be Empty",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}
