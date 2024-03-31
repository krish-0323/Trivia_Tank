package com.example.quizapp

import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.AdaptiveIconDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat

class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {

    private var mCurrentPosition:Int = 1
    private var mQuestionsList: ArrayList<Question>? = null

    private var mSelectedOptionPosition : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        val mQuestionsList = Constants.getQuestions()

        setQuestion()

        val tvOptionOne = findViewById<TextView>(R.id.tvOptionOne)
        val tvOptionTwo = findViewById<TextView>(R.id.tvOptionTwo)
        val tvOptionThree = findViewById<TextView>(R.id.tvOptionThree)
        val tvOptionFour = findViewById<TextView>(R.id.tvOptionFour)
        tvOptionOne.setOnClickListener(this)
        tvOptionTwo.setOnClickListener(this)
        tvOptionThree.setOnClickListener(this)
        tvOptionFour.setOnClickListener(this)

        val btnSubmit = findViewById<Button>(R.id.btnSubmit)
        btnSubmit.setOnClickListener(this)

    }


    private fun setQuestion(){

//        val mQuestionsList = Constants.getQuestions()

        val question = mQuestionsList!!.get(mCurrentPosition-1)

        defaultOptionsView()

        if(mCurrentPosition == mQuestionsList!!.size){
            val btnSubmit = findViewById<Button>(R.id.btnSubmit)
            btnSubmit.text = "FINISH"
        } else {
            val btnSubmit = findViewById<Button>(R.id.btnSubmit)
            btnSubmit.text = "NEXT QUESTION"
        }

        val progressBar = findViewById<ProgressBar>(R.id.progressBar)
        progressBar.progress = mCurrentPosition

        val tvProgress = findViewById<TextView>(R.id.tvProgress)
        tvProgress.text = "$mCurrentPosition / ${progressBar.max}"

        val tvQuestion = findViewById<TextView>(R.id.questionId)
        tvQuestion.text = question.question

        val ivSetImage = findViewById<ImageView>(R.id.ivImage)
        ivSetImage.setImageResource(question.image)

        val tvOptionOne = findViewById<TextView>(R.id.tvOptionOne)
        tvOptionOne.text = question.optionOne

        val tvOptionTwo = findViewById<TextView>(R.id.tvOptionTwo)
        tvOptionTwo.text = question.optionTwo

        val tvOptionThree = findViewById<TextView>(R.id.tvOptionThree)
        tvOptionThree.text = question.optionThree

        val tvOptionFour = findViewById<TextView>(R.id.tvOptionFour)
        tvOptionFour.text = question.optionFour
    }

    private fun defaultOptionsView(){
        val options = ArrayList<TextView>()
        val tvOptionOne = findViewById<TextView>(R.id.tvOptionOne)
        options.add(0, tvOptionOne)
        val tvOptionTwo = findViewById<TextView>(R.id.tvOptionTwo)
        options.add(1, tvOptionTwo)
        val tvOptionThree = findViewById<TextView>(R.id.tvOptionThree)
        options.add(2, tvOptionThree)
        val tvOptionFour = findViewById<TextView>(R.id.tvOptionFour)
        options.add(3, tvOptionFour)

        for (option in options){
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this,
                R.drawable.default_option_border_bg
            )
        }
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.tvOptionOne -> {
                val tvOptionOne = findViewById<TextView>(R.id.tvOptionOne)
                selectedOptionView(tvOptionOne, 1)
            }
            R.id.tvOptionTwo -> {
                val tvOptionTwo = findViewById<TextView>(R.id.tvOptionTwo)
                selectedOptionView(tvOptionTwo, 2)
            }
            R.id.tvOptionThree -> {
                val tvOptionThree = findViewById<TextView>(R.id.tvOptionThree)
                selectedOptionView(tvOptionThree, 3)
            }
            R.id.tvOptionFour -> {
                val tvOptionFour = findViewById<TextView>(R.id.tvOptionFour)
                selectedOptionView(tvOptionFour,4)
            }
            R.id.btnSubmit -> {
                if(mSelectedOptionPosition==0){
                    mCurrentPosition++

                    when{
                        mCurrentPosition <= mQuestionsList!!.size -> {
                            setQuestion()
                        } else -> {
                        Toast.makeText(this@QuizQuestionsActivity, "You have successfully completed the quiz", Toast.LENGTH_SHORT).show()
                        }
                    }
                } else {
                    val question = mQuestionsList?.get(mCurrentPosition-1)

                    if(question!!.correctAnswer!=mSelectedOptionPosition){
                        answerView(mSelectedOptionPosition, R.drawable.wrong_option_border_bg)
                    }
                    answerView(question.correctAnswer, R.drawable.correct_option_border_bg)

                    if(mCurrentPosition==mQuestionsList!!.size){
                        val btnSubmit = findViewById<Button>(R.id.btnSubmit)
                        btnSubmit.text = "FINISH"
                    } else {
                        val btnSubmit = findViewById<Button>(R.id.btnSubmit)
                        btnSubmit.text = "NEXT QUESTION"
                    }
                    mSelectedOptionPosition = 0
                }
            }
        }
    }

    private fun answerView(answer: Int, drawableView: Int){
        when(answer){
            1 -> {
                val tvOptionOne = findViewById<TextView>(R.id.tvOptionOne)
                tvOptionOne.background = ContextCompat.getDrawable(
                    this@QuizQuestionsActivity, drawableView
                )
            }
            2 -> {
                val tvOptionTwo = findViewById<TextView>(R.id.tvOptionTwo)
                tvOptionTwo.background = ContextCompat.getDrawable(
                    this@QuizQuestionsActivity, drawableView
                )
            }
            3 -> {
                val tvOptionThree = findViewById<TextView>(R.id.tvOptionThree)
                tvOptionThree.background = ContextCompat.getDrawable(
                    this@QuizQuestionsActivity, drawableView
                )
            }
            4 -> {
                val tvOptionFour = findViewById<TextView>(R.id.tvOptionFour)
                tvOptionFour.background = ContextCompat.getDrawable(
                    this@QuizQuestionsActivity, drawableView
                )
            }
        }
    }

    private fun selectedOptionView(tv:TextView, selectedOptionNum:Int){
        defaultOptionsView()
        mSelectedOptionPosition = selectedOptionNum

        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this@QuizQuestionsActivity, R.drawable.selected_option_border_bg
        )
    }
}
