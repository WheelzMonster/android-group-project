package fr.epsi.ted_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class EtudiantActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_etudiant)
        setHeaderTitle(getString(R.string.txt_header_etudiant_page))
        showBack()

        val buttonLouis = findViewById<Button>(R.id.button_etudiant_louis)
        val buttonRomain = findViewById<Button>(R.id.button_etudiant_romain)
        val buttonThibault = findViewById<Button>(R.id.button_etudiant_thibault)


        buttonThibault.setOnClickListener(View.OnClickListener {
            val newIntent = Intent(application,DetailActivity::class.java)
            newIntent.putExtra("title", "Thibault Thieuleux")
            newIntent.putExtra("urlImage", "https://randomuser.me/api/portraits/men/67.jpg")
            newIntent.putExtra("name", "ceci est une test")
            newIntent.putExtra("email", "OUI")
            newIntent.putExtra("group", "ALLO")


            startActivity(newIntent)
        })


    }
}