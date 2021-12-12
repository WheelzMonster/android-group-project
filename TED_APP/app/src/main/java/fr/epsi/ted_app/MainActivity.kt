package fr.epsi.ted_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.content.Intent

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setHeaderTitle("Epsi")
        val buttonEtudiant = findViewById<Button>(R.id.button_home_etudiants)

        buttonEtudiant.setOnClickListener(View.OnClickListener {
            val newIntent = Intent(application,EtudiantActivity::class.java)
            startActivity(newIntent)
        })
    }
}