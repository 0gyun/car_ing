package kr.co.iruy.car_ing

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class MasterFeed : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.master_feed)


        val back_btn = findViewById<ImageButton>(R.id.master_back_btn)
        back_btn.setOnClickListener{
            finish()
        }
    }
}