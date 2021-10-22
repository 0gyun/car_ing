package kr.co.iruy.car_ing

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class TrendFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_trend, container, false)
    }
    companion object{
        fun newInstant() : TrendFragment
        {
            val args = Bundle()
            val frag = TrendFragment()
            frag.arguments = args
            return frag
        }
    }
}