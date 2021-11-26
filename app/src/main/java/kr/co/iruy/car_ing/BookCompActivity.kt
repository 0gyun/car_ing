package kr.co.iruy.car_ing

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton

class BookCompActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_comp)
        val goProfile = findViewById<AppCompatButton>(R.id.goProfile)
        val goStore = findViewById<AppCompatButton>(R.id.goStore)

        goProfile.setOnClickListener{
            val intent = Intent(this,MainActivity::class.java)
            intent.putExtra("시작위치","2")
            startActivity(intent)
        }
        goStore.setOnClickListener{
            val intent = Intent(this,MainActivity::class.java)
            intent.putExtra("시작위치","1")
            startActivity(intent)
        }
    }
}