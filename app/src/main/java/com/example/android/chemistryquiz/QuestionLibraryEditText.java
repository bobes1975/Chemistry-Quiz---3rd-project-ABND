package com.example.android.chemistryquiz;

/**
 * Created by Bobeš on 23-Feb-18.
 */

//Database for part of quiz with EditBox button part

public class QuestionLibraryEditText {
// question No. @quizQuestionNumberEditText

    private String quizQuestionNumberEditText[] = {
            "Question No. 8:",
            "Question No. 9:",
            "Question No. 10:",
    };

    // Question @quizQuestion EditText for part of quiz with EditBox part

    private String quizQuestionEditText[] = {
            "The only one letter that doesn't appear on the periodic table is ...",
            "Although oxygen gas is colorless, the liquid and solid forms of oxygen are ...",
            "A pure element can take many forms. Diamond and graphite both are forms of ...",
    };

    // Correct answer @quizAnswer
    private String quizAnswerEditText[] = {"j", "blue", "carbon",};


    // Picture No. @quizPictureEditText,
    private String quizPictureEditText[] = {
            "picture8",
            "picture9",
            "picture10",
    };

    //  Options for Help button @urlHelpEditBox,
    private String urlHelpEditText[] = {
            "https://en.wikipedia.org/wiki/Periodic_table",
            "https://en.wikipedia.org/wiki/Oxygen",
            "https://en.wikipedia.org/wiki/Carbon",
    };

// methods called from EditBox part of Quiz for update

    public String getQuizQuestionNumberEditText(int a) {
        String questionNumber = quizQuestionNumberEditText[a];
        return questionNumber;
    }

    public String getQuizQuestionTextEditText(int a) {
        String questionText = quizQuestionEditText[a];
        return questionText;
    }

    public String getCorrectAnswerEditText(int a) {
        String answer = quizAnswerEditText[a];
        return answer;
    }

    public String getPictureEditText(int a) {
        String pictureNo = quizPictureEditText[a];
        return pictureNo;
    }

    public String getUrlHelpEditText(int a) {
        String urlLink = urlHelpEditText[a];
        return urlLink;
    }
}
