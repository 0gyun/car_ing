package kr.co.iruy.car_ing

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment

class BasketFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v: View = inflater.inflate(R.layout.fragment_square, container, false)
        val squareCV = v.findViewById<CardView>(R.id.squareCV)
        squareCV.setOnClickListener {
            val intent = Intent(activity, FeedActivity::class.java)
            startActivity(intent)
        }
        return v
    }

    companion object {
        fun newInstant(): BasketFragment {
            val args = Bundle()
            val frag = BasketFragment()
        }
    }
}