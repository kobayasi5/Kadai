package com.kobayasi.kokadai01;

import java.util.ArrayList;
import java.util.Locale;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
    private static final int REQUEST_CODE = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                	Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
            		intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
            		intent.putExtra(RecognizerIntent.EXTRA_PROMPT,"Speech recognition demo");
            		intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE,Locale.JAPAN.toString());
            		intent.putExtra(RecognizerIntent.EXTRA_MAX_RESULTS,1);
            		startActivityForResult(intent,REQUEST_CODE);
                } catch (ActivityNotFoundException e) {
                    // このインテントに応答できるアクティビティがインストールされていない場合
                    Toast.makeText(MainActivity.this,
                        "ActivityNotFoundException", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    // アクティビティ終了時に呼び出される
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    	 String resultsString = "";
        ArrayList<String> results = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
         resultsString = results.get(0);
        if (resultsString.indexOf("疲れた") !=-1) {
        	resultsString="がんばりや";
        		Toast toast = Toast.makeText(this, resultsString, Toast.LENGTH_LONG);
        		toast.setGravity(Gravity.CENTER, 0, 0);
    			toast.show();
        }else if(resultsString.indexOf("眠い") !=-1){
        	resultsString="早起きは三文の得";
        		Toast toast = Toast.makeText(this, resultsString, Toast.LENGTH_LONG);
        		toast.setGravity(Gravity.CENTER, 0, 0);
				toast.show();
        }else{
        	Toast toast = Toast.makeText(this, resultsString, Toast.LENGTH_LONG);
    		toast.setGravity(Gravity.CENTER, 0, 0);
			toast.show();
        }

        super.onActivityResult(requestCode, resultCode, data);
    }
}