package com.androidlearn.digiandroid.ui.category

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.androidlearn.digiandroid.R
import com.androidlearn.digiandroid.databinding.CatRowBinding
import com.androidlearn.digiandroid.models.Categories
import com.bumptech.glide.Glide

class CategoryAdapter(category : List<Categories>) : RecyclerView.Adapter<CategoryVh>() {


    lateinit var binding : CatRowBinding


    lateinit var categoryList : List<Categories>

    init {
        categoryList = category
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryVh {


        binding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.cat_row,parent , false)

        var vh = CategoryVh(binding)

        return vh;

    }

    override fun onBindViewHolder(holder: CategoryVh, position: Int) {


        var category = categoryList.get(position);

        binding.categories = category
       // binding.setCategories(category);


    }

    override fun getItemCount(): Int {
        return  categoryList.size
    }

    companion object {


        @JvmStatic
        @BindingAdapter("categoryImage")
        fun showImage(image : AppCompatImageView , url : String) {
            Glide.with(image.context).load(url).into(image)


        }
    }


}