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

class QuestionFragment : Fragment(R.layout.fragment_question) {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_question, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Ejemplo: configurando una pregunta
        val questionTextView: TextView = view.findViewById(R.id.questionTextView)
        questionTextView.text = "¿Cuál es la capital de Francia?"

        val answerButton: Button = view.findViewById(R.id.answerButton)
        answerButton.setOnClickListener {
            // Navegar a AnswerFragment con datos
            val isCorrect = true // Esta es solo una lógica de ejemplo
            val explanation = "París es la capital de Francia."

            val answerFragment = AnswerFragment.newInstance(isCorrect, explanation)
            (activity as? MainActivity)?.navigateToFragment(answerFragment)
        }
    }
}

