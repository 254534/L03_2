package com.example.l03_1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioGroup
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class Fragment1 : Fragment() {
    lateinit var f11: Fragment11
    lateinit var f12: Fragment12
    lateinit var myTrans: FragmentTransaction
    private val TAG_F11 = "Fragment11"
    private val TAG_F12 = "Fragment12"

    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (savedInstanceState == null) {
            f11 = Fragment11()
            f12 = Fragment12()
            myTrans = childFragmentManager.beginTransaction()
            myTrans.add(R.id.fg_container2, f11, this.TAG_F11)
            myTrans.detach(f11)
            myTrans.add(R.id.fg_container2, f12, this.TAG_F12)
            myTrans.detach(f12)
            myTrans.commit()
        } else {
            f11 = childFragmentManager.findFragmentByTag(this.TAG_F11) as Fragment11
            f12 = childFragmentManager.findFragmentByTag(this.TAG_F12) as Fragment12
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity().findViewById(R.id.f1options) as RadioGroup)
            .setOnCheckedChangeListener(radioGroupListener)

        navController = view.findNavController()
        val button1: Button = requireActivity().findViewById(R.id.button1)
        button1.setOnClickListener {
            view.findNavController().navigate(R.id.action_fragment1_to_tabsActivity)
        }
        val button2: Button = requireActivity().findViewById(R.id.button2)
        button2.setOnClickListener {
            view.findNavController().navigate(R.id.action_fragment1_to_tabsActivity2)
        }

        val bnNavView =
            requireActivity().findViewById<View>(R.id.bottom_nav) as BottomNavigationView
        bnNavView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.button1_m -> navController.navigate(R.id.tabsFragment)
                R.id.button2_m -> navController.navigate(R.id.fragment1)
                R.id.button3_m -> navController.navigate(R.id.swipeFragment)
            }
            true
        }
    }

    val radioGroupListener = RadioGroup.OnCheckedChangeListener { group, checkedId ->
        myTrans = childFragmentManager.beginTransaction()
        when (checkedId) {
            R.id.radioButton1 -> {
                myTrans.detach(f12)
                myTrans.attach(f11)
            }
            R.id.radioButton2 -> {
                myTrans.detach(f11)
                myTrans.attach(f12)
            }
        }
        myTrans.commit()
    }
}