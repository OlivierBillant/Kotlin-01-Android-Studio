package com.example.module_04_tp_vraifaux

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.module_04_tp_vraifaux.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var amb: ActivityMainBinding
    var score = 0
    var indiceQuestion = 0
    var listeQuestionReponse = ArrayList<QuestionReponse>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        listeQuestionReponse.add(QuestionReponse("Est ce qu'une Vache ?", true))
        listeQuestionReponse.add(QuestionReponse("Faut-il moins de Max ?", true))
        listeQuestionReponse.add(QuestionReponse("Le pompe est-ce la vie?", false))
        listeQuestionReponse.add(QuestionReponse("La vie est-ce la vie?", true))
        listeQuestionReponse.add(QuestionReponse("La vie est-ce le pompe?", false))
//        On initialise la vue
        amb = DataBindingUtil.setContentView(this, R.layout.activity_main)
        amb.q = listeQuestionReponse[indiceQuestion]
        scoring()

        amb.buttonVrai.setOnClickListener {
            if (amb.q == null || indiceQuestion == listeQuestionReponse.size) {
                return@setOnClickListener
            }
            checkAnswer(true)
            indiceQuestion++
            endGame()
        }
        amb.buttonFaux.setOnClickListener {
            if (amb.q == null || indiceQuestion == listeQuestionReponse.size) {
                return@setOnClickListener
            }
            checkAnswer(false)
            indiceQuestion++
            endGame()
        }
    }

    fun scoring() {
        amb.textViewScore.text = "${score.toString()}/${listeQuestionReponse.size}"
    }

    fun endGame() {
        if (indiceQuestion == listeQuestionReponse.size) {
            amb.textViewScore.text =
                "Vous avez fait un score de $score/${listeQuestionReponse.size}"
            amb.TextViewQuestion.text = ""
        } else {
            amb.q = listeQuestionReponse[indiceQuestion]
        }
    }

    fun checkAnswer(userResponse: Boolean) {
        if (amb.q?.reponse == userResponse) {
            score++
            scoring()
        }
    }
}

