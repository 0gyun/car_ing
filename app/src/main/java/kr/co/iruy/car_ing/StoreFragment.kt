package kr.co.iruy.car_ing

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import kr.co.iruy.car_ing.Adapter.SectionPagerAdapter

class StoreFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_store,container,false)
        val goMaker = view.findViewById<CardView>(R.id.goMaker)
        goMaker.setOnClickListener{
            val intent = Intent(getActivity(), ModelActivity::class.java)
            getActivity()?.startActivity(intent)
        }
        return view
    }
    companion object{
        fun newInstant() : SqaureFragment
        {
            val args = Bundle()
            val frag = SqaureFragment()
            frag.arguments = args
            return frag
        }
    }
}