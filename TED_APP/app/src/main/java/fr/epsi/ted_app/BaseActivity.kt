package fr.epsi.ted_app

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

open class BaseActivity: AppCompatActivity(){
    fun showBack(){
        val imageViewBack = findViewById<ImageView>(R.id.imageViewBack)
        imageViewBack.visibility= View.VISIBLE
        imageViewBack.setOnClickListener(View.OnClickListener {
            onBackPressed()
        })
    }

    fun setHeaderTitle(text:String){
        val textViewTitle = findViewById<TextView>(R.id.textViewTitle)
        textViewTitle.text=text
    }

    fun setStudentInfo(name:String, email:String, group:String){
        val nameViewDetail = findViewById<TextView>(R.id.nameViewDetail)
        val emailViewDetail = findViewById<TextView>(R.id.emailViewDetail)
        val groupViewDetail = findViewById<TextView>(R.id.groupViewDetail)

        nameViewDetail.text=name
        emailViewDetail.text=email
        groupViewDetail.text=group

    }
}