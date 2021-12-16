package fr.epsi.ted_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import okhttp3.*
import org.json.JSONObject
import java.io.IOException


class CategorieOnlineActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_categorie_online)
        setHeaderTitle("Rayon Online")
        showBack()

        val students = arrayListOf<Student>()

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewCategorie)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val studentAdapter = CategorieAdapter(students)
        recyclerView.adapter=studentAdapter

        val okHttpClient: OkHttpClient = OkHttpClient.Builder().build()
        val mRequestURL="https://djemam.com/epsi/list.json"
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
                    val jsStudents = JSONObject(data)
                    val jsArrayStudents= jsStudents.getJSONArray("items")
                    for(i in 0 until jsArrayStudents.length()){
                        val jsStudent = jsArrayStudents.getJSONObject(i)
                        val student = Student(jsStudent.optString("name",""),
                            jsStudent.optString("email",""),
                            jsStudent.optString("picture_url",""),jsStudent.optString("phone",""),jsStudent.optString("city",""),jsStudent.optString("zipcode",""))
                        students.add(student)
                        Log.d("student",student.name)
                    }
                    Log.d("Student","${students.size}")
                    runOnUiThread(Runnable {
                        studentAdapter.notifyDataSetChanged()
                    })
                }
            }

        })
    }

    }
}