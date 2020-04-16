package com.example.homowork5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Main2ActivityStudents extends AppCompatActivity {
    SomeClass someClass;   public  static  String TEXT_KEY="text_key";
    static  String RESULT_KEY="RESULT_KEY";


    EditText editFullName, editPhone, editAge,  editGroup, editCourse;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2_students);

        editFullName = findViewById(R.id.main2_edit1);
        editGroup = findViewById(R.id.main2_edit2);
        editPhone = findViewById(R.id.main2_edit3);
        editAge = findViewById(R.id.main2_edit4);
        editCourse = findViewById(R.id.main2_edit5);


        Button save=findViewById(R.id.main_2_save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();

                someClass.first=editFullName.getText().toString();

                intent.putExtra(MainActivity.RESULT_KEY,someClass);
                setResult(RESULT_OK,intent);
                finish();
            }
        });


        if (getIntent()!=null){
                                                    // someClass=getIntent().getStringExtra(TEXT_KEY);
            someClass = (SomeClass) getIntent().getSerializableExtra(TEXT_KEY);
            editFullName.setText(someClass.text);
            someClass = (SomeClass) getIntent().getSerializableExtra(TEXT_KEY);
            editAge.setText(someClass.age);
            someClass = (SomeClass) getIntent().getSerializableExtra(TEXT_KEY);
            editPhone.setText(someClass.phone);
            someClass = (SomeClass) getIntent().getSerializableExtra(TEXT_KEY);
            editGroup.setText(someClass.group);
            someClass = (SomeClass) getIntent().getSerializableExtra(TEXT_KEY);
            editCourse.setText(someClass.course);



        }else {


        }
    }

    public void Close(View view) {
        someClass.age = editAge.getText().toString();
        someClass.phone = editPhone.getText().toString();
        someClass.group = editGroup.getText().toString();
        someClass.course = editCourse.getText().toString();



        TextView group =  findViewById(R.id.main2_group);
        group.setText(someClass.age);
        TextView course = findViewById(R.id.main2_course);
        course.setText(someClass.course);


        TextView age =  findViewById(R.id.main2_age);
        age.setText(someClass.age);
        TextView phone =  findViewById(R.id.main2_phone);
        phone.setText(someClass.phone);


    }
}