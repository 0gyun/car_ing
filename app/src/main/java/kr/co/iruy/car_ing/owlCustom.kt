package kr.co.iruy.car_ing

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AlphaAnimation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageButton
import android.widget.LinearLayout
import androidx.cardview.widget.CardView

class owlCustom : AppCompatActivity() {
    private val review_btn : ImageButton by lazy{
        findViewById<ImageButton>(R.id.review_show_btn)
    }
    private val review : LinearLayout by lazy{
        findViewById<LinearLayout>(R.id.review)
    }
    var click_review = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_owl_custom)
        review_btn.setOnClickListener{
            if (click_review){
                click_review = false
                review.visibility = View.INVISIBLE
            }
            else{
                click_review = true
                review.visibility = View.VISIBLE
            }
        }
    }
}