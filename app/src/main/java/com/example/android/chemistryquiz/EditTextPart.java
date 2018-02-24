package com.example.android.chemistryquiz;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class EditTextPart extends AppCompatActivity {

    static final String stateQuestionNumber = "stateQuestionNumber";
    static final String stateScore = "stateScore";

    private QuestionLibraryEditText myQuestionLibraryEditText = new QuestionLibraryEditText();

    private int score;
    private TextView questionNo;
    private TextView questionText;
    private String correctAnswerEditText;
    private String urlHelpLink;
    private int questionNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_text_part);

        questionNo = (TextView) findViewById(R.id.questionNo);
        questionText = (TextView) findViewById(R.id.questionText);

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
        updateQuestionEditText();
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

    //update question texts and web link for help button

    public void updateQuestionEditText() {

        questionNo.setText(myQuestionLibraryEditText.getQuizQuestionNumberEditText(questionNumber));
        questionText.setText(myQuestionLibraryEditText.getQuizQuestionTextEditText(questionNumber));

        correctAnswerEditText = (myQuestionLibraryEditText.getCorrectAnswerEditText(questionNumber));
        urlHelpLink = myQuestionLibraryEditText.getUrlHelpEditText(questionNumber);

        //update quiz picture
        String pictureNo = myQuestionLibraryEditText.getPictureEditText(questionNumber);
        Context c = getApplicationContext();
        int id = c.getResources().getIdentifier("drawable/" + pictureNo, null, c.getPackageName());
        ((ImageView) findViewById(R.id.quizImage)).setImageResource(id);

        //update question number
        questionNumber++;
    }

    //check question for EditText part of quiz

    public void questionControlEditText() {

        //Check the correct answer

        EditText editTextAnswer = (EditText) findViewById(R.id.editTextAnswer);
        String answerFromEditText = editTextAnswer.getText().toString().toLowerCase();

        if (answerFromEditText.equals(correctAnswerEditText)) {
            score++;
        }
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

    public void clearEditText() {

        EditText clearEditText = (EditText) findViewById(R.id.editTextAnswer);
        clearEditText.setText(getString(R.string.empty));
    }

    // button for next question
    public void next1(View view) {
        questionControlEditText();
        updateQuestionEditText();
        clearEditText();
    }

    //next button
    public void next(View view) {
        int amountOfQuestions = 3;
        questionControlEditText();
        if (amountOfQuestions == questionNumber) {
            evaluation();
        } else {
            updateQuestionEditText();
            clearEditText();
        }
    }

    //after finishing quiz call evaluation
    public void evaluation() {

//sent int score to 2nd CheckBox question activity
        Intent sentScore = new Intent(EditTextPart.this, Evaluation.class);
        sentScore.putExtra("sentScoreTo", score);
        startActivity(sentScore);
    }
}