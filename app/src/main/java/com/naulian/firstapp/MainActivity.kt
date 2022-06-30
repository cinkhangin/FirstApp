package com.naulian.firstapp

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.naulian.firstapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        viewBinding.apply {
            button.setOnClickListener {
                //txtView.text = "Click"
                //val color = Color.CYAN
                //txtView.setTextColor(color)
                //image.setImageResource(R.mipmap.ic_launcher_round)

                progress.visibility = if (progress.visibility == View.VISIBLE) View.GONE
                else View.VISIBLE
            }
        }
    }

    private fun changeText() {

    }
}