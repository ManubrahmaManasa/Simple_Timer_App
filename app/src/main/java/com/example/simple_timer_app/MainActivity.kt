package com.example.simple_timer_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val seekBar : SeekBar = findViewById(R.id.seekBar)
        val timer : TextView = findViewById(R.id.timer)
        val reset : Button = findViewById(R.id.button)
        val initialvalue = timer.translationY

        seekBar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                timer.text = p1.toString()

                val translationdist =(initialvalue + p1 * resources.getDimension(R.dimen.text_anime) * -1)

                timer.animate().translationY(translationdist)
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {

            }
        })
        reset.setOnClickListener{ v ->
            seekBar.progress = 0
            timer.animate().setDuration(500).rotationBy(360f).translationY(initialvalue)

        }

    }
}
