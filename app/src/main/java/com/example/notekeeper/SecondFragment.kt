package com.example.notekeeper

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.notekeeper.databinding.FragmentSecondBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       //val view = inflater.inflate(R.layout.fragment_second, container, false)
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerview = view.findViewById<RecyclerView>(R.id.listItems)
        recyclerview.layoutManager = LinearLayoutManager(activity)
        val adapter = CustomAdapter(DataManager.notes)
        recyclerview.adapter = adapter

        val fab = view.findViewById(R.id.fab) as FloatingActionButton

        fab.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}