package com.example.notekeeper

import android.os.Bundle
import android.provider.ContactsContract
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.example.notekeeper.databinding.FragmentFirstBinding
import com.google.android.material.snackbar.Snackbar
import android.widget.ArrayAdapter
import android.widget.Spinner

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val spinner = view.findViewById(R.id.spinnerCourses) as Spinner

        binding.buttonFirst.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }

        val adapterCourses = ArrayAdapter<CourseInfo>(requireActivity(),
         android.R.layout.simple_spinner_item,
        DataManager.courses.values.toList())
        adapterCourses.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinner.adapter = adapterCourses

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}