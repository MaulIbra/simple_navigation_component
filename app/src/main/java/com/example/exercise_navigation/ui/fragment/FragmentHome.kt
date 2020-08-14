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
import com.example.exercise_navigation.ui.activity.TransactionActivity
import kotlinx.android.synthetic.main.fragment_home.*

class FragmentHome : Fragment(),View.OnClickListener {

    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        btnTransfer.setOnClickListener(this)
        btnHistoryTransaction.setOnClickListener(this)
        btnBalance.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when(view){
            btnTransfer -> navController.navigate(R.id.action_fragmentHome_to_transactionActivity)
            btnHistoryTransaction -> navController.navigate(R.id.action_fragmentHome_to_fragmentHistory)
            btnBalance -> navController.navigate(R.id.action_fragmentHome_to_fragmentBalance)
        }
    }
}
