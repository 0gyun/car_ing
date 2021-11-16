package kr.co.iruy.car_ing

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class TodayFeed : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.today_feed)


        val back_btn = findViewById<ImageButton>(R.id.today_back_btn)
        back_btn.setOnClickListener{
            finish()
        }

        var info_on : Boolean = false
        val item_info_btn = findViewById<ImageButton>(R.id.today_item_info_button)
        val item_info_1 = findViewById<ImageView>(R.id.item_info1)
        val item_info_2 = findViewById<ImageView>(R.id.item_info2)
        item_info_btn.setOnClickListener{
            if(info_on){
                item_info_btn.setImageResource(R.drawable.ic_hide_item)
                item_info_1.visibility = View.INVISIBLE
                item_info_2.visibility = View.INVISIBLE
                info_on = false
            }
            else{
                item_info_btn.setImageResource(R.drawable.ic_show_item)
                item_info_1.visibility = View.VISIBLE
                item_info_2.visibility = View.VISIBLE
                info_on = true
            }
        }
    }

}