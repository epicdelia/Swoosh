package com.epicdelia.swoosh.Controller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.epicdelia.swoosh.Utilities.EXTRA_LEAGUE
import com.epicdelia.swoosh.R
import com.epicdelia.swoosh.Utilities.EXTRA_SKILL
import kotlinx.android.synthetic.main.activity_skill.*

class SkillActivity : AppCompatActivity() {

    var league = ""
    var skill = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill)
        league = intent.getStringExtra(EXTRA_LEAGUE)
        println("THIS IS" + league)
    }

    fun ballerbuttonClicked (view: View){
        beginnerbutton.isChecked = false
        skill = "baller"
    }

    fun beginnerbuttonClicked (view: View){
        ballerbutton.isChecked = false
        skill = "beginner"
    }

    fun finishbuttonClicked (view: View){
        if(skill != ""){
            val finishActivity = Intent(this, FinishActivity::class.java)
            finishActivity.putExtra(EXTRA_LEAGUE, league)
            finishActivity.putExtra(EXTRA_SKILL, skill)
            startActivity(finishActivity)
        }
        else{
            Toast.makeText(this, "Please select a skill level", Toast.LENGTH_SHORT).show()
        }


    }
}
