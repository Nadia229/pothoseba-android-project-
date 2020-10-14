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

public class Login extends AppCompatActivity {

    EditText name,password;
    String userName,userPassword,registeredName,registeredPassword;
    Button login,register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        name=(EditText)findViewById(R.id.nameLogin);
        password=(EditText)findViewById(R.id.passwordLogin);
        login =(Button) findViewById(R.id.login);
        register=(Button) findViewById(R.id.registerInLogin);

        final SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                userName=name.getText().toString();
                userPassword=password.getText().toString();

                registeredName = sharedPref.getString(userPassword, "");
                registeredPassword = sharedPref.getString(userName, "");
                Toast.makeText(Login.this,"registeredName:"+registeredName+"\nuserName:"+userName+"\nrepass:"+registeredPassword+"\npass:"+password,Toast.LENGTH_LONG).show();
                if (registeredName.equals(userName) && registeredPassword.equals(userPassword))
                {
                    Toast.makeText(Login.this,"Login Successfull",Toast.LENGTH_LONG).show();
                    SharedPreferences.Editor editor = sharedPref.edit();
                    editor.putBoolean("Loggedin", true);
                    editor.apply();
                    finish();

                    Intent intent = new Intent(Login.this,MainActivity.class);
                    startActivity(intent);
                }
                //Toast.makeText(Login.this,"Login Failed",Toast.LENGTH_LONG).show();


            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Login.this,Register.class);
                startActivity(i);

            }
        });

    }
}
