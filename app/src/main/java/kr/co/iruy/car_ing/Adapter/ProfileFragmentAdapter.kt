package kr.co.iruy.car_ing.Adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import kr.co.iruy.car_ing.BasketFragment
import kr.co.iruy.car_ing.MyItemFragment
import kr.co.iruy.car_ing.SaveContentFragment

class ProfileFragmentAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
    //position 에 따라 원하는 Fragment로 이동시키기
    override fun getItem(position: Int): Fragment {
        val fragment = when (position) {
            0 -> BasketFragment.newInstant()
            1 -> MyItemFragment.newInstant()
            2 -> SaveContentFragment.newInstant()
            else -> BasketFragment.newInstant()
        }
        return fragment
    }

    //tab의 개수만큼 return
    override fun getCount(): Int = 3

    //tab의 이름 fragment마다 바꾸게 하기
    override fun getPageTitle(position: Int): CharSequence? {
        val title = when (position) {
            0 -> "장바구니"
            1 -> "내 아이템"
            2 -> "저장한 콘텐츠"
            else -> "장바구니"
        }
        return title
    }
}