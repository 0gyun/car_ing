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
        var bookmark : Boolean = true
        val master_bookmark = findViewById<ImageButton>(R.id.master_bookmark)
        master_bookmark.setOnClickListener{
            if(bookmark){
                master_bookmark.setImageResource(R.drawable.ic_baseline_bookmark_off)
                bookmark = false
            }
            else{
                master_bookmark.setImageResource(R.drawable.ic_baseline_bookmark24)
                bookmark = true
            }
        }
    }
}