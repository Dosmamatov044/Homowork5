package com.example.homowork5;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class MainAdapter extends RecyclerView.Adapter<MainViewHolder> {


    ArrayList<SomeClass> Student;
    IonTextClick listener;                        //MainActivity Activity;

    public MainAdapter() {
        Student = new ArrayList<>();
        for (int i = 1; i <= 15; i++) {
            SomeClass someClass = new SomeClass();
            someClass.position = i;
            Student.add(someClass);
        }
    }

    public  void change(SomeClass someClass){
        Student.set(someClass.position,someClass);


        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View v=inflater.inflate(R.layout.vuew_holder_main,parent,false);
        MainViewHolder holder=new MainViewHolder(v);
        holder.listener=listener;




        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
        holder.onBind(Student.get(position));

    }

    @Override
    public int getItemCount() {
        return Student.size();
    }
}
