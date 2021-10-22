package kr.co.iruy.car_ing

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
class EditorFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_editor, container, false)
    }
    companion object{
        fun newInstant() : EditorFragment
        {
            val args = Bundle()
            val frag = EditorFragment()
            frag.arguments = args
            return frag
        }
    }
}