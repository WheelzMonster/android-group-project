package fr.epsi.ted_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button


class RayonActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rayon)
        setHeaderTitle(getString(R.string.txt_header_rayon_page))
        showBack()
    }
}