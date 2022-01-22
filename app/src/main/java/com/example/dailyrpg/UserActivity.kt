package com.example.dailyrpg

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.dailyrpg.databinding.ActivityMainBinding
import com.example.dailyrpg.databinding.ActivityUserBinding

class UserActivity : AppCompatActivity() {

    private lateinit var binding:ActivityUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val itemTitle=intent.getStringExtra("itemTitle")
        val itemDesc=intent.getStringExtra("itemDesc")
        val imgId=intent.getIntExtra("itemPic",R.drawable.easy)

    }
}