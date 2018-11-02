package com.optus.adapters


import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.optus.FragmentPagerItem
import com.optus.R


class MyPagerAdapter(fragmentManager: FragmentManager,context: Context) : FragmentPagerAdapter(fragmentManager) {


    val con :Context?

    init {
        con= context
    }

    // Returns total number of pages
    override fun getCount(): Int {
        return NUM_ITEMS
    }

    // Returns the fragment to display for that page
    override fun getItem(position: Int): Fragment? {
        when (position) {
            // Fragment # 0 - This will show FirstFragment
            0 -> {
                val fragment = FragmentPagerItem()
                val bundle = Bundle()
                bundle.putString(FragmentPagerItem.fragmentName, " 1 ")
                bundle.putInt(FragmentPagerItem.fragmentColor, con?.resources?.getColor(R.color.red)!!)
                fragment.arguments = bundle
                return fragment
            }
            1 -> {
                val fragment = FragmentPagerItem()
                val bundle = Bundle()
                bundle.putString(FragmentPagerItem.fragmentName, " 2 ")
                bundle.putInt(FragmentPagerItem.fragmentColor, con?.resources?.getColor(R.color.green)!!)
                fragment.arguments = bundle
                return fragment
            }
            2 -> {
                val fragment = FragmentPagerItem()
                val bundle = Bundle()
                bundle.putString(FragmentPagerItem.fragmentName, " 3 ")
                bundle.putInt(FragmentPagerItem.fragmentColor, con?.resources?.getColor(R.color.blue)!!)
                fragment.arguments = bundle
                return fragment
            }
            3 -> {
                val fragment = FragmentPagerItem()
                val bundle = Bundle()
                bundle.putString(FragmentPagerItem.fragmentName, " 4 ")
                bundle.putInt(FragmentPagerItem.fragmentColor, con?.resources?.getColor(R.color.yellow)!!)
                fragment.arguments = bundle
                return fragment
            }
            else -> return null
        }
    }

    // Returns the page title for the top indicator
//    override fun getPageTitle(position: Int): CharSequence? {
//        return "Page $position"
//    }

    companion object {
        private val NUM_ITEMS = 4
    }

}