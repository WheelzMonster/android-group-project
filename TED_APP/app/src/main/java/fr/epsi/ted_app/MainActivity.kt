package fr.epsi.ted_app

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.content.Intent

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setHeaderTitle(getString(R.string.txt_header_lading_page))
        val buttonEtudiant = findViewById<Button>(R.id.button_home_etudiants)
        val buttonRayon = findViewById<Button>(R.id.button_home_rayons)

        buttonEtudiant.setOnClickListener(View.OnClickListener {
            val newIntent = Intent(application,StudentActivity::class.java)
            startActivity(newIntent)
        })

        buttonRayon.setOnClickListener(View.OnClickListener {
            val newIntent = Intent(application,CategoryOnlineActivity::class.java)
            startActivity(newIntent)
        })
    }
}