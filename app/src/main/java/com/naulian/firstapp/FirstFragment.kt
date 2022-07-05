package com.naulian.firstapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.naulian.firstapp.databinding.FragmentFirstBinding

class FirstFragment : Fragment(R.layout.fragment_first) {
 private lateinit var viewBinding : FragmentFirstBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding = FragmentFirstBinding.bind(view)

        viewBinding.apply {

            btnSignIn.setOnClickListener {
                signIn()
            }
        }


    }

    private fun signIn(){
       viewBinding.apply {
           val email = edtEmail.text.toString()
           val password = edtPassword.text.toString()

           if(email.isEmpty()){
               edtEmail.error = "Email is empty"
               return
           }

           if(password.isEmpty()){
               edtPassword.error = "Password id empty"
               return
           }

          findNavController().navigate(R.id.action_firstFragmentTo_secondFragment)
       }
    }
}