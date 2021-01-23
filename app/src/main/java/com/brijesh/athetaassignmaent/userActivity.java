package com.brijesh.athetaassignmaent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class userActivity extends AppCompatActivity {
    Intent intent;
    TextView fName,lName,add,phone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        intent = getIntent();
        final String First = intent.getStringExtra("fname");
        final String Last = intent.getStringExtra("lname");
        final String Phone = intent.getStringExtra("phone");
        final String Add = intent.getStringExtra("add");


        fName = findViewById(R.id.fName);
        lName = findViewById(R.id.lName);
        add = findViewById(R.id.add);
        phone = findViewById(R.id.phone);

        fName.setText(First);
        lName.setText(Last);
        add.setText(Add);
        phone.setText(Phone);

    }
}
