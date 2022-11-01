package com.example.mobiletest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiServices {
    Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
    ApiServices apiservices = new Retrofit.Builder().baseUrl("http://10.0.2.2:5000").addConverterFactory(GsonConverterFactory.create(gson)).build().create(ApiServices.class);

    @POST("/user/signIn")
    Call<User> signIn(@Body User user);

    @POST("/user/signUp")
    Call<User> signUp(@Body User user);

    @POST("/bank/banktransfer")
    Call<BankTransfer> bankTransfer(@Body BankTransfer bankTransfer);

    @POST("/bank/getAllTransfer")
    Call<ResponBankTransfer> getAllBankTransfer(@Body ResquestGetAllTransfer sender);

    @POST("/bank/updateWallet")
    Call<User> updateWalletUser(@Body UpdateWallet updateWallet);

    @POST("/user/getUserById")
    Call<User> getUserById(@Body User user);

    @POST("/bank/deleteHistory")
    Call<BankTransfer> deleteHistory(@Body BankTransfer bankTransfer);

}


