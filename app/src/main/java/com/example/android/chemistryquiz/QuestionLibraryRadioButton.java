package com.example.android.chemistryquiz;

/**
 * Created by Bobeš on 23-Feb-18.
 */

//Database for part of quiz with Radio button part
public class QuestionLibraryRadioButton {

    // question No. @quizQuestionNumberRadioButton

    private String quizQuestionNumberRadioButton[] = {
            "Question No. 7:",
            "Question No. 8:",
            "Question No. 9:",
            "Question No. 10:",
            "Question No. 11:",
            "Question No. 12:",
            "Question No. 13:",
    };

    // Question @quizQuestionCheckBox for part of quiz with RadioButton part

    private String quizQuestionRadioButton[] = {
            "One of the essential minerals in the human body is salt. How much salt (NaCl) is in the average adult human body?",
            "The symbol Sb stands for stibnum or stibnite. What is the modern name of this element?",
            "DNA codes for proteins, which are the building blocks of organisms. What is the most abundant protein in the human body?",
            "What is the most common isotope of hydrogen?",
            "Who is credited with the invention of the modern periodic table?",
            "You can't live without iron. Where in the body is most of the iron located?",
            "A drop of food coloring spreading out in a cup of water is an example of which transport process?",
    };

    // Options for checkboxes @quizChoicesRadioButton,
    private String quizChoicesRadioButton[][] = {
            {"1 kilogram", "500 grams", "250 grams", "practically none"},
            {"Tin", "Antimony", "Samarium", "Seaborgium"},
            {"Tubulin", "Albumin", "Collagen", "Keratin"},
            {"Protium", "Deuterium", "Tritium", "Hydrogen only has one isotope"},
            {"Nobel", "Lavoisier", "Mendel", "Mendeleev"},
            {"your brain", "your skin", "your bones", "your blood"},
            {"Diffusion", "Osmosis", "Vapor Pressure", "Effusion"},
    };

    // Correct answer @quizAnswer
    private String quizAnswerRadioButton[] = {"250 grams", "Antimony", "Collagen","Protium", "Mendeleev", "your blood", "Diffusion",};


    // Picture No. @quizPictureRadioButton,
    private String quizPictureRadioButton[] = {
            "picture7",
            "picture8",
            "picture9",
            "picture10",
            "picture11",
            "picture12",
            "picture13",
    };

    //  Options for Help button @urlHelpRadioButton,
    private String urlHelpRadioButton[] = {
            "https://en.wikipedia.org/wiki/Salt",
            "https://en.wikipedia.org/wiki/Antimony",
            "https://en.wikipedia.org/wiki/Collagen,_type_I,_alpha_1",
            "https://en.wikipedia.org/wiki/Hydrogen",
            "https://en.wikipedia.org/wiki/Periodic_table",
            "https://en.wikipedia.org/wiki/Human_iron_metabolism",
            "https://en.wikipedia.org/wiki/Diffusion",
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