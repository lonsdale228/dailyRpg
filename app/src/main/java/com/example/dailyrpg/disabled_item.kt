package com.example.dailyrpg

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.R
import android.content.Context
import android.graphics.Color

import android.graphics.drawable.ColorDrawable
import androidx.test.core.app.ApplicationProvider

import androidx.test.core.app.ApplicationProvider.getApplicationContext
import kotlinx.android.synthetic.main.fragment_disabled_item.*


class disabled_item : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        var view: View? = null
        view = inflater.inflate(com.example.dailyrpg.R.layout.fragment_disabled_item, container, false)




        return view
    }


}