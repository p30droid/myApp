package com.androidlearn.digiandroid.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.androidlearn.digiandroid.R
import com.androidlearn.digiandroid.databinding.ProductRowBinding
import com.androidlearn.digiandroid.models.Product
import com.bumptech.glide.Glide

class ProductAdapter(products : List<Product>) : RecyclerView.Adapter<ProductVH>() {

    lateinit var binding : ProductRowBinding
    lateinit var productList : List<Product>

    init {
        productList = products
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductVH {
        binding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.product_row, parent , false)
        return ProductVH(binding)
    }

    override fun onBindViewHolder(holder: ProductVH, position: Int) {

        var product = productList.get(position)

        binding.product = product

    }

    override fun getItemCount(): Int {
        return  productList.size
    }

    companion object {


        @JvmStatic
        @BindingAdapter("productImage")
        fun showImage(image : AppCompatImageView, url : String) {
            Glide.with(image.context).load(url).into(image)


        }
    }

}