package com.example.adv160420031week4.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.adv160420031week4.R
import com.example.adv160420031week4.model.Student
import com.example.adv160420031week4.viewmodel.DetailViewModel

class StudentDetailFragment : Fragment() {

    private lateinit var viewModel: DetailViewModel
    var studentList = ArrayList<Student>()
    var id = ""
    var name = ""
    var bod = ""
    var phone = ""
    var url = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_student_detail, container, false)
    }

    fun observeViewModel() {
        viewModel.studentLD.observe(viewLifecycleOwner, Observer {
            view?.findViewById<TextView>(R.id.txtID)?.setText(it.id)
            view?.findViewById<TextView>(R.id.txtName)?.setText(it.name)
            view?.findViewById<TextView>(R.id.txtBod)?.setText(it.dob)
            view?.findViewById<TextView>(R.id.txtPhone)?.setText(it.phone)
        })
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (arguments != null){
            id = StudentDetailFragmentArgs.fromBundle(requireArguments()).id // ada dibagian navigation bagian studentDetailFragment bagian argument
            name = StudentDetailFragmentArgs.fromBundle(requireArguments()).name
            bod = StudentDetailFragmentArgs.fromBundle(requireArguments()).dob
            phone = StudentDetailFragmentArgs.fromBundle(requireArguments()).phone
        }
        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        viewModel.fetch(id,name,bod,phone,url)
        observeViewModel()
    }


}