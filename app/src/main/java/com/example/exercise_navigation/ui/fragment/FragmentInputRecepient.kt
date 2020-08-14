package com.example.exercise_navigation.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.exercise_navigation.R
import com.example.exercise_navigation.utils.validationInput
import com.example.exercise_navigation.view_models.TransactionViewModel
import kotlinx.android.synthetic.main.fragment_input_recepient.*

class FragmentInputRecepient : Fragment(), View.OnClickListener {

    lateinit var navController: NavController
    val transactionViewModel by activityViewModels<TransactionViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_input_recepient, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        btnNext.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v) {
            btnNext -> buttonNextHandler()
        }
    }

    private fun buttonNextHandler() {
        val name = etName.text.toString()
        val bankName = spinnerBank.selectedItem.toString()
        val accountNumber = etAccountNumber.text.toString()
        if (validationInput(name, bankName, accountNumber)) {
            transactionViewModel.setName(name)
            transactionViewModel.setBankName(bankName)
            transactionViewModel.setAccountNumber(accountNumber.toInt())
            navController.navigate(R.id.action_fragmentInputRecepient2_to_fragmentInputAmount)
        } else {
            Toast.makeText(
                context,
                "Name, bank name or account number Can't be Empty",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}
