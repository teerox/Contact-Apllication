package com.example.contactapplication.userinterface


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.contactapplication.R
import com.example.contactapplication.databinding.FragmentAddcontactBinding

/**
 * A simple [Fragment] subclass.
 */
class AddContactFragment : Fragment() {

    lateinit var binding: FragmentAddcontactBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_addcontact,container,false)
        return binding.root
    }


}
