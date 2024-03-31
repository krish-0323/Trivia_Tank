package com.example.quizapp

object Constants {

    fun getQuestions(): ArrayList<Question> {
        val questionsList = ArrayList<Question>()

        val que1 = Question(
            1,
            "Which country does this flag belong to?",
            R.drawable.ic_flag_of_argentina,
            "Argentina",
            "Australia",
            "Armenia",
            "Austria",
            1
        )

        questionsList.add(que1)

        val que2 = Question(
            2,
            "Which country does this flag belong to?",
            R.drawable.ic_flag_of_australia,
            "Argentina",
            "Australia",
            "New Zealand",
            "Austria",
            2
        )

        questionsList.add(que2)

        val que3 = Question(
            3,
            "Which country does this flag belong to?",
            R.drawable.ic_flag_of_belgium,
            "Germany",
            "Belarus",
            "Belgium",
            "Italy",
            3
        )

        questionsList.add(que3)

        val que4 = Question(
            4,
            "Which country does this flag belong to?",
            R.drawable.ic_flag_of_brazil,
            "Argentina",
            "Paraguay",
            "Brazil",
            "Chile",
            3
        )

        questionsList.add(que4)

        val que5 = Question(
            5,
            "Which country does this flag belong to?",
            R.drawable.ic_flag_of_denmark,
            "Norway",
            "Denmark",
            "Finland",
            "Scotland",
            2
        )

        questionsList.add(que5)

        val que6 = Question(
            6,
            "Which country does this flag belong to?",
            R.drawable.ic_flag_of_fiji,
            "Fiji",
            "Solomon Islands",
            "Tuvalu",
            "Samoa",
            1
        )

        questionsList.add(que6)

        val que7 = Question(
            7,
            "Which country does this flag belong to?",
            R.drawable.ic_flag_of_germany,
            "Germany",
            "Belarus",
            "Belgium",
            "Italy",
            1
        )

        questionsList.add(que7)

        val que8 = Question(
            8,
            "Which country does this flag belong to?",
            R.drawable.ic_flag_of_india,
            "India",
            "Ireland",
            "France",
            "Italy",
            1
        )

        questionsList.add(que8)

        val que9 = Question(
            9,
            "Which country does this flag belong to?",
            R.drawable.ic_flag_of_kuwait,
            "Syria",
            "Kuwait",
            "Iraq",
            "Iran",
            2
        )

        questionsList.add(que9)

        val que10 = Question(
            10,
            "Which country does this flag belong to?",
            R.drawable.ic_flag_of_new_zealand,
            "New Zealand",
            "Australia",
            "Fiji",
            "Samoa",
            1
        )

        questionsList.add(que10)
        return questionsList
    }
}