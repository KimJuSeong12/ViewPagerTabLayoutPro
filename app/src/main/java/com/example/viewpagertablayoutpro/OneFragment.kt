package com.example.viewpagertablayoutpro

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.viewpagertablayoutpro.databinding.FragmentOneBinding


class OneFragment : Fragment() {

    lateinit var mainActivity:MainActivity
    lateinit var binding: FragmentOneBinding
    lateinit var dataList: MutableList<DataList>
    override fun onAttach(context: Context) {
        super.onAttach(context)
        mainActivity = context as MainActivity
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentOneBinding.inflate(inflater)
        dataList = mutableListOf<DataList>()
        for(i in 1..30){
            if(i %2 == 0){
                dataList.add(DataList("홍길동${i}","${20+i}","kgkl${i}@gmail.com",R.drawable.man))
            } else {
                dataList.add(DataList("홍길여${i}","${20+i}","kgkl${i}@gmail.com",R.drawable.woman))
            }
        }
        val customRecycleAdapter = CustomRecycleAdapter(dataList)
        binding.recyclerView.adapter = customRecycleAdapter
        binding.recyclerView.layoutManager = LinearLayoutManager(mainActivity)
        binding.recyclerView.addItemDecoration(MyDecoration(activity as Context))

        return binding.root
    }

}