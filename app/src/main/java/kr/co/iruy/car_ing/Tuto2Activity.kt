package kr.co.iruy.car_ing

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class Tuto2Activity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_newtuto2)
        val btn = findViewById<Button>(R.id.button)
        btn.setOnClickListener{
            val intent = Intent(this, School1Activity::class.java)
            startActivity(intent)
        }
    }
}