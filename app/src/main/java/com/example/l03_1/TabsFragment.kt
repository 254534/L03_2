package com.example.l03_1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class TabsFragment : Fragment() {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val vpAdapter = MyPagerAdapter3(this)

        val vPager = view.findViewById<ViewPager2>(R.id.vpager2Tabs)
        vPager.adapter = vpAdapter

        val tabLayout = view.findViewById<TabLayout>(R.id.tabs2Tabs)

        TabLayoutMediator(tabLayout, vPager) { tab, position ->
            tab.text = "Tab ${(position + 1)}"
//            tab.setIcon(tabIcons[0])
        }.attach()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tabs, container, false)
    }
}