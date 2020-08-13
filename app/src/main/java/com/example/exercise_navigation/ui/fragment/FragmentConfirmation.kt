package com.example.exercise_navigation.ui.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.exercise_navigation.R
import com.example.exercise_navigation.ui.activity.MainActivity
import kotlinx.android.synthetic.main.fragment_confirmation.*
import kotlinx.android.synthetic.main.fragment_input_amount.*

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentConfirmation.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentConfirmation : Fragment(),View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_confirmation, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnBackToHome.setOnClickListener(this)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        tvBank.text = "Bank ${arguments?.getString("bankName").toString()}"
        tvAccountNumber.text = "${arguments?.getString("accountNumber").toString()} ${arguments?.getString("name").toString().toUpperCase()}"
        tvAmount.text = arguments?.getString("amount").toString()
    }

    override fun onClick(v: View?) {
        when(v){
            btnBackToHome -> activity!!.finish()
        }
    }

}
