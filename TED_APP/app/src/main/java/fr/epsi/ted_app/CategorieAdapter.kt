package fr.epsi.ted_app

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import fr.epsi.ted_app.CategorieAdapter.ViewHolder

class CategorieAdapter(val categories: ArrayList<Categorie>):RecyclerView.Adapter<ViewHolder>() {

    class ViewHolder(view:View) :RecyclerView.ViewHolder(view){
        val buttonCategorie = view.findViewById<TextView>(R.id.buttonCategorie)
        //val contentLayout = view.findViewById<LinearLayout>(R.id.contentLayout)
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
//        holder.contentLayout.setOnClickListener(View.OnClickListener {
//            (holder.contentLayout.context.applicationContext as TED_App).showToast(categorie.title)
//        })
        //Picasso.get().load(student.imgUrl).into(holder.imageViewStudent)
    }

    override fun getItemCount(): Int {
        return categories.size
    }
}