package com.androidlearn.digiandroid.ui.setting

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.androidlearn.digiandroid.R
import com.androidlearn.digiandroid.databinding.FragmentCategoryBinding
import com.androidlearn.digiandroid.databinding.FragmentSettingBinding


class SettingFragment : Fragment() {

    lateinit var binding : FragmentSettingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = FragmentSettingBinding.inflate(layoutInflater)
        return binding.root
    }

}