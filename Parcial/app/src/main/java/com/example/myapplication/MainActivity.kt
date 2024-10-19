package com.example.parcial

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.parcial1.fragments.WelcomeFragment
import com.example.parcial1.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Mostrar el fragmento de bienvenida al iniciar la actividad si aún no está cargado
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, WelcomeFragment())
                .commit()
        }
    }

    // Método para cambiar entre fragmentos
    fun navigateToFragment(fragment: androidx.fragment.app.Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack(null) // Permite al usuario volver al fragmento anterior
            .commit()
    }
}
