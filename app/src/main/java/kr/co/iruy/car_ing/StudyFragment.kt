package kr.co.iruy.car_ing

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import com.kofigyan.stateprogressbar.StateProgressBar

class StudyFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v : View = inflater.inflate(R.layout.fragment_study,container,false)
        val stateProgressBar = v.findViewById<StateProgressBar>(R.id.your_state_progress_bar_id)
        val startButton1 = v.findViewById<ImageButton>(R.id.startIB1)
        val startButton2 = v.findViewById<ImageButton>(R.id.startIB2)
        startButton1.setOnClickListener{
            stateProgressBar.setCurrentStateNumber(StateProgressBar.StateNumber.TWO)
        }
        startButton2.setOnClickListener{
            stateProgressBar.setCurrentStateNumber(StateProgressBar.StateNumber.THREE)
        }

        return v
    }
    companion object{
        fun newInstant() : StudyFragment
        {
            val args = Bundle()
            val frag = StudyFragment()
            frag.arguments = args
            return frag
        }
    }
}