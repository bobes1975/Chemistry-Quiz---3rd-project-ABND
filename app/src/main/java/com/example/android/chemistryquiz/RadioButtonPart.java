package com.example.android.chemistryquiz;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class RadioButtonPart extends Activity {

    static final String stateQuestionNumber = "stateQuestionNumber";
    static final String stateScore = "stateScore";

    private QuestionLibraryRadioButton myQuestionLibraryRadioButton = new QuestionLibraryRadioButton();

    private int score;
    ImageView gamePicture;
    private TextView questionBoxNo;
    private TextView questionText;
    private RadioButton radioButtonChoice1;
    private RadioButton radioButtonChoice2;
    private RadioButton radioButtonChoice3;
    private RadioButton radioButtonChoice4;
    private String quizAnswerRadioButton;
    private String urlHelpLink;
    private int questionNumber;
    private RadioGroup radioQuestionGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_button_part);
        questionBoxNo = (TextView) findViewById(R.id.questionBoxNo);
        questionText = (TextView) findViewById(R.id.questionText);
        radioQuestionGroup = (RadioGroup) findViewById(R.id.radio_group);
        radioButtonChoice1 = (RadioButton) findViewById(R.id.optionQuestion1);
        radioButtonChoice2 = (RadioButton) findViewById(R.id.optionQuestion2);
        radioButtonChoice3 = (RadioButton) findViewById(R.id.optionQuestion3);
        radioButtonChoice4 = (RadioButton) findViewById(R.id.optionQuestion4);

        //get score from previous activity
        Intent sentScoreA = getIntent();
        final int newScore = sentScoreA.getIntExtra(util.SENT_SCORE, 0);

        score = newScore;

        // Check whether we're recreating a previously destroyed instance
        if (savedInstanceState != null) {
            // Restore value of members from saved state
            questionNumber = savedInstanceState.getInt(stateQuestionNumber);
            score = savedInstanceState.getInt(stateScore);
        }

        questionControlRadioButton();
        updateQuestionRadioButton();
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

    //check question for radio buttons part of quiz
    public void questionControlRadioButton() {

        // find correct answer
        radioQuestionGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                // find which radio button is selected and compare it with correct answer

                if (checkedId == R.id.optionQuestion1) {

                    String choice = radioButtonChoice1.getText().toString();
                    if (choice == quizAnswerRadioButton) {

                        score++;
                    }

                } else if (checkedId == R.id.optionQuestion2) {

                    String choice = radioButtonChoice2.getText().toString();
                    if (choice == quizAnswerRadioButton) {

                        score++;
                    }

                } else if (checkedId == R.id.optionQuestion3) {

                    String choice = radioButtonChoice3.getText().toString();
                    if (choice == quizAnswerRadioButton) {

                        score++;
                    }

                } else if (checkedId == R.id.optionQuestion4) {

                    String choice = radioButtonChoice4.getText().toString();
                    if (choice == quizAnswerRadioButton) {

                        score++;
                    }
                }
            }
        });
    }

    //update question texts, choices and web link for help button

    public void updateQuestionRadioButton() {
        gamePicture = (ImageView) findViewById(R.id.quizImage);

        questionBoxNo.setText(myQuestionLibraryRadioButton.getQuizQuestionNumberRadioButton(questionNumber));
        questionText.setText(myQuestionLibraryRadioButton.getQuizQuestionTextRadioButton(questionNumber));
        radioButtonChoice1.setText(myQuestionLibraryRadioButton.getQuizChoice1RadioButton(questionNumber));
        radioButtonChoice2.setText(myQuestionLibraryRadioButton.getQuizChoice2RadioButton(questionNumber));
        radioButtonChoice3.setText(myQuestionLibraryRadioButton.getQuizChoice3RadioButton(questionNumber));
        radioButtonChoice4.setText(myQuestionLibraryRadioButton.getQuizChoice4RadioButton(questionNumber));
        quizAnswerRadioButton = myQuestionLibraryRadioButton.getCorrectAnswerRadioButton(questionNumber);
        urlHelpLink = myQuestionLibraryRadioButton.getUrlHelpRadioButton(questionNumber);

        //update quiz picture
        String pictureNo = myQuestionLibraryRadioButton.getPictureRadioButton(questionNumber);
        Context c = getApplicationContext();
        int id = c.getResources().getIdentifier("drawable/" + pictureNo, null, c.getPackageName());
        ((ImageView) findViewById(R.id.quizImage)).setImageResource(id);

        //update question number
        questionNumber++;
    }

    //help button with web page
    public void help_Q1(View view) {
        goToUrl(urlHelpLink);
    }

    public void goToUrl(String url) {
        Uri uriUrl = Uri.parse(url);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }

    //next button
    public void next(View view) {

        int amountOfQuestions = 3;
        if (amountOfQuestions == questionNumber) {

            evaluation();
        } else {
            updateQuestionRadioButton();
        }
    }

    //after finishing quiz call evaluation
    public void evaluation() {

//sent int score to 2nd CheckBox question activity
        Intent sentScore = new Intent(RadioButtonPart.this, EditTextPart.class);
        sentScore.putExtra("sentScoreTo", score);
        startActivity(sentScore);
    }
}