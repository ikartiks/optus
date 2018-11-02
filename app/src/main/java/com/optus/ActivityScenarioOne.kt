package com.optus

import android.graphics.Color
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.view.View.OnClickListener
import android.widget.LinearLayout
import com.kartik.grevocab.adapters.GroupsRecyclerAdapter
import com.optuds.ActivityBase
import com.optus.adapters.MyPagerAdapter
import kotlinx.android.synthetic.main.activity_scenario_one.*
import java.util.*

class ActivityScenarioOne : ActivityBase(),GroupsRecyclerAdapter.OnItemClickListener, OnClickListener {



    internal lateinit var groups: ArrayList<Group>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scenario_one)
        setSupportActionBar(toolbar)


        green.setOnClickListener(this)
        blue.setOnClickListener(this)
        red.setOnClickListener(this)

        val item1 = Group("First item","Ones description")
        val item2 = Group("Second item","Two description")
        val item3 = Group("Third item","Three description")
        val item4 = Group("Fourth item","Four description")
        val item5 = Group("Fifth item","Five description")

        groups = ArrayList()
        groups.add(item1)
        groups.add(item2)
        groups.add(item3)
        groups.add(item4)
        groups.add(item5)


        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        groupRecylerView.setHasFixedSize(true)

        // use a linear layout manager
        val mLayoutManager = LinearLayoutManager(this)
        mLayoutManager.orientation = LinearLayoutManager.HORIZONTAL
        mLayoutManager.reverseLayout = false
        groupRecylerView.layoutManager = mLayoutManager
        groupRecylerView.itemAnimator = DefaultItemAnimator()

        val adapter: GroupsRecyclerAdapter = GroupsRecyclerAdapter(groups)
        adapter.setOnItemClickLickListener(this)
        groupRecylerView.adapter = adapter


        viewPager.adapter = MyPagerAdapter(supportFragmentManager,this)
        slidingTabs.setupWithViewPager(viewPager, true)
    }

    override fun onItemClick(view: View, position: Int) {


        val i = groups[position]
        //log("moved to $position")
        //showToast(i.name!!)
        pointFourText.setText(i?.name+" - "+i?.description)
    }

    override fun onClick(v: View?) {
        //
        when (v?.id) {
            // Fragment # 0 - This will show FirstFragment
            R.id.red -> {
                changeBg.setBackgroundColor(Color.RED)
            }
            R.id.green -> {
                changeBg.setBackgroundColor(Color.GREEN)
            }
            R.id.blue -> {
                changeBg.setBackgroundColor(Color.BLUE)
            }
            else -> return
        }
    }

}
