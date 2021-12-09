package fr.epsi.ted_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import fr.epsi.ted_app.MainActivity
import fr.epsi.ted_app.R

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Handler(Looper.getMainLooper()).postDelayed(Runnable {
            val newIntent=Intent(application, MainActivity::class.java)
            startActivity(newIntent)
            finish()
        },2000)
    }
}