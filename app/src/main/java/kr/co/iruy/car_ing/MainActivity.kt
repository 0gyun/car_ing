package kr.co.iruy.car_ing

import android.animation.ObjectAnimator
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
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.textfield.TextInputEditText

class SplashActivity : AppCompatActivity() {
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
    private val caringImageview: ImageView by lazy {
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
        caringImageview.setColorFilter(Color.parseColor("#FFE816"), PorterDuff.Mode.SRC_IN)
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
    private val fabList : FloatingActionButton by lazy{
        findViewById<FloatingActionButton>(R.id.fabList)
    }
    private val fabMsg : FloatingActionButton by lazy{
        findViewById<FloatingActionButton>(R.id.fabMsg)
    }
    private val fabCustom : FloatingActionButton by lazy{
        findViewById<FloatingActionButton>(R.id.fabCustom)
    }
    private var isFabOpen = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fabList.setOnClickListener{
            toggleFab()
        }
        //하단 버튼
        var bnv = findViewById(R.id.bnv) as BottomNavigationView
        bnv.run { setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.homeBT -> {
                    // 다른 프래그먼트 화면으로 이동하는 기능
                    val homeFragment = HomeFragment()
                    supportFragmentManager.beginTransaction().replace(R.id.fl_container, homeFragment).commit()
                }
                R.id.storeBT -> {
                    val storeFragment = StoreFragment()
                    supportFragmentManager.beginTransaction().replace(R.id.fl_container, storeFragment).commit()
                }
                R.id.messageBT -> {
                    val messageFragment = MessageFragment()
                    supportFragmentManager.beginTransaction().replace(R.id.fl_container, messageFragment).commit()
                }
                R.id.garageBT -> {
                    val garageFragment = GarageFragment()
                    supportFragmentManager.beginTransaction().replace(R.id.fl_container, garageFragment).commit()
                }
                R.id.profileBT -> {
                    val profileFragment = ProfileFragment()
                    supportFragmentManager.beginTransaction().replace(R.id.fl_container, profileFragment).commit()
                }
            }
            true
        }
            selectedItemId = R.id.homeBT
        }
    }

    private fun toggleFab(){
        if (isFabOpen){
            ObjectAnimator.ofFloat(fabCustom,"translationY",0f).apply { start() }
            ObjectAnimator.ofFloat(fabMsg,"translationY",0f).apply { start() }
            isFabOpen = false
        }
        else {
            ObjectAnimator.ofFloat(fabCustom,"translationY",-175f).apply { start() }
            ObjectAnimator.ofFloat(fabMsg,"translationY",-300f).apply { start() }
            isFabOpen = true
        }
    }
    // 뒤로 가기 버튼 막기
    override fun onBackPressed() {
        super.onBackPressed() //막고 싶으면 여기 주석처리
    }
}

class FragmentAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
    // 포지션 따라 이동
    override fun getItem(position: Int): Fragment {
        val fragment = when (position) {
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
        val title = when (position) {
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




