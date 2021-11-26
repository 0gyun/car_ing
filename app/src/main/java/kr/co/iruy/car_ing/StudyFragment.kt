package kr.co.iruy.car_ing

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.RelativeLayout
import androidx.fragment.app.Fragment
import com.kofigyan.stateprogressbar.StateProgressBar

class StudyFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val list = arrayListOf<String>("기본","차박","법규","공학","디자인")
        val v : View = inflater.inflate(R.layout.fragment_study,container,false)
        val tutoRL2 = v.findViewById<RelativeLayout>(R.id.tutoRL2)
        val stateProgressBar = v.findViewById<StateProgressBar>(R.id.your_state_progress_bar_id)
        stateProgressBar.setStateDescriptionData(list)
        val startButton1 = v.findViewById<ImageButton>(R.id.startIB1)
        val startButton2 = v.findViewById<ImageButton>(R.id.startIB2)

        startButton1.setOnClickListener{
            val intent = Intent(getActivity(), NewtutoActivity::class.java)
            getActivity()?.startActivity(intent)
            stateProgressBar.setCurrentStateNumber(StateProgressBar.StateNumber.ONE)
        }
        startButton2.setOnClickListener{
            val intent = Intent(getActivity(), Newtuto2Activity::class.java)
            getActivity()?.startActivity(intent)
            stateProgressBar.setCurrentStateNumber(StateProgressBar.StateNumber.TWO)
        }
        return v
    }
}