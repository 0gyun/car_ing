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
        // Inflate the layout for this fragment
        preferences = activity?.getSharedPreferences("USERSIGN", Context.MODE_PRIVATE)!!
        val editor = preferences.edit()
        val v : View = inflater.inflate(R.layout.fragment_message,container,false)
        val buttonACB = v.findViewById<Button>(R.id.messageACB)
        val textName = v.findViewById<TextView>(R.id.profileName)

        buttonACB.setOnClickListener {
            Toast.makeText(activity,"ffd",Toast.LENGTH_SHORT).show()
            editor.putString("name",textName.text.toString())
            val intent = Intent(activity,ChatRoomActivity::class.java)
            startActivity(intent)
        }
        return v
    }

}
