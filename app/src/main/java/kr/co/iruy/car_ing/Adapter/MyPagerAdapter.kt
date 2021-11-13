package kr.co.iruy.car_ing.Adapter

import android.os.Parcel
import android.os.Parcelable
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import kr.co.iruy.car_ing.*

class MyPagerAdapter(fm : FragmentManager) : FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        return when (position) { //switch()문과 동일하다.
            0 -> {OwlHomeFragment()}
            1 -> {OwlNewsFragment()}
            2 -> {OwlPhotoFragment()}
            3 -> {OwlMapFragment()}
            else -> {return OwlHomeFragment()}
        }
    }

    override fun getCount(): Int {
        return 4 //4ㄱㅐ
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position){
            0 -> "홈"
            1 -> "소식"
            2 -> "사진"
            3 -> "지도"
            else -> {return "홈"}
        }
    }

}