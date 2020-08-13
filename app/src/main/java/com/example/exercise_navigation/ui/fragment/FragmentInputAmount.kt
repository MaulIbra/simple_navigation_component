package com.example.exercise_navigation.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.exercise_navigation.R
import kotlinx.android.synthetic.main.fragment_input_amount.*

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentInputAmount.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentInputAmount : Fragment(),View.OnClickListener {

    lateinit var navController:NavController
    lateinit var bankName:String
    lateinit var accountNumber:String
    lateinit var accountName:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_input_amount, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        btnSend.setOnClickListener(this)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        accountName = arguments?.getString("name").toString()
        accountNumber = arguments?.getString("accountNumber").toString()
        bankName = arguments?.getString("bankName").toString()
        tvName.text = "To : ${accountName}"

    }

    override fun onClick(v: View?) {
        when(v){
            btnSend -> {
                var bundle = bundleOf(
                    "name" to accountName,
                    "bankName" to bankName,
                    "accountNumber" to accountNumber,
                    "amount" to etAmount.text.toString()
                )
                navController.navigate(R.id.action_fragmentInputAmount_to_fragmentConfirmation,bundle)
            }
        }
    }
}
