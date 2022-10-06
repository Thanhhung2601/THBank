package com.example.mobiletest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Register extends AppCompatActivity {
    TextView phone , userName , password , confirpassword ;
    User newUser = null;
    public static int RESULT = 1000 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        phone = findViewById(R.id.phoneRegis);
        userName = findViewById(R.id.userNameregister);
        password = findViewById(R.id.passwordRegister);
        confirpassword = findViewById(R.id.confimpasswordRegister);
    }

    public void handleBack(View view){
        if(newUser != null){
            Intent intent = new Intent();
            intent.putExtra("user" , newUser);
            setResult(RESULT , intent);
            finish();
        }else{
            Intent intent = new Intent();
            intent.setClass(Register.this , MainActivity.class);
            startActivity(intent);
        }
    }

    public void handleRegister(View view){
        String phoneValue = phone.getText().toString();
        String passwordlValue = password.getText().toString();
        String userNameValue = userName.getText().toString();
        String confirmPasswordlValue = confirpassword.getText().toString();
        if(passwordlValue.equals(confirmPasswordlValue)){
            newUser = new User(phoneValue , userNameValue , passwordlValue);
            Toast.makeText(this, "Register success", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Password not correct", Toast.LENGTH_SHORT).show();
        }
    }
}