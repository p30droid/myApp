package com.androidlearn.digiandroid.ui.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class TabsAdapter(fragmentActivity: FragmentActivity , list : ArrayList<Fragment>) : FragmentStateAdapter(fragmentActivity) {

    var myList = list

    override fun getItemCount(): Int {
      return  myList.size
    }

    override fun createFragment(position: Int): Fragment {
      return  myList.get(position)
    }
}