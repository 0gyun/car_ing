package kr.co.iruy.car_ing

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import hotchemi.stringpicker.StringPicker

class MyItemFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_my_item, container, false)
        val list1 = listOf<String>("인테리어","카케어","외장파츠","전자기기","안전용품")
        val stringPicker1 = v.findViewById<StringPicker>(R.id.string_picker1)
        stringPicker1.setValues(list1)

        val list2 = listOf<String>("빗물받이","에어뎀","스포일러","미러","필러")
        val stringPicker2 = v.findViewById<StringPicker>(R.id.string_picker2)
        stringPicker2.setValues(list2)

        return v
    }
    companion object{
        fun newInstant() : MyItemFragment
        {
            val args = Bundle()
            val frag = MyItemFragment()
            frag.arguments = args
            return frag
        }
    }
}