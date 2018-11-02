package com.optus

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.*
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.optuds.ActivityBase
import com.optus.pojos.PlaceInfo
import com.optus.pojos.Result
import com.optus.utils.FileUtils

import kotlinx.android.synthetic.main.activity_scenario_two.*
import kotlinx.android.synthetic.main.content_activity_scenario_two.*
import java.util.ArrayList

class ActivityScenarioTwo : ActivityBase(), AdapterView.OnItemSelectedListener,View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scenario_two)
        setSupportActionBar(toolbar)

        val inputStream = resources.openRawResource(R.raw.places)
        val json = FileUtils.streamToString(inputStream)

        val gson = Gson()
        val collectionType = object : TypeToken<PlaceInfo>() {}.type
        val placeInfo = gson.fromJson<PlaceInfo>(json, collectionType)
        var results = ArrayList<Result>()

        val result:Result = Result()
        result.name=getString(R.string.selectPlace)
        results.add(result)

        for (result in placeInfo.results!!){
            results.add(result)
        }


        val dataAdapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item, results
        )
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        dataSpinner.setAdapter(dataAdapter)
        dataSpinner.onItemSelectedListener = this

        navigate.setOnClickListener(this)

    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val result =dataSpinner.selectedItem as Result
        if(result.name.equals(getString(R.string.selectPlace)))
            return
        //showToast(result.name)
        modeOfTransport.text = "Mode of Trasnport \n Car " + result.fromcentral?.car + " \n Train " +
                result.fromcentral?.train
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {

    }

    override fun onClick(v: View?) {

        if(v?.id == R.id.navigate){

            val result =dataSpinner.selectedItem as Result
            if(result.name.equals(getString(R.string.selectPlace))){
                showCustomMessage(getString(R.string.selectPrompt))
                return
            }
            val uri = ("http://maps.google.com/maps?f=d&hl=en&daddr=" + result.location?.latitude + ","
                    + result.location?.longitude)
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(uri))

            if (resolveActivity(intent))
                startActivity(intent)
            else{
                showCustomMessage(getString(R.string.noActiviy))
            }
        }
    }

}
