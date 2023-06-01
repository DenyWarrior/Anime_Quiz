package com.example.quizapp

import java.util.concurrent.ThreadLocalRandom

object Constant {

    const val USER_NAME : String = "user_name"
    const val TOTAL_QUESTIONS : String = "total_questions"
    const val CORRECT_ANSWERS : String = "correct_answer"



    fun getQuestions() : ArrayList<Question>{
        val questionsList = ArrayList<Question>()
        val que1 = Question(
            1,"What is the name of this Anime Character?",
            R.drawable.eren,
            "Light Yagami",
            "Eren Yeager",
            "Levi Ackerman",
            "Rin Itoshi",
            2
        )
        questionsList.add(que1)
        val que2 = Question(
            1,"Which anime movie this character belongs to?",
            R.drawable.sakura,
            "Your Name",
            "Garden of Words",
            "Josee, the Tiger and the Fish",
            "I want to eat your Pancreas",
            4
        )
        questionsList.add(que2)
        val que3 = Question(
            1,"What is the real name of this Anime Character?",
            R.drawable.okabe,
            "Okarin",
            "Hououin Kyouma",
            "Okabe Rintaro",
            "Mad Scientist",
            3
        )
        questionsList.add(que3)
        val que4 = Question(
            1,"What is the name of this Anime Character?",
            R.drawable.megumin,
            "Yunyun",
            "Aqua",
            "Megumin",
            "Chomusuke",
            3
        )
        questionsList.add(que4)
        val que5 = Question(
            1,"What is name of her brother",
            R.drawable.nezuko,
            "Monjiro",
            "Tontaro Itadaki",
            "Tangoro Hamado",
            "Tanjiro Kamado",
            4
        )
        questionsList.add(que5)
        val que6 = Question(
            1,"What is name this anime character",
            R.drawable.kirito,
            "Kirigaya Kazuto",
            "Eugeo",
            "Higa Takeru",
            "Tatsuya",
            1
        )
        questionsList.add(que6)
        val que7 = Question(
            1,"Which anime this character belongs to?",
            R.drawable.touka,
            "Demon Slayer",
            "Jujutsu Kaisen",
            "Black Clover",
            "Tokyo Ghoul",
            4
        )
        questionsList.add(que7)
        val que8 = Question(
            1,"What is name of this anime character?",
            R.drawable.rem,
            "Emiliya",
            "Rem",
            "Ram",
            "Beatrice",
            2
        )
        questionsList.add(que8)
        val que9 = Question(
            1,"What is name of this anime character?",
            R.drawable.light,
            "L",
            "Light",
            "Mello",
            "Ryuk",
            2
        )
        questionsList.add(que9)
        val que10 = Question(
            1,"What is name of this anime character?",
            R.drawable.isagi,
            "Yoichi Isagi",
            "Meguru Bachira",
            "Rin Itosi",
            "Asahi Naruhuya",
            1
        )
        questionsList.add(que10)
        val que11 = Question(
            1,"What is the name of Muzan's Castle?",
            R.drawable.infinity_castle,
            "Demon Castle",
            "Golden Castle",
            "Infinity Castle",
            "Yami Castle",
            3
        )
        questionsList.add(que11)
        val que12 = Question(
            1,"Name this Iron and Stone made floating castle?",
            R.drawable.aincrad,
            "Aincrad",
            "Braetein",
            "Arashi",
            "Luciad",
            1
        )
        questionsList.add(que12)
        val que13 = Question(
            1,"What is name of thi anime character?",
            R.drawable.julius,
            "Lemiel Silvamillion",
            "Julius Novachrono",
            "Lemiel Silvamillion",
            "Yami Sukehiro",
            2
        )
        questionsList.add(que13)
        val que14 = Question(
            1,"Which anime this character belongs to?",
            R.drawable.ayanokoji,
            "Classroom of the Dead",
            "The Irregular at Magic High School",
            "Assassination Classroom",
            "Classroom of the Elite",
            4
        )
        questionsList.add(que14)

        val queList = ArrayList<Question>()
        val numberofquestions = 5
        for (i in 1..numberofquestions) {
            val randomIndex: Int = ThreadLocalRandom.current().nextInt(questionsList.size)
            val randomElement = questionsList[randomIndex]
            queList.add(randomElement)
        }
        return queList
    }
}