package fr.epsi.ted_app

import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import okhttp3.*
import org.json.JSONObject
import java.io.IOException


open class CategoryOnlineActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category_online)
        setHeaderTitle(getString(R.string.txt_header_category_page))
        showBack()

        val categories = arrayListOf<Category>()

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewCategories)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val categoryAdapter = CategoryAdapter(categories)
        recyclerView.adapter=categoryAdapter

        val okHttpClient: OkHttpClient = OkHttpClient.Builder().build()
        val mRequestURL="https://djemam.com/epsi/categories.json"
        val request = Request.Builder()
            .url(mRequestURL)
            .get()
            .cacheControl(CacheControl.FORCE_NETWORK)
            .build()

        okHttpClient.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                TODO("Not yet implemented")
            }

            override fun onResponse(call: Call, response: Response) {
                val data = response.body?.string()

                if(data!=null){
                    val jsCategories = JSONObject(data)
                    val jsArrayCategories= jsCategories.getJSONArray("items")
                    for(i in 0 until jsArrayCategories.length()){
                        val jsCategorie = jsArrayCategories.getJSONObject(i)
                        val categorie = Category(jsCategorie.optInt("category_id"),
                            jsCategorie.optString("title",""),
                            jsCategorie.optString("products_url",""))
                        categories.add(categorie)
                        Log.d("categorie",categorie.title)
                    }
                    Log.d("Category","${categories.size}")
                    runOnUiThread(Runnable {
                        categoryAdapter.notifyDataSetChanged()
                    })
                }
            }

        })


    }
}