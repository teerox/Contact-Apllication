package com.example.contactapplication.userinterface


import android.os.Binder
import android.os.Bundle
import android.text.Layout
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.contactapplication.R
import com.example.contactapplication.databinding.FragmentRecyclerViewBinding
import com.example.contactapplication.model.Contact
import java.util.ArrayList

/**
 * A simple [Fragment] subclass.
 */
class DisplayAllContactFragment : Fragment() {

    lateinit var binding: FragmentRecyclerViewBinding
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: ContactAdapter
    private var contacts = ArrayList<Contact>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_recycler_view,container,false)
        recyclerView = binding.recyView
        adapter= ContactAdapter(activity!!.applicationContext,contacts,
            ({contact -> val action = DisplayAllContactFragmentDirections.actionDisplayAllContactFragmentToSingleContactFragment(contact)
                binding.root.findNavController().navigate(action)
            }))
            binding.addNew.setOnClickListener {
              val a =  DisplayAllContactFragmentDirections.actionDisplayAllContactFragmentToAddContactFragment()
                binding.root.findNavController().navigate(a)
            }
        recyclerView.adapter = adapter


        return binding.root
    }


}
