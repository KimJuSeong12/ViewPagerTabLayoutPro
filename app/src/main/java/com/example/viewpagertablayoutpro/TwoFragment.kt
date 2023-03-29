package com.example.viewpagertablayoutpro

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.viewpagertablayoutpro.databinding.FragmentOneBinding
import com.example.viewpagertablayoutpro.databinding.FragmentTwoBinding

class TwoFragment : Fragment() {
    lateinit var mainActivity:MainActivity
    lateinit var binding: FragmentTwoBinding
    override fun onAttach(context: Context) {
        super.onAttach(context)
        mainActivity = context as MainActivity
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentTwoBinding.inflate(inflater)
        return binding.root
    }

}