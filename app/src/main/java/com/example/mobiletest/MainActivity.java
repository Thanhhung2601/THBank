package com.example.mobiletest;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    ArrayList<User> users = new ArrayList<User>();
    TextView userName , password ;
    User newUser ;
    User userFinded = null ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userName = findViewById(R.id.userNameLogin);
        password = findViewById(R.id.passwordLogin);
    }

    public void handleRegister(View view){
        Intent intent = new Intent();
        intent.setClass(MainActivity.this,Register.class);
        startActivityForResult(intent , Register.RESULT);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void handleLogin(View view){
        handlePost();
    }

    public void handlePost (){
        ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Loading");
        progressDialog.setMessage("Wait while loading...");
        progressDialog.setCancelable(false);
        progressDialog.show();
        ApiServices.apiservices.signIn(new User("",userName.getText().toString() ,password.getText().toString() , 0.0)).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                User userRes = response.body();
                progressDialog.dismiss();
                if(userRes != null){
                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this,Home.class) ;
                    intent.putExtra("userData" , userRes);
                    startActivity(intent);
                    Toast.makeText(MainActivity.this, "login success", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "SomeThing Wrong Please check your userName and password", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Fail call API", Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == Register.RESULT){
            newUser = (User) data.getExtras().getSerializable("user");
            users.add(newUser);
        }
    }
}