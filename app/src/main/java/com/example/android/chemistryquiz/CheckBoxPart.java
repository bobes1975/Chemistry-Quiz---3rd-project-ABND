package com.example.android.chemistryquiz;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class CheckBoxPart extends AppCompatActivity {

    static final String stateQuestionNumber = "stateQuestionNumber";
    static final String stateScore = "stateScore";


    private QuestionLibraryCheckBox myQuestionLibraryCheckBox = new QuestionLibraryCheckBox();
    private int score;
    private TextView questionBoxNo;
    private TextView questionText;
    private CheckBox checkBoxChoice1;
    private CheckBox checkBoxChoice2;
    private CheckBox checkBoxChoice3;
    private CheckBox checkBoxChoice4;
    private String checkBoxAnswer1;
    private String checkBoxAnswer2;
    private String checkBoxAnswer3;
    private String checkBoxAnswer4;

    private String urlHelpLink;
    private int questionNumber;

    private String correctAnswer = "true";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_box_part);
        questionBoxNo = (TextView) findViewById(R.id.questionBoxNo);
        questionText = (TextView) findViewById(R.id.questionText);

        checkBoxChoice1 = (CheckBox) findViewById(R.id.answerOption1);
        checkBoxChoice2 = (CheckBox) findViewById(R.id.answerOption2);
        checkBoxChoice3 = (CheckBox) findViewById(R.id.answerOption3);
        checkBoxChoice4 = (CheckBox) findViewById(R.id.answerOption4);

        // Check whether we're recreating a previously destroyed instance
        if (savedInstanceState != null) {
            // Restore value of members from saved state
            questionNumber = savedInstanceState.getInt(stateQuestionNumber);
            score = savedInstanceState.getInt(stateScore);
        }

        updateQuestionCheckBox();
    }

    //Save question number and score during display rotation

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        // Save the question number
        questionNumber = questionNumber - 1;
        savedInstanceState.putInt(stateQuestionNumber, questionNumber);
        savedInstanceState.putInt(stateScore, score);

        // Always call the superclass so it can save the view hierarchy state
        super.onSaveInstanceState(savedInstanceState);
    }

//update question texts, choices and web link for help button

    public void updateQuestionCheckBox() {

        questionBoxNo.setText(myQuestionLibraryCheckBox.getQuizQuestionNumberCheckBox(questionNumber));
        questionText.setText(myQuestionLibraryCheckBox.getQuizQuestionTextCheckBox(questionNumber));
        checkBoxChoice1.setText(myQuestionLibraryCheckBox.getQuizChoice1(questionNumber));
        checkBoxChoice2.setText(myQuestionLibraryCheckBox.getQuizChoice2(questionNumber));
        checkBoxChoice3.setText(myQuestionLibraryCheckBox.getQuizChoice3(questionNumber));
        checkBoxChoice4.setText(myQuestionLibraryCheckBox.getQuizChoice4(questionNumber));

        checkBoxAnswer1 = myQuestionLibraryCheckBox.getAnswer1CheckBox(questionNumber);
        checkBoxAnswer2 = myQuestionLibraryCheckBox.getAnswer2CheckBox(questionNumber);
        checkBoxAnswer3 = myQuestionLibraryCheckBox.getAnswer3CheckBox(questionNumber);
        checkBoxAnswer4 = myQuestionLibraryCheckBox.getAnswer4CheckBox(questionNumber);

        urlHelpLink = myQuestionLibraryCheckBox.getUrlHelpCheckBox(questionNumber);

        //update quiz picture
        String pictureNo = myQuestionLibraryCheckBox.getPictureCheckBox(questionNumber);
        Context c = getApplicationContext();
        int id = c.getResources().getIdentifier("drawable/" + pictureNo, null, c.getPackageName());
        ((ImageView) findViewById(R.id.quizImage)).setImageResource(id);

        //update question number
        questionNumber++;
    }

    //control the if checked answer are correct, if Yes +1 point, if wrong answer is checked -1 point
    public void answerControlCheckBox() {

        if (checkBoxChoice1.isChecked()) {

            if (checkBoxAnswer1.equals(correctAnswer)) {
                score++;
            } else score--;
        }

        if (checkBoxChoice2.isChecked()) {
            if (checkBoxAnswer2.equals(correctAnswer)) {
                score++;
            } else score--;
        }

        if (checkBoxChoice3.isChecked()) {
            if (checkBoxAnswer3.equals(correctAnswer)) {
                score++;
            } else score--;
        }

        if (checkBoxChoice4.isChecked()) {
            if (checkBoxAnswer4.equals(correctAnswer)) {
                score++;
            } else score--;
        }
    }

    //uncheck all checkboxes
    public void unCheckAllCheckBox() {
        checkBoxChoice1.setChecked(false);
        checkBoxChoice2.setChecked(false);
        checkBoxChoice3.setChecked(false);
        checkBoxChoice4.setChecked(false);
    }

    //help button with web page
    public void help(View view) {
        goToUrl(urlHelpLink);
    }

    public void goToUrl(String url) {
        Uri uriUrl = Uri.parse(url);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }

    //next button
    public void next(View view) {

        answerControlCheckBox();
        result(score);

        int amountOfQuestions = 4;

        if (amountOfQuestions == questionNumber) {
            evaluation();
        } else {
            updateQuestionCheckBox();
            unCheckAllCheckBox();
        }
    }

    //display current score after each question
    public void result (int score){

        String message = getString(R.string.partialMessagePart1) + "" + String.valueOf(score);

        Toast toast = Toast.makeText(this, message, Toast.LENGTH_SHORT);

        LinearLayout layout = (LinearLayout) toast.getView();

        if (layout.getChildCount() > 0) {
            TextView tv = (TextView) layout.getChildAt(0);
            tv.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
        }
        toast.show();
    }

    //after finishing quiz call evaluation
    public void evaluation() {

//sent int score to 2nd CheckBox question activity

        Intent sentScore = new Intent(CheckBoxPart.this, RadioButtonPart.class);
        sentScore.putExtra("sentScoreTo", score);
        startActivity(sentScore);

    }
}