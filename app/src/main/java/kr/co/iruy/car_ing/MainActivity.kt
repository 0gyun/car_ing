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
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
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
            startActivity(Intent(this, MainActivity::class.java))
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
        val go = findViewById<Button>(R.id.go)
        go.setOnClickListener{
            val intent = Intent(this, Book2Activity::class.java)
            startActivity(intent)
        }

        val modelgo = findViewById<Button>(R.id.modelgo)
        modelgo.setOnClickListener{
            val intent = Intent(this, ModelActivity::class.java)
            startActivity(intent)
        }
    }
}
class tendencyActivity: AppCompatActivity(){
    val progressBar : ProgressBar by lazy{
        findViewById<ProgressBar>(R.id.progressBar)
    }
    val beforeBtn : Button by lazy{
        findViewById<Button>(R.id.beforeBtn)
    }
    val nextBtn : Button by lazy{
        findViewById<Button>(R.id.nextBtn)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tendency)
        setButtonClickEvent()
        supportFragmentManager.beginTransaction().replace(R.id.RlProgress, FirstFragment()).commit()
    }
    private fun setButtonClickEvent(){
        beforeBtn.setOnClickListener(onClick(beforeBtn))
        nextBtn.setOnClickListener(onClick(nextBtn))
    }
    private fun onClick(view: View) = View.OnClickListener{
        when(view){
            beforeBtn ->{
                if(progressBar.progress > 1) {
                    progressBar.incrementProgressBy(-1)
                    moveFlagment()
                }
            }
        }
        when(view){
            nextBtn ->{
                if(progressBar.progress < 3) {
                    progressBar.incrementProgressBy(1)
                    moveFlagment()
                }
                if(progressBar.progress == 3){
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                }
            }
        }
    }
    private fun moveFlagment(){
        when(progressBar.progress){
            1 -> {
                val firstFragment = FirstFragment()
                supportFragmentManager.beginTransaction().replace(R.id.RlProgress, firstFragment).commit()
            }
            2 ->{
                val secondFragment = secondFragment()
                supportFragmentManager.beginTransaction().replace(R.id.RlProgress, secondFragment).commit()
            }
            3 ->{
                val thirdFragment = thirdFragment()
                supportFragmentManager.beginTransaction().replace(R.id.RlProgress, thirdFragment).commit()
            }
        }
    }
}

class searchActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        overridePendingTransition(0,0)
    }
    override fun onBackPressed() {
        super.onBackPressed() //막고 싶으면 여기 주석처리
        overridePendingTransition(0,0)
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
                val intent = Intent(this, tendencyActivity::class.java)
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //하단 버튼
        var bnv = findViewById(R.id.bnv) as BottomNavigationView
        bnv.itemIconTintList = null;
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
                    val garageFragment = GarageFragmentt()
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
    // 뒤로 가기 버튼 막기
    override fun onBackPressed() {
        super.onBackPressed() //막고 싶으면 여기 주석처리
    }
}

