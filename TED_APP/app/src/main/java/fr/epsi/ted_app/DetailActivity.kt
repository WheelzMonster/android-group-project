package fr.epsi.ted_app


import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class DetailActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        showBack()
        val imageView = findViewById<ImageView>(R.id.imageViewDetail)
        val urlImage = intent.getStringExtra("urlImage")
        intent.getStringExtra("title")?.let { setHeaderTitle(it) }
        Picasso.get().load(urlImage).into(imageView)
        intent.getStringExtra("name")?.let { setStudentInfo(it, it, it) }
        intent.getStringExtra("email")?.let { setStudentInfo(it, it, it) }
        intent.getStringExtra("group")?.let { setStudentInfo(it, it, it) }

    }
}