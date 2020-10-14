package com.example.neaz.pothosheba2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    EditText name,password;
    Button signIn;
    String userName,userPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        name=(EditText)findViewById(R.id.name);
        password=(EditText)findViewById(R.id.password);
        signIn =(Button) findViewById(R.id.signIn);
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userName=name.getText().toString();
                userPassword=password.getText().toString();
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putBoolean("Registered", true);
                editor.putString(userName, userPassword);
                editor.putString(userPassword, userName);
                editor.apply();
                finish();

                Toast.makeText(Register.this,userName+"\n"+password,Toast.LENGTH_LONG).show();

                Intent intent = new Intent(Register.this,Login.class );
                startActivity(intent);



            }
        });

    }
}
