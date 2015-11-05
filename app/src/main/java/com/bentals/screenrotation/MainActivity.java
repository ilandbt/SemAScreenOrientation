package com.bentals.screenrotation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    //best practice TAG = class name (ActivityLifeCycle)
    private final String TAG = getClass().getSimpleName();


    private final String inputStateKey = "inputStateKey";

    //views
    private EditText input;

    //Two Activity life cycle function that are important for screen rotation
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG, "onCreate: " + savedInstanceState);

        //init views
        input = (EditText) findViewById(R.id.input);


        //check if we have a bundle
        if (savedInstanceState != null) {
            //screen was rotated or home button was pressed
            //(or any other action that moved the app in to the background)
            //and we saved some values in the savedInstanceState bundle

            //get saved value
            String savedText = savedInstanceState.getString(inputStateKey);
            input.setText(savedText);


        } else {
            //the first time the app is launched or no state was saved in screen rotation.`
        }

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i(TAG, "onSaveInstanceState");

        //save input text in to the state bundle
        String inputText = input.getText().toString();
        outState.putString(inputStateKey, inputText);

    }



    //The rest od the activities life cycle
    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause");
    }




    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy");
    }


    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart");
    }
}
