package fr.epsi.ted_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import okhttp3.*
import org.json.JSONObject
import java.io.IOException


class ProductOnlineActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_online)
        intent.getStringExtra("title")?.let { setHeaderTitle(it) }
        showBack()

        val products = arrayListOf<Product>()


        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewProducts)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val productAdapter = ProductAdapter(products)
        recyclerView.adapter = productAdapter

        val okHttpClient: OkHttpClient = OkHttpClient.Builder().build()
        val mRequestURL = intent.getStringExtra("url")
        val request = mRequestURL?.let {
            Request.Builder()
                .url(it)
                .get()
                .cacheControl(CacheControl.FORCE_NETWORK)
                .build()
        }

        if (request != null) {
            okHttpClient.newCall(request).enqueue(object : Callback {
                override fun onFailure(call: Call, e: IOException) {
                    Log.d("error", e.message.toString())
                }

                override fun onResponse(call: Call, response: Response) {
                    val data = response.body?.string()

                    if (data != null) {
                        val jsProducts = JSONObject(data)
                        val jsArrayProducts = jsProducts.getJSONArray("items")
                        for (i in 0 until jsArrayProducts.length()) {
                            val jsProduct = jsArrayProducts.getJSONObject(i)
                            val product = Product(
                                jsProduct.optString("name", ""),
                                jsProduct.optString("description", ""),
                                jsProduct.optString("picture_url", "")
                            )
                            products.add(product)
                            Log.d("product", product.name)
                        }
                        Log.d("Product", "${products.size}")
                        runOnUiThread(Runnable {
                            productAdapter.notifyDataSetChanged()
                        })
                    }
                }

            })
        }
    }
}