package com.example.mobiletest;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Detail#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Detail extends Fragment {
    TextView date , sotien , sothamchieu , phone ,userName;
    static BankTransfer bankData;
    static User user ;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Detail(BankTransfer bankData , User user) {
        // Required empty public constructor
        this.bankData = bankData;
        this.user = user ;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Detail.
     */
    // TODO: Rename and change types and number of parameters
    public static Detail newInstance(String param1, String param2) {
        Detail fragment = new Detail(bankData , user);
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
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        date =view.findViewById(R.id.dateDetail);
        sotien = view.findViewById(R.id.soTienDetail);
        sothamchieu = view.findViewById(R.id.thamChieuDetail);
        phone = view.findViewById(R.id.phoneDetail);
        userName = view.findViewById(R.id.userNameDetail);
        date.setText(bankData.getCreatedAt());
        sotien.setText(Double.toString(bankData.getMoneyBank()));
        sothamchieu.setText(bankData.get_id());
        userName.setText(user.getUserName());
        phone.setText(user.getPhone());

    }
}