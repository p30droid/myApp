package com.androidlearn.digiandroid.ui.productDetail

import android.app.Activity
import android.content.Context
import com.androidlearn.digiandroid.models.News
import androidx.viewpager.widget.PagerAdapter
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import com.androidlearn.digiandroid.R
import androidx.appcompat.widget.AppCompatImageView
import com.androidlearn.digiandroid.models.Gallery
import com.bumptech.glide.Glide

class GalleryAdapter(var context: Context, var galleryList: List<Gallery>) : PagerAdapter() {
    override fun getCount(): Int {
        return galleryList.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view = LayoutInflater.from(context).inflate(R.layout.image_layout, null)
        val image: AppCompatImageView = view.findViewById(R.id.image)
        container.addView(view, 0)
        val (icon) = galleryList[position]

        //  Picasso.get().load(news.getIcon()).into(image);
        Glide.with(view).load(icon).into(image)
        return view
    }
}