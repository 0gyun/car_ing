package kr.co.iruy.car_ing

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MessageActivity:AppCompatActivity() {
    internal lateinit var preferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



    }

    fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        preferences = getSharedPreferences("USERSIGN", Context.MODE_PRIVATE)!!
        val editor = preferences.edit()
        val v : View = inflater.inflate(R.layout.fragment_message,container,false)
        val buttonACB = v.findViewById<Button>(R.id.messageACB)
        val textName = v.findViewById<TextView>(R.id.profileName)

        buttonACB.setOnClickListener {
            Toast.makeText(this,"ffd", Toast.LENGTH_SHORT).show()
            editor.putString("name",textName.text.toString())
            val intent = Intent(this,ChatRoomActivity::class.java)
            startActivity(intent)
        }
        return v
    }
}