package com.example.mobiletest;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HistoryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HistoryFragment extends Fragment {
    RecyclerView recyclerView;
    static User user ;
    BankAdapter bankAdapter ;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    static ArrayList<BankTransfer> arrayBankTransfer = new ArrayList<BankTransfer>() ;

    public HistoryFragment(User userPass) {
        // Required empty public constructor
        this.user = userPass;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HistoryFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HistoryFragment newInstance(String param1, String param2) {
        HistoryFragment fragment = new HistoryFragment(user);
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

        ApiServices.apiservices.getAllBankTransfer(new ResquestGetAllTransfer(user.getPhone())).enqueue(new Callback<ResponBankTransfer>() {
            @Override
            public void onResponse(Call<ResponBankTransfer> call, Response<ResponBankTransfer> response) {
                arrayBankTransfer = response.body().getArrBank() ;
                recyclerView = getView().findViewById(R.id.review);
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                recyclerView.setHasFixedSize(true);


                 bankAdapter = new BankAdapter(getContext(), arrayBankTransfer, new BankAdapter.ItemClickListener() {
                    @Override
                    public void onItemClick(BankTransfer details) {
                        replaceFragment(new Detail(details, user));
                    }
                }, new BankAdapter.ItemLongClickListener() {
                    @Override
                    public void longItemClick(Integer index) {
                        AlertDialog.Builder alertDialog = new AlertDialog.Builder(getContext());
                        alertDialog.setTitle("Thong bao");
                        alertDialog.setMessage("Ban co chac chan muon xoa khong");
                        alertDialog.setPositiveButton("Co", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                ArrayList<BankTransfer> dataBankTransfer = new ArrayList<>();
                                String idDelete = "";
                                for(int position = 0; position < bankAdapter.getBankTransferArrayList().size(); position++) {
                                    if(position != index){
                                        dataBankTransfer.add(bankAdapter.getBankTransferArrayList().get(position));
                                    }else{
                                        idDelete = bankAdapter.getBankTransferArrayList().get(position).get_id();
                                    }
                                }
                                bankAdapter.setBankTransferArrayList(dataBankTransfer);
                                bankAdapter.notifyDataSetChanged();
                                ApiServices.apiservices.deleteHistory(new BankTransfer(idDelete)).enqueue(new Callback<BankTransfer>() {
                                    @Override
                                    public void onResponse(Call<BankTransfer> call, Response<BankTransfer> response) {
                                        Toast.makeText(getContext(), "Xoa thanh cong", Toast.LENGTH_SHORT).show();
                                    }

                                    @Override
                                    public void onFailure(Call<BankTransfer> call, Throwable t) {

                                    }
                                });
                            }
                        });
                        alertDialog.setNegativeButton("Khong", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                alertDialog.setCancelable(true);
                            }
                        });
                        alertDialog.show();
                    }
                }, user);
                recyclerView.setAdapter(bankAdapter);
                bankAdapter.notifyDataSetChanged();
                recyclerView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    }
                });
            }

            @Override
            public void onFailure(Call<ResponBankTransfer> call, Throwable t) {

            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_history, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }
    private void replaceFragment(Fragment fragment){
       FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_main,fragment);
        fragmentTransaction.commit();
    }
}