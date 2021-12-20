package com.androidlearn.digiandroid.ui.categoryProducts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.androidlearn.digiandroid.R
import com.androidlearn.digiandroid.databinding.ActivityCategoryProductBinding
import com.androidlearn.digiandroid.models.BaseModel
import com.androidlearn.digiandroid.models.Category
import com.androidlearn.digiandroid.ui.category.CategoryAdapter
import com.androidlearn.digiandroid.ui.category.CategoryViewModel

class CategoryProductActivity : AppCompatActivity() {

    lateinit var binding : ActivityCategoryProductBinding
    lateinit var viewModel : CategoryProductsViewModel



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCategoryProductBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(CategoryProductsViewModel::class.java)

        viewModel.getCategoryProducts(1).observe(this , object : Observer<BaseModel> {
            override fun onChanged(t: BaseModel?) {
                Log.e("","")
                if (t != null) {


                    binding.recyclerProducts.adapter = ProductCategoriesAdapter(t.products)
                    binding.recyclerProducts.layoutManager = LinearLayoutManager(applicationContext , LinearLayoutManager.VERTICAL , false)
                 //   Log.e("","${t.categories.size}")



                };
            }

        })




    }
}