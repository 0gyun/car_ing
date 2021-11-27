package kr.co.iruy.car_ing

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class Newtuto2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_newtuto2)
        if(intent.hasExtra("star")){
            var star = findViewById<ImageView>(R.id.t2_stage1_star)
            star.setImageResource(R.drawable.ic_star_full)
            var num = findViewById<TextView>(R.id.star_num)
            num.setText("3 / 12")
        }
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

        val back_btn = findViewById<ImageButton>(R.id.tuto2_back_btn)
        back_btn.setOnClickListener {
            super.onBackPressed()
        }
    }
}