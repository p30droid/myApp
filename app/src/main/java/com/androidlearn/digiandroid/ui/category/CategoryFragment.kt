package com.androidlearn.digiandroid.ui.category

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.androidlearn.digiandroid.R
import com.androidlearn.digiandroid.databinding.FragmentCategoryBinding
import com.androidlearn.digiandroid.databinding.FragmentHomeBinding
import com.androidlearn.digiandroid.models.Category

class CategoryFragment : Fragment() {

    lateinit var binding : FragmentCategoryBinding

    lateinit var viewModel : CategoryViewModel
    lateinit var owner : LifecycleOwner


    override fun onAttach(context: Context) {
        super.onAttach(context)
        owner = this
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = FragmentCategoryBinding.inflate(layoutInflater)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(CategoryViewModel::class.java)

        viewModel.category.observe(owner , object : Observer<Category>{
            override fun onChanged(t: Category?) {
                Log.e("","")
                if (t != null) {
                    Log.e("","${t.categories.size}")


                    binding.recyclerCategory.adapter = CategoryAdapter(t.categories)

                    binding.recyclerCategory.layoutManager = LinearLayoutManager(activity , LinearLayoutManager.VERTICAL , false)


                };
            }

        })



    }

}