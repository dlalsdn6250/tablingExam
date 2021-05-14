package kr.co.tabling.activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import kr.co.tabling.R


class SplashActivity : AppCompatActivity() {
    private val SPLASH_DELAY = 3000L

    private val mHandler: Handler = Handler()
    private val mLaucher = Laucher()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
    }

    override fun onStart() {
        super.onStart()
        mHandler.postDelayed(mLaucher, SPLASH_DELAY)
    }

    override fun onStop() {
        mHandler.removeCallbacks(mLaucher)
        super.onStop()
    }

    private fun launch() {
        if (!isFinishing) {
            val intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private inner class Laucher : Runnable {
        override fun run() {
            launch()
        }
    }
}