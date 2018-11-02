package com.optus

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.app.ActivityOptionsCompat
import android.view.View
import com.optuds.ActivityBase
import kotlinx.android.synthetic.main.activity_landing.*

class ActivityLanding : ActivityBase(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landing)
        setSupportActionBar(toolbar)

        ScenarioOne.setOnClickListener(this)
        ScenarioTwo.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.ScenarioOne->{

                val intent = Intent(this, ActivityScenarioOne::class.java)
                val activityOptionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(this, ScenarioOne,
                    "profile")
                ActivityCompat.startActivity(this, intent, activityOptionsCompat.toBundle())
            }
            R.id.ScenarioTwo->{
                val intent = Intent(this, ActivityScenarioTwo::class.java)
                val activityOptionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(this, ScenarioTwo,
                    "profile")
                ActivityCompat.startActivity(this, intent, activityOptionsCompat.toBundle())
            }
        }
    }
}
