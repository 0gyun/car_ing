package kr.co.iruy.car_ing

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
        val fragmentAdapter = MyPagerAdapter(supportFragmentManager)
        val VP = findViewById<ViewPager>(R.id.VP)
        val TL = findViewById<TabLayout>(R.id.TL)
        VP.adapter = fragmentAdapter
        TL.setupWithViewPager(VP)

    }
}