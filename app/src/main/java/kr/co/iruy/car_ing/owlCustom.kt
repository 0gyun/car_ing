package kr.co.iruy.car_ing

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class owlCustom : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_owl_custom)

        val btn2 = findViewById<ImageButton>(R.id.btn2)
        btn2.setOnClickListener {
            val intent = Intent(this, MsgActivity::class.java)
            startActivity(intent)
        }
        val btn3 = findViewById<ImageButton>(R.id.btn3)
        btn3.setOnClickListener {
            val intent = Intent(this, Book2Activity::class.java)
            startActivity(intent)
        }
    }
}