package fr.epsi.ted_app

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import fr.epsi.ted_app.CategorieAdapter.ViewHolder

class CategorieAdapter(val categories: ArrayList<Categorie>):RecyclerView.Adapter<ViewHolder>() {

    class ViewHolder(view:View) :RecyclerView.ViewHolder(view){
        val buttonCategorie = view.findViewById<TextView>(R.id.buttonCategorie)
        //val buttonProduct = view.findViewById<Button>(R.id.buttonProduct)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.cell_categorie, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val categorie = categories.get(position)
        holder.buttonCategorie.text=categorie.title
        holder.buttonCategorie.setOnClickListener(View.OnClickListener{})
    }

    override fun getItemCount(): Int {
        return categories.size
    }
}