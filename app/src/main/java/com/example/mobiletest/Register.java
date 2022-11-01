package com.example.mobiletest;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
        ProgressDialog progressDialog = new ProgressDialog(this);
        String phoneValue = phone.getText().toString();
        String passwordlValue = password.getText().toString();
        String userNameValue = userName.getText().toString();
        String confirmPasswordlValue = confirpassword.getText().toString();
        progressDialog.setTitle("Loading");
        progressDialog.setMessage("Wait while loading...");
        progressDialog.setCancelable(false);
        progressDialog.show();

        ApiServices.apiservices.signUp(new User(phoneValue , userNameValue , passwordlValue , confirmPasswordlValue , 0.0)).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                User userRes = response.body();
                progressDialog.dismiss();
                if(userRes != null){
                    Toast.makeText(Register.this, "Register success", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(Register.this, "Register Fail", Toast.LENGTH_SHORT).show();
            }
        });
    }
}