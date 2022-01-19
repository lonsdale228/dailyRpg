package com.example.dailyrpg

import android.app.ActionBar
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RelativeLayout
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_first.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //Nav Control
        val bottomNavigationView=findViewById<BottomNavigationView>(R.id.bottomNavigationView)//initialize
        val navController=findNavController(R.id.fragment) //initialize
        bottomNavigationView.setupWithNavController(navController) // connect to navController
       // navController.navigate(R.id.secondFragment) //move to fragment
        bottomNavigationView.setItemTextAppearanceActive(R.style.MenuItemsActive);
        bottomNavigationView.setItemTextAppearanceInactive(R.style.MenuItemsInactive);


      //  val secFragment= secondFragment()
      //  supportFragmentManager.beginTransaction().replace(R.id.bottomNavigationView,secFragment).commit()


    }
}