package com.example.tappversion12

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class ActivityGame : AppCompatActivity() {

    private var hungerLevel = 3 //initial hunger levels
    private var hygieneLevel = 3 //initial hygiene levels
    private var healthLevel = 3 //initial health levels

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_game)

        //find views
        val feedButton: Button = findViewById(R.id.feedButton)
        val cleanButton: Button = findViewById(R.id.cleanButton)
        val playButton: Button = findViewById(R.id.playButton)
        val catPicture: ImageView = findViewById(R.id.catPicture)

        //setting onClickListeners for buttons
        feedButton.setOnClickListener { feedPet(catPicture)}
        cleanButton.setOnClickListener { cleanPet(catPicture)}
        playButton.setOnClickListener {playWithPet(catPicture)}

        //update status values initially
        updateStatusValues()
    }

    private fun feedPet(imageView: ImageView){
        //updates pet image to eating
        imageView.setImageResource(R.drawable.eatting)

        //increases hunger levels
        hungerLevel = (hungerLevel + 1).coerceAtMost(5)

        //updates status values
        updateStatusValues()
    }

    private fun cleanPet(imageView: ImageView){
        //updates pet image for playing
        imageView.setImageResource(R.drawable.bathing)

        //increases hygiene levels
        hygieneLevel = (healthLevel + 1).coerceAtMost(5)

        //updates status values
        updateStatusValues()
    }

    private fun playWithPet(imageView: ImageView){
        //update pet image for playing
        imageView.setImageResource(R.drawable.playing)

        //increases health level buy ensures it does not exceed a maximum value
        healthLevel = ( healthLevel + 1).coerceAtMost(5)

        //updates status values
        updateStatusValues()
    }

    @SuppressLint("SetTextI18n")
    private fun updateStatusValues(){

        //update Hunger, Hygiene and Health status values on UI
        val textViewHunger: TextView =findViewById(R.id.textViewHunger)
        val textViewHygiene: TextView = findViewById(R.id.textvViewHygiene)
        val textViewHealth: TextView = findViewById(R.id.textViewHealth)

        //textview status levels
        textViewHunger.text = "Hunger: $hungerLevel/5"
        textViewHygiene.text = "Hygiene: $hygieneLevel/5"
        textViewHealth.text = "Health: $healthLevel/5"
    }
        }
