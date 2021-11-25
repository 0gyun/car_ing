package kr.co.iruy.car_ing

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton

class interiorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_interior)

        val btn1 = findViewById<AppCompatButton>(R.id.btn1)
        btn1.setOnClickListener{
            val intent = Intent(this,owlCustom::class.java)
            startActivity(intent)
        }
    }
}