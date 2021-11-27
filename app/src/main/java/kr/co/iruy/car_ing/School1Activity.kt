package kr.co.iruy.car_ing

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.HandlerThread
import android.os.Looper
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.LinearLayout
import java.util.logging.Handler

class School1Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_school1)
        val to_21 = findViewById<ImageButton>(R.id.to_21)
        to_21.setOnClickListener{
            val intent = Intent(this, School1_2Activity::class.java)
            startActivity(intent)
            overridePendingTransition(0,0)
        }

        val backBT = findViewById<ImageButton>(R.id.backBT)
        backBT.setOnClickListener {
            super.onBackPressed()
        }
    }


}