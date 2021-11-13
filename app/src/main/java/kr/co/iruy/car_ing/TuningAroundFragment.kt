package kr.co.iruy.car_ing

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment

class TuningAroundFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_tuning_around, container, false)

        val start_btn = view.findViewById<Button>(R.id.start_btn)
        start_btn.setOnClickListener{
            val intent = Intent(getActivity(), owlCustom::class.java)
            getActivity()?.startActivity(intent)
        }
        return view
    }

}