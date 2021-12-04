package com.example.l03_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class TabsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tabs)
        val vpAdapter = MyPagerAdapter(supportFragmentManager,
            FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT)

        val vPager = findViewById<View>(R.id.vpager) as ViewPager
        vPager.adapter = vpAdapter    // or vPager.setAdapter(vpAdapter)

        val tabLayout = findViewById<View>(R.id.tabs) as TabLayout
        tabLayout.setupWithViewPager(vPager)
        tabLayout.getTabAt(0)!!.text = "tab 1"
        tabLayout.getTabAt(1)!!.text = "tab 2"
//        tabLayout.getTabAt(1)!!.setIcon(vPager.currentItem.arguments.)
    }
}
