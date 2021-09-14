package kr.co.iruy.car_ing

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.PorterDuff
import android.os.Bundle
import android.os.Handler
import android.text.Editable
import android.text.TextWatcher
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.google.android.material.textfield.TextInputEditText

class SplashActivity: AppCompatActivity(){
    private val time: Long = 1000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.background_splash)

        Handler().postDelayed({
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }, 3000)

    }

}

class LoginActivity : AppCompatActivity() {
    private val caringImageview : ImageView by lazy{
        findViewById<ImageView>(R.id.caringImageview)
    }
    private val signUpButton: Button by lazy {
        findViewById<Button>(R.id.signup_button)
    }
    private val loginButton: Button by lazy {
        findViewById<Button>(R.id.login_button)
    }
    private val idTextview: TextView by lazy {
        findViewById<TextView>(R.id.idTextview)
    }
    private val passwordTextView: TextView by lazy {
        findViewById<TextView>(R.id.passwordTextview)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        // 로고 색상 변경
        caringImageview.setColorFilter(Color.parseColor("#FFE816"),PorterDuff.Mode.SRC_IN)
        // 회원 가입 클릭시
        signUpButton.setOnClickListener {
            val intent = Intent(this, signUpActivity::class.java)
            startActivity(intent)
        }
        // 로그인 버튼 클릭시
        loginButton.setOnClickListener {
            // 키보드 내리기
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(idTextview.windowToken, 0)
            imm.hideSoftInputFromWindow(passwordTextView.windowToken, 0)

            // 메인 피드로 화면전환 (로그인 확인 아직 구현 x)
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}

class signUpActivity : AppCompatActivity() {
    val emailValid = Regex("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+.[A-Za-z]{2,}\$")
    private val signupEndButton: Button by lazy {
        findViewById<Button>(R.id.signupEndButton)
    }
    private val tietemail: TextInputEditText by lazy {
        findViewById<TextInputEditText>(R.id.tiet_email)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)


        signupEndButton.setOnClickListener {
            // 메인 피드로 화면전환
            if (!checkEmail()) {
                Toast.makeText(applicationContext, "이메일 형식에 맞게 입력하세요!!", Toast.LENGTH_LONG).show()
            } else {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                Toast.makeText(this, "회원가입이 완료되었습니다. ", Toast.LENGTH_LONG).show()
            }
        }

        tietemail.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                checkEmail()
            }
        })
    }
    fun checkEmail(): Boolean {
        var getEmail = tietemail.text.toString().trim()
        if (emailValid.matches(getEmail)) {
            tietemail.error = null
            return true
        } else {
            tietemail.error = "이메일 형식에 맞지 않습니다."
            return false
        }

    }

}

class MainActivity : AppCompatActivity() {
    var tsImgRes = intArrayOf(
        R.drawable.bom1,R.drawable.bom1,R.drawable.bom1,R.drawable.bom1,
        R.drawable.bom1,R.drawable.bom1,R.drawable.bom1,R.drawable.bom1
    )
    var tsTag = arrayOf("태그","태그","태그","태그","태그","태그","태그","태그")
    var tsTitle = arrayOf("제목","제목","제목","제목","제목","제목","제목","제목")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 화면 전환
        val pagerAdapter = FragmentAdapter(supportFragmentManager)
        val pager = findViewById<ViewPager>(R.id.viewPager)
        pager.adapter = pagerAdapter
        val tab = findViewById<TabLayout>(R.id.tab)
        tab.setupWithViewPager(pager)

    }
    // 뒤로 가기 버튼 막기
    override fun onBackPressed() {
        super.onBackPressed() //막고 싶으면 여기 주석처리
    }
}

class FragmentAdapter (fm : FragmentManager): FragmentPagerAdapter(fm) {
    // 포지션 따라 이동
    override fun getItem(position: Int): Fragment {
        val fragment = when(position)
        {
            0 -> RecommendFragment.newInstant()
            1 -> PlazaFragment.newInstant()
            2 -> EditorFragment.newInstant()
            3 -> TrendFragment.newInstant()
            4 -> StudyFragment.newInstant()
            else -> RecommendFragment.newInstant()
        }
        return fragment
    }

    override fun getCount(): Int = 5

    override fun getPageTitle(position: Int): CharSequence? {
        val title = when(position)
        {
            0 -> "맞춤추천"
            1 -> "광장"
            2 -> "에디터"
            3 -> "트랜드"
            4 -> "학습"
            else -> "맞춤추천"
        }
        return title
    }
}




