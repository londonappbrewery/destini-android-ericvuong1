package com.londonappbrewery.destini;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    TextView storyTextView;
    Button buttonTop;
    Button buttonBottom;
    int storyIndex;

    final Scenario[] mScenario = {

            new Scenario(R.string.T1_Story, R.string.T1_Ans1, R.string.T1_Ans2),
            new Scenario(R.string.T2_Story, R.string.T2_Ans1, R.string.T2_Ans2),
            new Scenario(R.string.T3_Story, R.string.T3_Ans1, R.string.T3_Ans2),
            new Scenario(R.string.T4_End, 0, 0),
            new Scenario(R.string.T5_End, 0, 0),
            new Scenario(R.string.T6_End, 0, 0)
    };





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState!=null) {
            storyIndex = savedInstanceState.getInt("storyIndex");
        } else {
            storyIndex = 0;
        }
        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:t

        storyTextView = (TextView) findViewById(R.id.storyTextView);
        buttonTop = (Button) findViewById(R.id.buttonTop);
        buttonBottom = (Button) findViewById(R.id.buttonBottom);

        storyTextView.setText(mScenario[storyIndex].getStoryText());
        if(storyIndex<3) {
            buttonBottom.setText(mScenario[storyIndex].getAnswer1());
            buttonTop.setText(mScenario[storyIndex].getAnswer2());
        } else {
            buttonBottom.setVisibility(View.GONE);
            buttonTop.setVisibility(View.GONE);
        }



        // TODO: implement the bundle save for orientation!
        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:

        buttonTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (storyIndex == 0){
                    storyIndex = 2;
                    storyTextView.setText(mScenario[storyIndex].getStoryText());
                    buttonTop.setText(mScenario[storyIndex].getAnswer1());
                    buttonBottom.setText(mScenario[storyIndex].getAnswer2());
                } else if(storyIndex == 1){
                    storyIndex = 2;
                    storyTextView.setText(mScenario[storyIndex].getStoryText());
                    buttonTop.setText(mScenario[storyIndex].getAnswer1());
                    buttonBottom.setText(mScenario[storyIndex].getAnswer2());
                } else if(storyIndex == 2){
                    storyIndex = 5;
                    storyTextView.setText(mScenario[storyIndex].getStoryText());
                    buttonBottom.setVisibility(View.GONE);
                    buttonTop.setVisibility(View.GONE);
                }

            }
        });

        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:

        buttonBottom.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (storyIndex == 0){
                    storyIndex = 1;
                    storyTextView.setText(mScenario[storyIndex].getStoryText());
                    buttonTop.setText(mScenario[storyIndex].getAnswer1());
                    buttonBottom.setText(mScenario[storyIndex].getAnswer2());
                } else if (storyIndex == 1) {
                    storyIndex = 3;
                    storyTextView.setText(mScenario[storyIndex].getStoryText());
                    buttonTop.setVisibility(View.GONE);
                    buttonBottom.setVisibility(View.GONE);
                } else if (storyIndex == 2) {
                    storyIndex = 4;
                    storyTextView.setText(mScenario[storyIndex].getStoryText());
                    buttonTop.setVisibility(View.GONE);
                    buttonBottom.setVisibility(View.GONE);
                }
            }
        });


    }
    public void alert() {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setMessage("Hello!");
        alert.setPositiveButton("Close Application", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        alert.show();
    }

    @Override
    public void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putInt("storyIndex", storyIndex);
    }
}

