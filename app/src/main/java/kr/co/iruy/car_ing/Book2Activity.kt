package kr.co.iruy.car_ing

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Book2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book2)
        val book2 = findViewById<Button>(R.id.book2)
        book2.setOnClickListener{
            val Intent = Intent(this, Book3Activity::class.java)
            startActivity(Intent)
        }
    }
}