package com.example.homowork5;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements IonTextClick {

    MainAdapter adapter=new MainAdapter();
    static  String RESULT_KEY="result_key";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter=new MainAdapter();                                                //1 yes
        adapter.listener=this;
        RecyclerView recyclerView= findViewById(R.id.recycler_view);
        recyclerView.setAdapter(adapter);

    }


    public  void open2Activity(SomeClass someClass){
        Intent intent=new Intent(this,Main2ActivityStudents.class);
        intent.putExtra(Main2ActivityStudents.TEXT_KEY,someClass);
        startActivityForResult(intent,42);

    }


    void changeData(SomeClass someClass){

        adapter.change(someClass);
    }




    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        SomeClass someClass=(SomeClass)data.getSerializableExtra(RESULT_KEY);
        changeData(someClass);

    }

    @Override
    public void onTextClick(SomeClass someClass) {
        open2Activity(someClass);
    }
}
