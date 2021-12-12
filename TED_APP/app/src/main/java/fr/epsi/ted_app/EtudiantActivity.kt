package fr.epsi.ted_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class EtudiantActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_etudiant)
        setHeaderTitle("Infos")
        showBack()

        val buttonLouis = findViewById<Button>(R.id.button_etudiant_louis)
        val buttonRomain = findViewById<Button>(R.id.button_etudiant_romain)
        val buttonThibault = findViewById<Button>(R.id.button_etudiant_thibault)
    }
}