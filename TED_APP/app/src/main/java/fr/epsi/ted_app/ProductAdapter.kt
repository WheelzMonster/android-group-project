package fr.epsi.ted_app

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import fr.epsi.ted_app.ProductAdapter.ViewHolder

class ProductAdapter(val products: ArrayList<Product>):RecyclerView.Adapter<ViewHolder>() {

    class ViewHolder(private val context: Context, view:View) :RecyclerView.ViewHolder(view), View.OnClickListener{
        val imageViewProduct = view.findViewById<ImageView>(R.id.imageViewProduct)
        val nameProduct = view.findViewById<TextView>(R.id.textViewName)
        var descriptionProduct = view.findViewById<TextView>(R.id.textViewDescription)
        var product: Product? = null

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val newIntent = Intent(context, ProductDetailActivity::class.java)
            newIntent.putExtra("name", product?.name)
            newIntent.putExtra("description", product?.description)
            newIntent.putExtra("url", product?.picture_url)
            startActivity(context, newIntent, null)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.cell_product, viewGroup, false)
        return ViewHolder(viewGroup.context, view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = products.get(position)
        holder.nameProduct.text = product.name
        holder.descriptionProduct.text = product.description
        Picasso.get().load(product.picture_url).into(holder.imageViewProduct)
        holder.product = product

    }

    override fun getItemCount(): Int {
        return products.size
    }
}