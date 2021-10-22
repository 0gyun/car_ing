package kr.co.iruy.car_ing

import android.animation.ObjectAnimator
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import kr.co.iruy.car_ing.Adapter.ProfileFragmentAdapter

class FeedActivity : AppCompatActivity() {
    private val profileBT: Button by lazy {
        findViewById<AppCompatButton>(R.id.profileBT)
    }
    private val viewPager: ViewPager by lazy {
        findViewById<ViewPager>(R.id.viewPager)
    }
    private val tab : TabLayout by lazy {
        findViewById<TabLayout>(R.id.tab)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feed)

        // 프래그먼트
        val pagerAdapter = ProfileFragmentAdapter(supportFragmentManager)
        viewPager.adapter = pagerAdapter
        tab.setupWithViewPager(viewPager)

        // 버튼 올라가기
        var isViewOpen = false
        profileBT.setOnClickListener{
            if (isViewOpen){
                profileBT.setText("▲")
                ObjectAnimator.ofFloat(profileBT,"translationY",0f).apply { start() }
                ObjectAnimator.ofFloat(viewPager,"translationY",0f).apply { start() }
                ObjectAnimator.ofFloat(tab,"translationY",0f).apply { start() }
                isViewOpen = false
            }
            else{
                profileBT.setText("▼")
                ObjectAnimator.ofFloat(profileBT,"translationY",-1700f).apply { start() }
                ObjectAnimator.ofFloat(viewPager,"translationY",-1700f).apply { start() }
                ObjectAnimator.ofFloat(tab,"translationY",-1700f).apply { start() }
                isViewOpen = true
            }
        }
    }
}