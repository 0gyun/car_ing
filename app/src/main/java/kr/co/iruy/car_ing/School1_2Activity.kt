package kr.co.iruy.car_ing

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import androidx.cardview.widget.CardView
import kr.co.iruy.car_ing.R

class School1_2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_school12)
        val backBT = findViewById<ImageButton>(R.id.backBT)
        backBT.setOnClickListener {
            super.onBackPressed()
        }
        var to_school_btn = findViewById<ImageButton>(R.id.stage1_to_school_btn)
        to_school_btn.setOnClickListener {
            var intent = Intent(this, Newtuto2Activity::class.java)
            intent.putExtra("star", 3)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
        }
    }
    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(0,0)
    }
}