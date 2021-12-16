package fr.epsi.ted_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class EtudiantActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_etudiant)
        setHeaderTitle(getString(R.string.txt_header_etudiant_page))
        showBack()

        val studentList = arrayListOf<Student>()

        studentList.add(Student(
            "Thieuleux",
            "Thieuleux Thibault",
            "thibault.thieuleux@epsi.fr",
            "TED",
            "https://randomuser.me/api/portraits/men/67.jpg"
        ))
        studentList.add(Student(
            "Escartin",
            "Escartin Louis",
            "louis.escartin@epsi.fr",
            "TED",
            "https://randomuser.me/api/portraits/men/32.jpg"
        ))
        studentList.add(Student(
            "Diolot",
            "Diolot Romain",
            "romain.diolot@epsi.fr",
            "TED",
            "https://randomuser.me/api/portraits/men/88.jpg"
        ))

        val buttonLouis = findViewById<Button>(R.id.button_etudiant_louis)
        val buttonRomain = findViewById<Button>(R.id.button_etudiant_romain)
        val buttonThibault = findViewById<Button>(R.id.button_etudiant_thibault)



        buttonThibault.setOnClickListener(View.OnClickListener {
            val newIntent = Intent(application,DetailActivity::class.java)

            newIntent.putExtra("title", studentList[0].lastname)
            newIntent.putExtra("studentName", studentList[0].name)
            newIntent.putExtra("studentEmail", studentList[0].email)
            newIntent.putExtra("studentGroup", studentList[0].group)
            newIntent.putExtra("urlImage", studentList[0].imgUrl)

            startActivity(newIntent)
        })

        buttonLouis.setOnClickListener(View.OnClickListener {
            val newIntent = Intent(application,DetailActivity::class.java)

            newIntent.putExtra("title", studentList[1].lastname)
            newIntent.putExtra("studentName", studentList[1].name)
            newIntent.putExtra("studentEmail", studentList[1].email)
            newIntent.putExtra("studentGroup", studentList[1].group)
            newIntent.putExtra("urlImage", studentList[1].imgUrl)

            startActivity(newIntent)
        })

        buttonRomain.setOnClickListener(View.OnClickListener {
            val newIntent = Intent(application,DetailActivity::class.java)

            newIntent.putExtra("title", studentList[2].lastname)
            newIntent.putExtra("studentName", studentList[2].name)
            newIntent.putExtra("studentEmail", studentList[2].email)
            newIntent.putExtra("studentGroup", studentList[2].group)
            newIntent.putExtra("urlImage", studentList[2].imgUrl)

            startActivity(newIntent)
        })


    }
}