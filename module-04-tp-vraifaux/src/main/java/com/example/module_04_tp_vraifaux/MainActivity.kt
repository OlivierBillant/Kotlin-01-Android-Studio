package com.example.module_04_tp_vraifaux

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.module_04_tp_vraifaux.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var amb: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        On initialise la vue
        var score = 0
        var indiceQuestion = 0
        var listeQuestionReponse = ArrayList<QuestionReponse>()
        listeQuestionReponse.add(QuestionReponse("Est ce qu'une Vache ?", true))
        listeQuestionReponse.add(QuestionReponse("Faut-il moins de Max ?", true))
        listeQuestionReponse.add(QuestionReponse("Le pompe est-ce la vie?", false))
        listeQuestionReponse.add(QuestionReponse("La vie est-ce la vie?", true))
        listeQuestionReponse.add(QuestionReponse("La vie est-ce le pompe?", false))
        amb = DataBindingUtil.setContentView(this, R.layout.activity_main)
        amb.q = listeQuestionReponse[indiceQuestion]
        amb.textViewScore.text = score.toString()

        amb.buttonVrai.setOnClickListener {
            if (amb.q == null) {
                return@setOnClickListener;
            }
            if (amb.q?.reponse == true) {
                score++
                amb.textViewScore.text = score.toString()
            }
            indiceQuestion++
            if (indiceQuestion == listeQuestionReponse.size) {
                amb.textViewScore.text = "Vous avez fait un score de $score"
                amb.TextViewQuestion.text = ""
            } else {
                amb.q = listeQuestionReponse[indiceQuestion]
            }
        }
        amb.buttonFaux.setOnClickListener {
            if (amb.q == null) {
                return@setOnClickListener;
            }
                if (amb.q?.reponse == false) {
                    score++
                    amb.textViewScore.text = score.toString()
                }
                indiceQuestion++
            if (indiceQuestion == listeQuestionReponse.size) {
                amb.textViewScore.text = "Vous avez fait un score de $score"
                amb.TextViewQuestion.text = ""
            } else {
                amb.q = listeQuestionReponse[indiceQuestion]
            }
        }
    }

}

