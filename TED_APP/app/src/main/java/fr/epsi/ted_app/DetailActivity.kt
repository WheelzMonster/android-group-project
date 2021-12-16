package fr.epsi.ted_app


import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class DetailActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        intent.getStringExtra("title")?.let { setHeaderTitle(it) }
        showBack()
        val imageView = findViewById<ImageView>(R.id.imageViewDetail)
        val urlImage = intent.getStringExtra("urlImage")
        val nameViewDetail = findViewById<TextView>(R.id.nameViewDetail)
        val nameStudent = intent.getStringExtra("studentName")
        val emailViewDetail = findViewById<TextView>(R.id.emailViewDetail)
        val emailStudent = intent.getStringExtra("studentEmail")
        val groupViewDetail = findViewById<TextView>(R.id.groupViewDetail)
        val groupStudent = intent.getStringExtra("studentGroup")

        nameViewDetail.text = nameStudent
        emailViewDetail.text = emailStudent
        groupViewDetail.text = groupStudent
        Picasso.get().load(urlImage).into(imageView)

    }
}