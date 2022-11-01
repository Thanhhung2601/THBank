package com.example.mobiletest;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.telecom.Call;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BankAdapter extends RecyclerView.Adapter<BankAdapter.BankViewHolder>  {
    Context context;
    ArrayList<BankTransfer> bankTransferArrayList;
    private ItemClickListener mItemListener;
    private ItemLongClickListener lItemListener;
    private User user   ;

    public BankAdapter(Context context, ArrayList<BankTransfer> bankTransferArrayList , ItemClickListener itemClickListener,ItemLongClickListener itemLongClickListener , User user) {
        this.context = context;
        this.bankTransferArrayList = bankTransferArrayList;
        this.mItemListener = itemClickListener;
        this.lItemListener = itemLongClickListener ;
        this.user = user ;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public ArrayList<BankTransfer> getBankTransferArrayList() {
        return bankTransferArrayList;
    }

    public void setBankTransferArrayList(ArrayList<BankTransfer> bankTransferArrayList) {
        this.bankTransferArrayList = bankTransferArrayList;
    }

    public ItemClickListener getmItemListener() {
        return mItemListener;
    }

    public void setmItemListener(ItemClickListener mItemListener) {
        this.mItemListener = mItemListener;
    }

    public ItemLongClickListener getlItemListener() {
        return lItemListener;
    }

    public void setlItemListener(ItemLongClickListener lItemListener) {
        this.lItemListener = lItemListener;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
        holder.date.setText(bankTransfer.getCreatedAt());
        holder.sodu.setText(bankTransfer.getInfomationBank());
        if(bankTransfer.getSender().equals(user.getPhone())){
            holder.sotien.setTextColor(Color.parseColor("#ff1a1a"));
            holder.sotien.setText("-" + bankTransfer.getMoneyBank() + " VND");
        }else{
            holder.sotien.setTextColor(Color.parseColor("#00cc00"));
            holder.sotien.setText("+" + bankTransfer.getMoneyBank() + " VND");
        }

        holder.itemView.setOnClickListener(view -> {
            mItemListener.onItemClick(bankTransferArrayList.get(position));
        });
        holder.itemView.setOnLongClickListener(view -> {
            lItemListener.longItemClick(position);

            return false ;
        });

    }

    public interface ItemClickListener{
        void onItemClick(BankTransfer details);
    }
    public interface ItemLongClickListener{
        void longItemClick(Integer index);
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
