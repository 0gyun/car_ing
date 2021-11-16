package kr.co.iruy.car_ing

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment

class MessageFragment : Fragment() {

    internal lateinit var preferences:SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val v : View = inflater.inflate(R.layout.fragment_message,container,false)
        val CV = v.findViewById<CardView>(R.id.CV)
        CV.setOnClickListener{
            val intent = Intent(getActivity(), MsgActivity::class.java)
            getActivity()?.startActivity(intent)
        }
        return v
    }

}
