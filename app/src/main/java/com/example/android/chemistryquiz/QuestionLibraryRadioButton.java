package com.example.android.chemistryquiz;

/**
 * Created by Bobeš on 23-Feb-18.
 */

//Database for part of quiz with Radio button part
public class QuestionLibraryRadioButton {

    // question No. @quizQuestionNumberRadioButton

    private String quizQuestionNumberRadioButton[] = {
            "Question No. 5:",
            "Question No. 6:",
            "Question No. 7:",
    };

    // Question @quizQuestionCheckBox for part of quiz with RadioButton part

    private String quizQuestionRadioButton[] = {
            "One of the essential minerals in the human body is salt. How much salt (NaCl) is in the average adult human body?",
            "DNA codes for proteins, which are the building blocks of organisms. What is the most abundant protein in the human body?",
            "Who is credited with the invention of the modern periodic table?",
    };

    // Options for checkboxes @quizChoicesRadioButton,
    private String quizChoicesRadioButton[][] = {
            {"1 kilogram", "500 grams", "250 grams", "practically none"},
            {"Collagen","Tubulin", "Albumin", "Keratin"},
            {"Nobel", "Lavoisier", "Mendel", "Mendeleev"},
    };

    // Correct answer @quizAnswer
    private String quizAnswerRadioButton[] = {"250 grams", "Collagen", "Mendeleev",};

    // Picture No. @quizPictureRadioButton,
    private String quizPictureRadioButton[] = {
            "picture5",
            "picture6",
            "picture7",
    };

    //  Options for Help button @urlHelpRadioButton,
    private String urlHelpRadioButton[] = {
            "https://en.wikipedia.org/wiki/Salt",
            "https://en.wikipedia.org/wiki/Collagen,_type_I,_alpha_1",
            "https://en.wikipedia.org/wiki/Periodic_table",
    };

// methods called from RadioButton part of Quiz for update

    public String getQuizQuestionNumberRadioButton(int a) {
        String questionNumber = quizQuestionNumberRadioButton[a];
        return questionNumber;
    }

    public String getQuizQuestionTextRadioButton(int a) {
        String questionText = quizQuestionRadioButton[a];
        return questionText;
    }

    public String getQuizChoice1RadioButton(int a) {
        String questionChoice0 = quizChoicesRadioButton[a][0];
        return questionChoice0;
    }

    public String getQuizChoice2RadioButton(int a) {
        String questionChoice1 = quizChoicesRadioButton[a][1];
        return questionChoice1;
    }

    public String getQuizChoice3RadioButton(int a) {
        String questionChoice2 = quizChoicesRadioButton[a][2];
        return questionChoice2;
    }

    public String getQuizChoice4RadioButton(int a) {
        String questionChoice3 = quizChoicesRadioButton[a][3];
        return questionChoice3;
    }

    public String getCorrectAnswerRadioButton(int a) {
        String answer = quizAnswerRadioButton[a];
        return answer;
    }

    public String getPictureRadioButton(int a) {
        String pictureNo = quizPictureRadioButton[a];
        return pictureNo;
    }

    public String getUrlHelpRadioButton(int a) {
        String urlLink = urlHelpRadioButton[a];
        return urlLink;
    }
}