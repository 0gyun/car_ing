package kr.co.iruy.car_ing

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class StudyFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_study, container, false)
    }
    companion object{
        fun newInstant() : StudyFragment
        {
            val args = Bundle()
            val frag = StudyFragment()
            frag.arguments = args
            return frag
        }
    }
}