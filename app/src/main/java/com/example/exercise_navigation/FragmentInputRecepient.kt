package com.example.exercise_navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_input_recepient.*

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentInputRecepient.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentInputRecepient : Fragment(),View.OnClickListener {

    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
     }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_input_recepient, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        btnNext.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v){
            btnNext -> {
                var bundle = bundleOf("name" to etName.text.toString())
                navController.navigate(R.id.action_fragmentInputRecepient2_to_fragmentInputAmount,bundle)
            }
        }
    }
}
