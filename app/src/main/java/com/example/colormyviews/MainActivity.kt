package com.example.colormyviews

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.colormyviews.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setListeners()
    }

    /**
     * Attaches listeners to all the views.
     */
    private fun setListeners() {
        val box_one_text = binding.boxOneText
        val box_two_text = binding.boxTwoText
        var box_three_text = binding.boxThreeText
        var box_four_text = binding.boxFourText
        var box_five_text = binding.boxFiveText
        val red_button = binding.redButton
        val yellow_button = binding.yellowButton
        val green_button = binding.greenButton

        val clickableViews: List<View> =
            listOf(box_one_text, box_two_text, box_three_text,
                box_four_text, box_five_text, red_button, yellow_button, green_button)

        for (item in clickableViews) {
            item.setOnClickListener { makeColored(it) }
        }
    }

    /**
     * Sets the background color of a view depending on it's resource id.
     * This is a way of using one click handler to do similar operations on a group of views.
     *
     * Demonstrates three different ways of setting colors.
     *     * Using a color constant from the Color class.
     *     * Using an Android color resource
     *     * Using a custom color defined in color.xml
     */
    private fun makeColored(view: View) {
        when (view.id) {

            // Boxes using Color class colors for background
            R.id.box_one_text -> view.setBackgroundColor(Color.DKGRAY)
            R.id.box_two_text -> view.setBackgroundColor(Color.GRAY)

            // Boxes using Android color resources for background
            R.id.box_three_text -> view.setBackgroundResource(android.R.color.holo_green_light)
            R.id.box_four_text -> view.setBackgroundResource(android.R.color.holo_green_dark)
            R.id.box_five_text -> view.setBackgroundResource(android.R.color.holo_green_light)

            // Boxes using custom color resources for background
            R.id.red_button -> binding.boxThreeText.setBackgroundColor(getResources().getColor(R.color.my_red))
            R.id.yellow_button -> binding.boxFourText.setBackgroundColor(getResources().getColor(R.color.my_yellow))
            R.id.green_button -> binding.boxFiveText.setBackgroundColor(getResources().getColor(R.color.my_green))

            else -> view.setBackgroundColor(Color.LTGRAY)
        }
    }
}
