package com.example.l03_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class TabsActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tabs2)

        var vpAdapter = MyPagerAdapter2(this)

        val vPager = findViewById<View>(R.id.vpager2) as ViewPager2
//        vPager.adapter = vpAdapter    // or
         vPager.setAdapter(vpAdapter)
//
        val tabLayout = findViewById<View>(R.id.tabs2) as TabLayout
//        tabLayout.setTabsFromPagerAdapter(vpAdapter)
//
        TabLayoutMediator(tabLayout, vPager) { tab, position ->
            tab.text = "Tab ${(position + 1)}"
//            tab.setIcon(tabIcons[0])
        }.attach()


    }
}