package kr.co.iruy.car_ing

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Newtuto2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_newtuto2)
        val btn = findViewById<Button>(R.id.button)
        btn.setOnClickListener{
            val intent = Intent(this, School1Activity::class.java)
            startActivity(intent)
        }
        val btn2 = findViewById<Button>(R.id.t2_stage2_btn)
        btn2.setOnClickListener {
            val intent = Intent(this, School2Activity::class.java)
            startActivity(intent)
        }
    }
}