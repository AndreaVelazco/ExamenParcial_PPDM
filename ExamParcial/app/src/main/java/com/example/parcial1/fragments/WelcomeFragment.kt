package com.example.parcial1.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.parcial1.MainActivity
import com.example.parcial1.R

class WelcomeFragment : Fragment(R.layout.fragment_welcome) {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_welcome, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val welcomeTextView: TextView = view.findViewById(R.id.welcomeTextView)
        val startButton: Button = view.findViewById(R.id.startButton)

        welcomeTextView.text = "Bienvenido a Preguntados!!!\n\nEn este juego, responderás una serie de preguntas sobre Arequipa.\n" +
                    "El objetivo de este juego es aprender mas sobre la cultura de Arequipa. Hay un total de 3 preguntas y cada pregunta tiene un límite de tiempo.\n¡Que la fuerza te acompañe!"

        // Configurar el botón para iniciar el juego
        startButton.setOnClickListener {
            // Navegar al fragmento de preguntas manualmente usando MainActivity
            (activity as? MainActivity)?.navigateToFragment(QuestionFragment())
        }
    }
}

