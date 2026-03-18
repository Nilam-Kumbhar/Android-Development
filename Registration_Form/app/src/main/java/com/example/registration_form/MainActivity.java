package com.example.registration_form;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etName, etRoll, etCourse;
    Button btnSubmit;
    ListView listView;

    ArrayList<String> studentList;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        etRoll = findViewById(R.id.etRoll);
        etCourse = findViewById(R.id.etCourse);
        btnSubmit = findViewById(R.id.btnSubmit);
        listView = findViewById(R.id.listView);

        studentList = new ArrayList<>();
        adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,
                studentList);

        listView.setAdapter(adapter);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = etName.getText().toString();
                String roll = etRoll.getText().toString();
                String course = etCourse.getText().toString();

                String data = "Name: " + name +
                        "\nRoll No: " + roll +
                        "\nCourse: " + course;

                studentList.add(data);
                adapter.notifyDataSetChanged();

                etName.setText("");
                etRoll.setText("");
                etCourse.setText("");
            }
        });
    }
}
