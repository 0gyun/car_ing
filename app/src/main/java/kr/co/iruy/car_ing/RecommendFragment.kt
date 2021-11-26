package kr.co.iruy.car_ing

import android.content.Intent
import android.graphics.Paint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment

class RecommendFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_recommend, container, false)

        val today = view.findViewById<CardView>(R.id.today)
        today.setOnClickListener{
            val intent = Intent(getActivity(), TodayFeed::class.java)
            getActivity()?.startActivity(intent)
        }

        val master = view.findViewById<Button>(R.id.master_btn)
        master.setOnClickListener{
            val intent =Intent(getActivity(), MasterFeed::class.java)
            getActivity()?.startActivity(intent)
        }
        val item1_cost = view.findViewById<TextView>(R.id.item1_cost)
        item1_cost.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG)
        val item2_cost = view.findViewById<TextView>(R.id.item2_cost)
        item2_cost.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG)
        val item3_cost = view.findViewById<TextView>(R.id.item3_cost)
        item3_cost.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG)

        val makerBT = view.findViewById<AppCompatButton>(R.id.makerBT)
        makerBT.setOnClickListener{
            val intent = Intent(getActivity(), ModelActivity::class.java)
            getActivity()?.startActivity(intent)
        }

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