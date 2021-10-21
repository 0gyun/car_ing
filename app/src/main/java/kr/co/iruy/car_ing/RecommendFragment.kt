package kr.co.iruy.car_ing

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.SimpleAdapter
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import kr.co.iruy.car_ing.Adapter.ItemViewPagerAdapter
import kr.co.iruy.car_ing.Adapter.ViewPagerAdapter

class RecommendFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        // fragment_recommend를 inflate하고 그 안에 ViewPager를 adapter를 통해 image 넘길 수 있게
        val view = inflater.inflate(R.layout.fragment_recommend, container, false)
//        val viewPager = view.findViewById<ViewPager>(R.id.view_pager)
//        val viewPager2 = view.findViewById<ViewPager>(R.id.itemViewPager)
//        val adapter = ViewPagerAdapter(requireContext())
//        val item_adapter = ItemViewPagerAdapter(requireContext())
//        viewPager.adapter = adapter
//        viewPager2.adapter = item_adapter
        return view
    }
    companion object{
        fun newInstant() : RecommendFragment
        {
            val args = Bundle()
            val frag = RecommendFragment()
            frag.arguments = args
            return frag
        }
    }
}