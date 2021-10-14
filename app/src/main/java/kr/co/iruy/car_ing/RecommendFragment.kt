package kr.co.iruy.car_ing

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.Fragment
class RecommendFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v : View = inflater.inflate(R.layout.fragment_recommend,container,false)
        val imageView = v.findViewById<ImageButton>(R.id.meetMasterIV)
        imageView.setOnClickListener {
            val intent = Intent(activity,PhotoActivity::class.java)
            startActivity(intent)
        }
        return v
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