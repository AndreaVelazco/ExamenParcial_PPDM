package com.example.parcial1.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.parcial1.MainActivity
import com.example.parcial1.R

class QuestionFragment : Fragment(R.layout.fragment_question) {

    // Lista de preguntas y respuestas
    private val questions = listOf(
        Question(
            text = "¿Cuál es la capital de Arequipa?",
            correctAnswer = "Arequipa",
            options = listOf("Camana", "Castilla", "Arequipa", "Islay"),
            explanation = "Arequipa es la capital de Arequipa."
        ),
        Question(
            text = "¿Cuantas provincias tiene Arequipa?",
            correctAnswer = "8",
            options = listOf("9", "8", "6", "5"),
            explanation = "Arequipa tiene 8 provincias."
        ),
        Question(
            text = "El Inca que fundo Arequipa fue ...",
            correctAnswer = "Mayta Cápac",
            options = listOf("Tupac Yupanqui", "Huayna Cápac", "Pachacutec", "Mayta Cápac"),
            explanation = "Mayta Cápac fue el Inca que fundo Arequipa"
        )
    )

    private var currentQuestionIndex = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_question, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showQuestion(view)

        val answerButton: Button = view.findViewById(R.id.answerButton)
        answerButton.setOnClickListener {
            checkAnswerAndNavigate(view)
        }
    }

    private fun showQuestion(view: View) {
        // Muestra la pregunta actual y las opciones
        val questionTextView: TextView = view.findViewById(R.id.questionTextView)
        val currentQuestion = questions[currentQuestionIndex]

        questionTextView.text = currentQuestion.text

        // Configurar las opciones en los RadioButtons
        val radioGroup: RadioGroup = view.findViewById(R.id.optionsRadioGroup)
        val option1: RadioButton = view.findViewById(R.id.option1)
        val option2: RadioButton = view.findViewById(R.id.option2)
        val option3: RadioButton = view.findViewById(R.id.option3)
        val option4: RadioButton = view.findViewById(R.id.option4)

        option1.text = currentQuestion.options[0]
        option2.text = currentQuestion.options[1]
        option3.text = currentQuestion.options[2]
        option4.text = currentQuestion.options[3]

        // Limpiar selección previa si existía
        radioGroup.clearCheck()
    }

    private fun checkAnswerAndNavigate(view: View) {
        // Obtener la respuesta seleccionada
        val radioGroup: RadioGroup = view.findViewById(R.id.optionsRadioGroup)
        val selectedOptionId = radioGroup.checkedRadioButtonId

        if (selectedOptionId == -1) {
            // Si no se seleccionó ninguna opción, podemos mostrar un mensaje de advertencia
            // o simplemente retornar para que el usuario seleccione una opción
            return
        }

        val selectedRadioButton: RadioButton = view.findViewById(selectedOptionId)
        val selectedAnswer = selectedRadioButton.text.toString()
        val currentQuestion = questions[currentQuestionIndex]

        // Verificar si la respuesta es correcta
        val isCorrect = selectedAnswer == currentQuestion.correctAnswer
        val explanation = currentQuestion.explanation

        // Navegar al AnswerFragment con los datos de la respuesta
        val answerFragment = AnswerFragment.newInstance(isCorrect, explanation)
        (activity as? MainActivity)?.navigateToFragment(answerFragment)

        // Avanzar a la siguiente pregunta
        currentQuestionIndex++
        if (currentQuestionIndex < questions.size) {
            showQuestion(view)
        } else {
            // Navegar al fragmento de resultados si se acabaron las preguntas
            (activity as? MainActivity)?.navigateToResultsFragment()
        }
    }
}

// Clase para almacenar las preguntas y sus datos
data class Question(
    val text: String,
    val correctAnswer: String,
    val options: List<String>,
    val explanation: String
)

