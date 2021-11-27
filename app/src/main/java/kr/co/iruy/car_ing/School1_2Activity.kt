package kr.co.iruy.car_ing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import kr.co.iruy.car_ing.R

class School1_2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_school12)
        val backBT = findViewById<ImageButton>(R.id.backBT)
        backBT.setOnClickListener {
            super.onBackPressed()
        }
    }
    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(0,0)
    }
}