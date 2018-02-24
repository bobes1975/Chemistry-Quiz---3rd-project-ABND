package com.example.android.chemistryquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Evaluation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evaluation);

        //get score from previous activity
        Intent sentScoreA = getIntent();
        final int newScore = sentScoreA.getIntExtra(util.SENT_SCORE, 0);

        scoreMessage(newScore);
        evaluation(newScore);
    }

    //Toast message with points
    public void scoreMessage(final int newScore) {

        String message = getString(R.string.finalMessagePart1) + "\n" + String.valueOf(newScore) + " " + getString(R.string.finalMessagePart2) + "\n" + getString(R.string.finalMessagePart3);

        Toast toast = Toast.makeText(this, message, Toast.LENGTH_LONG);

        LinearLayout layout = (LinearLayout) toast.getView();

        if (layout.getChildCount() > 0) {
            TextView tv = (TextView) layout.getChildAt(0);
            tv.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
        }
        toast.show();
    }

    // evaluation of quiz

    private void evaluation(final int newScore) {

        //1st place
        if (newScore > 14) {
            TextView evaluationText = (TextView) findViewById(R.id.evaluation);
            evaluationText.setText(R.string.result1);

            ImageView trophyPicture = (ImageView) findViewById(R.id.result);
            trophyPicture.setImageResource(R.drawable.place1);

            //2nd place
        } else if (newScore > 12) {
            TextView evaluationText = (TextView) findViewById(R.id.evaluation);
            evaluationText.setText(R.string.result2);

            ImageView trophyPicture = (ImageView) findViewById(R.id.result);
            trophyPicture.setImageResource(R.drawable.place2);

            //3rd place
        } else if (newScore > 9) {
            TextView evaluationText = (TextView) findViewById(R.id.evaluation);
            evaluationText.setText(R.string.result3);

            ImageView trophyPicture = (ImageView) findViewById(R.id.result);
            trophyPicture.setImageResource(R.drawable.place3);

            //4th place
        } else {
            TextView evaluationText = (TextView) findViewById(R.id.evaluation);
            evaluationText.setText(R.string.result4);

            ImageView trophyPicture = (ImageView) findViewById(R.id.result);
            trophyPicture.setImageResource(R.drawable.place4);
        }
    };

    //onClick restart button

    public void reset(View v) {
        Intent intentReset = new Intent(this, Start.class);
        startActivity(intentReset);
    }
}
