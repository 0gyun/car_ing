package kr.co.iruy.car_ing

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Book2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book2)
        val book3BT = findViewById<Button>(R.id.book3BT)
        book3BT.setOnClickListener{
            val Intent = Intent(this, Book3Activity::class.java)
            startActivity(Intent)
        }
    }
}