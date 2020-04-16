package com.example.homowork5;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

public class MainViewHolder extends RecyclerView.ViewHolder {
    private TextView textView;
    IonTextClick listener;                        //               MainActivity Activity;
    SomeClass someClass;
    public MainViewHolder(@NonNull View itemView) {
        super(itemView);
        textView=itemView.findViewById(R.id.vh_text_name);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onTextClick(someClass);  //open2Activity
            }
        });
    }

    public void onBind(SomeClass someClass){
        this.someClass=someClass;
        textView.setText(someClass.first);
    }


}
