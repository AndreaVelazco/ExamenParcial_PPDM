package com.example.parcial1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.parcial1.fragments.AnswerFragment
import com.example.parcial1.fragments.QuestionFragment
import com.example.parcial1.fragments.WelcomeFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Cargar el fragmento de bienvenida al iniciar la aplicación
        if (savedInstanceState == null) {
            navigateToFragment(WelcomeFragment())
        }
    }

    fun navigateToFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .addToBackStack(null)
            .commit()
    }

    fun navigateToQuestionFragment() {
        // Cargar el fragmento de preguntas
        navigateToFragment(QuestionFragment())
    }

    fun navigateToAnswerFragment(isCorrect: Boolean, explanation: String) {
        // Cargar el fragmento de respuestas con los datos proporcionados
        val answerFragment = AnswerFragment.newInstance(isCorrect, explanation)
        navigateToFragment(answerFragment)
    }


    fun restartGame() {
        // Reiniciar el juego llevando al usuario de vuelta al fragmento de bienvenida
        supportFragmentManager.popBackStack(null, androidx.fragment.app.FragmentManager.POP_BACK_STACK_INCLUSIVE)
        navigateToFragment(WelcomeFragment())
    }

    fun navigateToResultsFragment() {
        TODO("Not yet implemented")
    }
}
