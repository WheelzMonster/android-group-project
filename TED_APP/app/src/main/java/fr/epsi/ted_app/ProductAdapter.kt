package fr.epsi.ted_app

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import fr.epsi.ted_app.ProductAdapter.ViewHolder

class ProductAdapter(val products: ArrayList<Product>):RecyclerView.Adapter<ViewHolder>() {

    class ViewHolder(private val context: Context, view:View) :RecyclerView.ViewHolder(view), View.OnClickListener{
        val buttonProduct = view.findViewById<TextView>(R.id.buttonProduct)


        override fun onClick(v: View?) {
            TODO("Not yet implemented")
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.cell_product, viewGroup, false)
        return ViewHolder(viewGroup.context, view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = products.get(position)
        holder.buttonProduct.text=product.name
        holder.buttonProduct.setOnClickListener(View.OnClickListener{})
    }

    override fun getItemCount(): Int {
        return products.size
    }
}