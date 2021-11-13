package kr.co.iruy.car_ing

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Book3Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book3)
        val bookEndBT = findViewById<Button>(R.id.bookendBT)
        bookEndBT.setOnClickListener{
            val Intent = Intent(this, BookCompActivity::class.java)
            startActivity(Intent)
        }
    }
}