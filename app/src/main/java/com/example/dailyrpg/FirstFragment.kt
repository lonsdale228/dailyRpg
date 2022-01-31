package com.example.dailyrpg

import addChildFragment
import android.app.ActionBar
import android.app.Activity
import android.app.Application
import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.*
import android.view.animation.AnimationUtils
import androidx.fragment.app.Fragment
import android.widget.*
import androidx.annotation.NonNull
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.activity_dialog.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_first.*
import kotlinx.android.synthetic.main.single_item.*



class FirstFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }



    private lateinit var currentFragment: Fragment

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var view: View? = null
        view = inflater.inflate(R.layout.fragment_first, container, false)

        childFragmentManager.beginTransaction().replace(R.id.navContainer,active_item()).commit()
        val navView:BottomNavigationView=view.findViewById(R.id.topNavView)
        navView.setOnItemReselectedListener {  }

        navView.itemTextAppearanceActive=R.style.MenuTopItemsActive
        navView.itemTextAppearanceInactive=R.style.MenuTopItemsActive

        navView.setOnItemSelectedListener {
           when (it.itemId){
               R.id.current->currentFragment=active_item()
               R.id.finished->currentFragment=disabled_item()

           }
            childFragmentManager.beginTransaction().replace(R.id.navContainer,currentFragment).commit()
            true
        }

        navView.setItemTextAppearanceActive(R.style.MenuItemsActive);
        navView.setItemTextAppearanceInactive(R.style.MenuItemsInactive);




        return view
    }



}