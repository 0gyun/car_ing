package kr.co.iruy.car_ing

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class TodayFeed : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.today_feed)


        val back_btn = findViewById<ImageButton>(R.id.today_back_btn)
        back_btn.setOnClickListener{
            finish()
        }
    }

}