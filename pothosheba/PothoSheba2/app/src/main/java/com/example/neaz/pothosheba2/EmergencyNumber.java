package com.example.neaz.pothosheba2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EmergencyNumber extends AppCompatActivity {

    EditText first,second,third;
    String firstSting,secondString,thirdString,getFirstSting,getSecondString,getThirdString;
    Button save;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency_number);
        final SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);

        first=(EditText)findViewById(R.id.firstNumber);
        second=(EditText)findViewById(R.id.secondNumber);
        third=(EditText)findViewById(R.id.thirdNumber);
        save=(Button)findViewById(R.id.save);

        getFirstSting=sharedPref.getString("first", "");
        getSecondString=sharedPref.getString("second", "");
        getThirdString=sharedPref.getString("third", "");

        first.setText(getFirstSting);
        second.setText(getSecondString);
        third.setText(getThirdString);



        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstSting=first.getText().toString();
                secondString=second.getText().toString();
                thirdString=third.getText().toString();
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("first",firstSting);
                editor.putString("second", secondString);
                editor.putString("third",thirdString);
                editor.apply();
                finish();

                Intent intent = new Intent(EmergencyNumber.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
