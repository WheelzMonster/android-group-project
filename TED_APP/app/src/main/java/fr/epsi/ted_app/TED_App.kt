package fr.epsi.ted_app

import android.widget.Toast
import android.app.Application

class TED_App : Application() {

    override fun onCreate() {
        super.onCreate()
    }

    fun showToast(txt : String){
        Toast.makeText(this,txt, Toast.LENGTH_SHORT).show()
    }

}