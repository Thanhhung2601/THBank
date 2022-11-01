package com.example.mobiletest;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Banking#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Banking extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    static User userr ;

    public Banking(User user) {
        // Required empty public constructor
        this.userr = user ;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Banking.
     */
    // TODO: Rename and change types and number of parameters
    public static Banking newInstance(String param1, String param2) {
        Banking fragment = new Banking(userr);
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_banking, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        CardView btnBanking = view.findViewById(R.id.btnBanking);
        TextView stk = view.findViewById(R.id.stk);
        TextView moneyBankigng = view.findViewById(R.id.moneybanktransfer);
        TextView infoBanking = view.findViewById(R.id.infoBanking);



        btnBanking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ApiServices.apiservices.bankTransfer(new BankTransfer(userr.getPhone(),stk.getText().toString() , infoBanking.getText().toString() ,
                        Double.parseDouble(moneyBankigng.getText().toString()))).enqueue(new Callback<BankTransfer>() {
                    @Override
                    public void onResponse(Call<BankTransfer> call, Response<BankTransfer> response) {
                        BankTransfer bankResponse = response.body();
                        Toast.makeText(getActivity().getApplicationContext(), "Banking success " , Toast.LENGTH_SHORT).show();
                        stk.setText("");
                        moneyBankigng.setText("");
                        infoBanking.setText("");
                    }

                    @Override
                    public void onFailure(Call<BankTransfer> call, Throwable t) {

                    }
                });
                ApiServices.apiservices.updateWalletUser(new UpdateWallet(userr.getPhone(),stk.getText().toString(),Double.parseDouble(moneyBankigng.getText().toString()))).enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {

                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {

                    }
                });
            }
        });
    }
}