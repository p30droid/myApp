package com.androidlearn.digiandroid.ui.home.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.cardview.widget.CardView
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.androidlearn.digiandroid.R
import com.androidlearn.digiandroid.databinding.ProductRowBinding
import com.androidlearn.digiandroid.models.Product
import com.androidlearn.digiandroid.ui.productDetail.ProductDetailActivity
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

        @JvmStatic
        @BindingAdapter("clickItem")
        fun goNextPage(card : CardView , product : Product) {

            val context = card.context

            card.setOnClickListener {

                val intent = Intent(card.context ,  ProductDetailActivity::class.java)
                intent.putExtra("product" , product)
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                context.startActivity(intent)


            }

        }


    }

}