package com.example.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat

class QuizQuestions : AppCompatActivity(), View.OnClickListener {

    private var mCurrentPosition : Int = 1
    private var mQuestionsList : ArrayList<Question>? = null
    private var mSelectedOptionPosition : Int = 0
    private var mUserName : String? = null
    private var totalCorrect : Int = 0

    private var progressBar : ProgressBar? = null
    private var tvProgress : TextView? = null
    private var tvQuestion : TextView? = null
    private var ivImage : ImageView? = null

    private var tvOption1 : TextView? = null
    private var tvOption2 : TextView? = null
    private var tvOption3 : TextView? = null
    private var tvOption4 : TextView? = null

    private var btnSubmit : Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)
        mUserName = intent.getStringExtra(Constant.USER_NAME)
        progressBar = findViewById(R.id.progress_bar)
        tvProgress = findViewById(R.id.tv_progress)
        tvQuestion = findViewById(R.id.tv_question)
        ivImage = findViewById(R.id.iv_image)
        tvOption1 = findViewById(R.id.tv_option_one)
        tvOption2 = findViewById(R.id.tv_option_two)
        tvOption3 = findViewById(R.id.tv_option_three)
        tvOption4 = findViewById(R.id.tv_option_four)
        btnSubmit = findViewById(R.id.btn_submit)

        tvOption1?.setOnClickListener(this)
        tvOption2?.setOnClickListener(this)
        tvOption3?.setOnClickListener(this)
        tvOption4?.setOnClickListener(this)
        btnSubmit?.setOnClickListener(this)

        mQuestionsList = Constant.getQuestions()
        setQuestion()

    }

    private fun setQuestion() {
        defaultOptionView()
        val question: Question = mQuestionsList!![mCurrentPosition - 1]
        ivImage?.setImageResource(question.image)
        progressBar?.progress = mCurrentPosition
        tvProgress?.text = "$mCurrentPosition/${progressBar?.max}"
        tvQuestion?.text = question.question
        tvOption1?.text = question.option1
        tvOption2?.text = question.option2
        tvOption3?.text = question.option3
        tvOption4?.text = question.option4

        if(mCurrentPosition == mQuestionsList!!.size){
            btnSubmit?.text = "Finish"
        }
        else {
            btnSubmit?.text = "Submit"
        }
    }

    private fun defaultOptionView(){
        val options = ArrayList<TextView>()
        tvOption1?.let{
            options.add(0,it)
        }
        tvOption2?.let{
            options.add(1,it)
        }
        tvOption3?.let{
            options.add(2,it)
        }
        tvOption4?.let{
            options.add(3,it)
        }

        for (option in options){
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this,R.drawable.default_option_border_bg
            )
        }
    }

    private fun selectedOptionView(tv:TextView,selectedOptionNum:Int){
        defaultOptionView()

        mSelectedOptionPosition = selectedOptionNum
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface,Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this, R.drawable.selected_option_for_bg
        )
    }

    override fun onClick(view : View?) {
        when(view?.id){
            R.id.tv_option_one -> {
                tvOption1?.let{
                    selectedOptionView(it,1)
                }
            }
            R.id.tv_option_two-> {
                tvOption2?.let{
                    selectedOptionView(it,2)
                }
            }
            R.id.tv_option_three -> {
                tvOption3?.let{
                    selectedOptionView(it,3)
                }
            }
            R.id.tv_option_four -> {
                tvOption4?.let{
                    selectedOptionView(it,4)
                }
            }

            R.id.btn_submit ->{
                if (mSelectedOptionPosition==0){
                    mCurrentPosition++
                    when{
                        mCurrentPosition<= mQuestionsList!!.size ->{
                            setQuestion()
                        }
                        else -> {
                            val intent = Intent(this,EndScreen::class.java)
                            intent.putExtra(Constant.USER_NAME, mUserName)
                            intent.putExtra(Constant.CORRECT_ANSWERS,totalCorrect)
                            intent.putExtra(Constant.TOTAL_QUESTIONS, mQuestionsList?.size)
                            startActivity(intent)
                            finish()
                        }
                    }
                }
                else{
                    val question = mQuestionsList?.get(mCurrentPosition - 1)
                    if(question!!.correctAnswer != mSelectedOptionPosition){
                        answerView(mSelectedOptionPosition, R.drawable.wrong_option_border_bg)
                    }else{
                        totalCorrect++
                    }
                    answerView(question.correctAnswer, R.drawable.correct_option_border_bg)

                    if(mCurrentPosition == mQuestionsList!!.size){
                        btnSubmit?.text = "Finish"
                    }
                    else{
                        btnSubmit?.text = "Next"
                    }
                    mSelectedOptionPosition = 0
                }
            }

        }
    }
    private fun answerView(answer:Int, drawableView: Int){
        when(answer){
            1->{
                tvOption1?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            2->{
                tvOption2?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            3->{
                tvOption3?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            4->{
                tvOption4?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }

        }
    }
}