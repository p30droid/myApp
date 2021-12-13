package com.androidlearn.digiandroid.ui.productDetail

import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.viewpager.widget.ViewPager
import com.androidlearn.digiandroid.MainActivity
import com.androidlearn.digiandroid.R
import com.androidlearn.digiandroid.config.ConfigApp
import com.androidlearn.digiandroid.databinding.ActivityProductDetailBinding
import com.androidlearn.digiandroid.models.Gallery
import com.androidlearn.digiandroid.models.Product

class ProductDetailActivity : AppCompatActivity() {

    lateinit var product : Product


    lateinit var binding : ActivityProductDetailBinding

    lateinit var activity : Context


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activity = applicationContext
        binding = DataBindingUtil.setContentView(this ,R.layout.activity_product_detail )


        var bundle  = intent.extras!!.getParcelable<Product>("product")
        product = intent.extras!!.getParcelable("product")!!
        Log.e("","");

        binding.product = product
        binding.executePendingBindings()




    }


    companion object{

        @JvmStatic
        @BindingAdapter("gallery")
        fun setGallery(pager : ViewPager , list : List<Gallery>) {

            pager.adapter = GalleryAdapter(pager.context , list)

        }

        @JvmStatic
        @BindingAdapter("back")
        fun backPage(image : ImageView , activity : Activity) {

            activity.finish()


        }



    }


}