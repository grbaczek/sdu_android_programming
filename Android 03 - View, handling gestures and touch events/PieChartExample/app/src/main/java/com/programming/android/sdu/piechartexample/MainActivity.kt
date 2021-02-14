package com.programming.android.sdu.piechartexample

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val res = resources
        setContentView(R.layout.activity_main)
        val pie = findViewById<View>(R.id.Pie) as PieChart
        pie.addItem("Agamemnon", 2f, getColor(R.color.seafoam))
        pie.addItem("Bocephus", 3.5f, getColor(R.color.chartreuse))
        pie.addItem("Calliope", 2.5f, getColor(R.color.emerald))
        pie.addItem("Daedalus", 3f, getColor(R.color.bluegrass))
        pie.addItem("Euripides", 1f, getColor(R.color.turquoise))
        pie.addItem("Ganymede", 3f, getColor(R.color.slate))
        (findViewById<View>(R.id.Reset) as Button).setOnClickListener { pie.currentItem = 0 }
    }
}