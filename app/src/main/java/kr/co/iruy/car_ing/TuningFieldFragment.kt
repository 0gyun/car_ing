package kr.co.iruy.car_ing

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import kr.co.iruy.car_ing.Adapter.SectionPagerAdapter


class TuningFieldFragment : Fragment() {
    lateinit var myFragment: View
    lateinit var tabLayouts: TabLayout
    lateinit var viewPagers: ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        myFragment = inflater.inflate(R.layout.fragment_tuning_field, container, false)
        return myFragment
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setUpViewPager()
        tabLayouts.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabReselected(tab: TabLayout.Tab?) {

            }
            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }
            override fun onTabSelected(tab: TabLayout.Tab?) {

            }
        })
    }
    private fun setUpViewPager() {
        viewPagers = myFragment.findViewById(R.id.viewPager)
        tabLayouts = myFragment.findViewById(R.id.tabLayout)

        var adapter = SectionPagerAdapter(childFragmentManager)
        adapter.addFragment(FieldExteriorFragment(), "외장")
        adapter.addFragment(FieldInteriorFragment(),"내장")
        adapter.addFragment(FieldPerformanceFragment(),"성능")
        adapter.addFragment(FieldEtcFragment(),"기타")
        adapter.addFragment(FieldRecoverFragment(),"복구")

        viewPagers!!.adapter = adapter
        tabLayouts!!.setupWithViewPager(viewPagers)

    }
}