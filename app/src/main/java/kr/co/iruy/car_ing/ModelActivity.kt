package kr.co.iruy.car_ing

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.LinearLayout

class ModelActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_model)

        val bt = findViewById<ImageButton>(R.id.bt)
        val iv1 = findViewById<ImageView>(R.id.iv1)
        val iv2 = findViewById<ImageView>(R.id.iv2)
        val item_view = findViewById<LinearLayout>(R.id.item_view)
        val xBT = findViewById<ImageButton>(R.id.xBT)

        item_view.visibility = View.INVISIBLE
        bt.setOnClickListener{
            iv1.visibility = View.INVISIBLE
            iv2.visibility = View.INVISIBLE
            bt.visibility = View.INVISIBLE
            item_view.visibility = View.VISIBLE
        }

        xBT.setOnClickListener {
            iv1.visibility = View.VISIBLE
            iv2.visibility = View.VISIBLE
            bt.visibility = View.VISIBLE
            item_view.visibility = View.INVISIBLE
        }


        val wv_main = findViewById<WebView>(R.id.webview)
        wv_main.webChromeClient = WebChromeClient()
        wv_main.webViewClient = WebViewClient()

        if (Build.VERSION.SDK_INT >= 19) {
            wv_main.setLayerType(View.LAYER_TYPE_HARDWARE, null)
        } else {
            wv_main.setLayerType(View.LAYER_TYPE_SOFTWARE, null)
        }
        // 하드웨어 가속을 통해서 성능을 올린다. 기기에 따라서 차이는 있겠지만 평균적으로 4.4 이상이라면 가속이 유리하다.

        val settings = wv_main.settings
        settings.setJavaScriptEnabled(true)
        settings.cacheMode = WebSettings.LOAD_CACHE_ELSE_NETWORK
        settings.domStorageEnabled = true
        settings.allowUniversalAccessFromFileURLs = true
        settings.allowFileAccess = true
        wv_main.loadUrl("https://adsf-ehzvh.run.goorm.io/adsf/")
    }
}