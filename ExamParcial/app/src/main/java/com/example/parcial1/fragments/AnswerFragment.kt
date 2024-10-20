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

class AnswerFragment : Fragment(R.layout.fragment_answer) {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_answer, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Obtener los argumentos del Bundle si los hay
        val arguments = arguments
        val isAnswerCorrect = arguments?.getBoolean("isAnswerCorrect") ?: false
        val explanation = arguments?.getString("explanation") ?: "No hay explicación disponible."

        // Mostrar la retroalimentación al usuario
        val feedbackTextView: TextView = view.findViewById(R.id.feedbackTextView)
        feedbackTextView.text = if (isAnswerCorrect) {
            "¡Correcto! $explanation"
        } else {
            "Incorrecto. $explanation"
        }

        val nextButton: Button = view.findViewById(R.id.nextButton)
        nextButton.setOnClickListener {
            // Navegar al siguiente fragmento dependiendo de tu lógica (puede ser otra pregunta o resultados)
            (activity as? MainActivity)?.navigateToFragment(QuestionFragment())
        }
    }

    companion object {
        fun newInstance(isAnswerCorrect: Boolean, explanation: String): AnswerFragment {
            val fragment = AnswerFragment()
            val bundle = Bundle().apply {
                putBoolean("isAnswerCorrect", isAnswerCorrect)
                putString("explanation", explanation)
            }
            fragment.arguments = bundle
            return fragment
        }
    }
}
