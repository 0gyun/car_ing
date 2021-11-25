package kr.co.iruy.car_ing

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import kr.co.iruy.car_ing.Adapter.MyPagerAdapter

class owlCustom : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_owl_custom)

        val btn2 = findViewById<ImageButton>(R.id.btn2)
        btn2.setOnClickListener {
            val intent = Intent(this, MsgActivity::class.java)
            startActivity(intent)
        }
    }
}