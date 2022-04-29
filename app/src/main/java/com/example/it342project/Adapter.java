package com.example.it342project;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Adapter extends RecyclerView.Adapter <Adapter.ViewHolder> {


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);

        return new ViewHolder(view);

    } // End of onCreateViewHolder


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }// End of onBindViewHolder

    @Override
    public int getItemCount() {
        return 0;
    } // End of getItemCount()

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }// End of constructor

    }// End of ViewHolder class

} // End of Adapter class
