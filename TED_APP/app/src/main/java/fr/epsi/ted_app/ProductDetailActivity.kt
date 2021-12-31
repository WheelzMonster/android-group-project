package fr.epsi.ted_app

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class ProductDetailActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)
        intent.getStringExtra("name")?.let { setHeaderTitle(it)}
        showBack()

        val descriptionProduct = intent.getStringExtra("description")
        val pictureProduct = intent.getStringExtra("url")

        var descriptionTextView = findViewById<TextView>(R.id.textViewProductDetail)
        val imageViewProduct = findViewById<ImageView>(R.id.imageViewProductDetail)

        descriptionTextView.text = descriptionProduct
        Picasso.get().load(pictureProduct).into(imageViewProduct)



    }
}