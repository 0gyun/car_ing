package kr.co.iruy.car_ing

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import androidx.cardview.widget.CardView

class School2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_school2)

        val backBT = findViewById<ImageButton>(R.id.tuto2_back_btn)
        backBT.setOnClickListener {
            super.onBackPressed()
        }

    }
}