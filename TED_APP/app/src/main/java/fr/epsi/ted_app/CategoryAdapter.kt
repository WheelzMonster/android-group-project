package fr.epsi.ted_app

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import fr.epsi.ted_app.CategoryAdapter.ViewHolder

class CategoryAdapter(val categories: ArrayList<Category>):RecyclerView.Adapter<ViewHolder>() {

    class ViewHolder(private val context: Context, view:View) :RecyclerView.ViewHolder(view), View.OnClickListener {
        val buttonCategory = view.findViewById<Button>(R.id.buttonCategory)
        var category: Category? = null

        init {
            buttonCategory.setOnClickListener(this)
        }
        override fun onClick(v: View?) {
            val newIntent = Intent(context,ProductOnlineActivity::class.java)
            newIntent.putExtra("title", category?.title)
            newIntent.putExtra("url", category?.products_url)
            startActivity(context, newIntent, null)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.cell_category, viewGroup, false)
        return ViewHolder(viewGroup.context, view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val categorie = categories.get(position)
        holder.buttonCategory.text=categorie.title
        holder.category = categorie
    }

    override fun getItemCount(): Int {
        return categories.size
    }
}