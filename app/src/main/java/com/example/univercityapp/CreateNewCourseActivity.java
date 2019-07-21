package com.example.univercityapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class CreateNewCourseActivity extends AppCompatActivity {

    Button btAdd;
    EditText etCourseName;
    EditText etUnitsOfCredit;
    EditText etMark;
    ListView listView;

    ArrayList<Course> courses = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_course);

        btAdd = findViewById(R.id.btAdd);
        etCourseName = findViewById(R.id.etCourseName);
        etUnitsOfCredit = findViewById(R.id.etUnitsOfCredit);
        etMark = findViewById(R.id.etMark);
        listView = findViewById(R.id.listView);

        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getInputCourseName = etCourseName.getText().toString();
                int getInputUnitsOfCredit = Integer.parseInt(etUnitsOfCredit.getText().toString());
                int getInputMark = Integer.parseInt(etMark.getText().toString());

                if (courses.contains(getInputCourseName)) {
                    Toast.makeText(getBaseContext(), "Item Already Added To The Array", Toast.LENGTH_LONG).show();
                }
                else if (getInputCourseName == null || getInputCourseName.trim().equals("")) {
                    Toast.makeText(getBaseContext(), "Input Field Is Empty", Toast.LENGTH_LONG).show();
                }
                else {
                    courses.add(new Course(getInputCourseName, getInputUnitsOfCredit, getInputMark));

                    for (int i = 0; i < courses.size(); i++) {
                        System.out.println(courses.get(i).getName() + courses.get(i).getUoc() + courses.get(i).getMark());
                        ArrayAdapter<Course> adapter = new ArrayAdapter<Course>(CreateNewCourseActivity.this, android.R.layout.simple_list_item_1, courses);
                        listView.setAdapter(adapter);
                    }


                }
            }
        });
    }

    public void launchMyWamScreen(View v) {
        Intent myIntent = new Intent(getBaseContext(), MyWamActivity.class);
        startActivity(myIntent);
    }
}