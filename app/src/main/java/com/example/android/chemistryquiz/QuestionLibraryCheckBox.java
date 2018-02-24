package com.example.android.chemistryquiz;

/**
 * Created by Bobeš on 23-Feb-18.
 */

//Database for part of quiz with CheckBox part
public class QuestionLibraryCheckBox {
    // question No. @quizQuestionNumberCheckBox

    private String quizQuestionNumberCheckBox[] = {
            "Question No. 1:",
            "Question No. 2:",
            "Question No. 3:",
            "Question No. 4:",

    };

    // Question @quizQuestionCheckBox for part of quiz with CheckBox part

    private String quizQuestionCheckBox[] = {
            "Noble gases are inert because they have completed outer electron shells. Which of these elements isn't a noble gas?",
            "Which of these elements is a nonmetal?",
            "Which of the following elements are liquids around room temperature?",
            "Which of these following are amino acids?",
    };

    // Options for checkboxes @quizChoices,
    private String quizChoicesCheckBox[][] = {
            {"Hydrogen", "Argon", "Chlorine", "Krypton"},
            {"Manganese", "Sulfur", "Germanium", "Berylium"},
            {"Gallium", "Magnesium", "Bromine", "Mercury"},
            {"Tryptophan", "Leucine", "Tyrosine", "Adenine"},
    };

    // Correct answer @quizAnswer
    private String quizAnswerCheckBox[][] = {
            {"true", "false", "true", "false"},
            {"false", "true", "false", "true"},
            {"false", "false", "true", "true"},
            {"true", "true", "true", "false"},
    };

    // Picture No. @quizPicture,
    private String quizPictureCheckBox[] = {
            "picture1",
            "picture2",
            "picture3",
            "picture4",

    };

    //  Options for Help button @urlHelpCheckBox,
    private String urlHelpCheckBox[] = {
            "https://en.wikipedia.org/wiki/Noble_gas",
            "https://en.wikipedia.org/wiki/Nonmetal",
            "https://en.wikipedia.org/wiki/Chemical_element",
            "https://en.wikipedia.org/wiki/Amino_acid",
    };

// methods called from CheckBox part of Quiz for update

    public String getQuizQuestionNumberCheckBox(int a) {
        String questionNumber = quizQuestionNumberCheckBox[a];
        return questionNumber;
    }

    public String getQuizQuestionTextCheckBox(int a) {
        String questionText = quizQuestionCheckBox[a];
        return questionText;
    }

    public String getQuizChoice1(int a) {
        String questionChoice0 = quizChoicesCheckBox[a][0];
        return questionChoice0;
    }

    public String getQuizChoice2(int a) {
        String questionChoice1 = quizChoicesCheckBox[a][1];
        return questionChoice1;
    }

    public String getQuizChoice3(int a) {
        String questionChoice2 = quizChoicesCheckBox[a][2];
        return questionChoice2;
    }

    public String getQuizChoice4(int a) {
        String questionChoice3 = quizChoicesCheckBox[a][3];
        return questionChoice3;
    }

    public String getAnswer1CheckBox(int a) {
        String questionAnswer0 = quizAnswerCheckBox[a][0];
        return questionAnswer0;
    }

    public String getAnswer2CheckBox(int a) {
        String questionAnswer1 = quizAnswerCheckBox[a][1];
        return questionAnswer1;
    }

    public String getAnswer3CheckBox(int a) {
        String questionAnswer2 = quizAnswerCheckBox[a][2];
        return questionAnswer2;
    }

    public String getAnswer4CheckBox(int a) {
        String questionAnswer3 = quizAnswerCheckBox[a][3];
        return questionAnswer3;
    }

    public String getPictureCheckBox(int a) {
        String pictureNo = quizPictureCheckBox[a];
        return pictureNo;
    }

    public String getUrlHelpCheckBox(int a) {
        String urlLink = urlHelpCheckBox[a];
        return urlLink;
    }
}
