package com.purnendu.paint

import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_NO
import androidx.databinding.DataBindingUtil
import com.purnendu.paint.PaintView.Companion.colorList
import com.purnendu.paint.PaintView.Companion.currentBrush
import com.purnendu.paint.PaintView.Companion.pathList
import com.purnendu.paint.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    companion object {
        var path = Path()
        var paintBrush = Paint()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_NO)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.apply {
            redColor.setOnClickListener { changeColor(Color.RED) }
            blueColor.setOnClickListener {  changeColor(Color.BLUE)}
                blackColor.setOnClickListener {  changeColor(Color.BLACK) }
                whiteColor.setOnClickListener {  pathList.clear()
                                                 colorList.clear()
                                                 path.reset()}

        }
    }

    private fun changeColor(color:Int)
    {
        paintBrush.color=color
        currentBrush=color
       path=Path()

    }
}