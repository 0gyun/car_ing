package kr.co.iruy.car_ing

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.Fragment

class PlazaFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v : View = inflater.inflate(R.layout.fragment_plaza,container,false)
        val plazaIB = v.findViewById<ImageButton>(R.id.plazaIB)
        plazaIB.setOnClickListener {
            val intent = Intent(activity, FeedActivity::class.java)
            startActivity(intent)
        }
        return v
    }
    companion object{
        fun newInstant() : PlazaFragment
        {
            val args = Bundle()
            val frag = PlazaFragment()
            frag.arguments = args
            return frag
        }
    }
}