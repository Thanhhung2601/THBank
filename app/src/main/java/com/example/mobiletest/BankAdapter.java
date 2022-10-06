package com.example.mobiletest;

import android.content.Context;
import android.telecom.Call;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BankAdapter extends RecyclerView.Adapter<BankAdapter.BankViewHolder>  {
    Context context;
    ArrayList<BankTransfer> bankTransferArrayList;
    private ItemClickListener mItemListener;

    public BankAdapter(Context context, ArrayList<BankTransfer> bankTransferArrayList , ItemClickListener itemClickListener) {
        this.context = context;
        this.bankTransferArrayList = bankTransferArrayList;
        this.mItemListener = itemClickListener;
    }

    @NonNull
    @Override
    public BankViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.row_banktranfer,parent ,false);

        return new BankViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull BankViewHolder holder, int position) {
        BankTransfer bankTransfer = bankTransferArrayList.get(position);
        holder.date.setText(bankTransfer.getDate());
        holder.sodu.setText(bankTransfer.getRemainder() + " VND");
        holder.sotien.setText("+" + bankTransfer.getMoney() + " VND");
        holder.itemView.setOnClickListener(view -> {
            mItemListener.onItemClick(bankTransferArrayList.get(position));
        });
    }

    public interface ItemClickListener{
        void onItemClick(BankTransfer details);
    }

    @Override
    public int getItemCount() {
        return bankTransferArrayList.size();
    }

    public static class BankViewHolder extends  RecyclerView.ViewHolder{
        TextView sotien , sodu , date;

        public BankViewHolder(@NonNull View itemView) {
            super(itemView);
            sodu = itemView.findViewById(R.id.sodu);
            sotien = itemView.findViewById(R.id.sotien);
            date = itemView.findViewById(R.id.date_bank);
        }
    }
}
