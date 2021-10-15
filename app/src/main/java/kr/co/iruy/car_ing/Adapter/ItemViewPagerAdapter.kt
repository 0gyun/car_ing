package kr.co.iruy.car_ing.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import kr.co.iruy.car_ing.R

class ItemViewPagerAdapter(private val c : Context) : PagerAdapter() {
    // info about LayoutInflater
    private lateinit var li: LayoutInflater

    private val photo_list = arrayOf(
        R.drawable.c1,
        R.drawable.c2,
        R.drawable.c3,
        R.drawable.c4,
        R.drawable.c5,
    )

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    // view's size return
    override fun getCount(): Int {
        return photo_list.size
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        // get LayoutInflater from Context
        li = c.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        // viewpager_image.xml과 LayoutInflater를 통해 new view
        val v = li!!.inflate(R.layout.square_feed,null)
        // viewpager_image.xml 내부의 ImageView
        val iv = v.findViewById<ImageView>(R.id.feed_image)
        // 사진 리스트로 image resource 세팅
        iv.setImageResource(photo_list[position])

        container.addView(v, 0)

        return v
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.invalidate()
    }
}