package com.brijesh.athetaassignmaent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class AddActivity extends AppCompatActivity {
    EditText fName,lName,add,phone;
    Button submit;
    ProgressBar pb;

    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        fName = findViewById(R.id.fName);
        lName = findViewById(R.id.lName);
        add = findViewById(R.id.add);
        phone = findViewById(R.id.phone);
        submit = findViewById(R.id.button);
        pb = findViewById(R.id.progressBar);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Fname = fName.getText().toString();
                String Lname = lName.getText().toString();
                String Phone = phone.getText().toString();
                String Add = add.getText().toString();
                if(Fname.isEmpty() || Lname.isEmpty() || Phone.isEmpty() || Add.isEmpty() || Phone.length() < 10){
                    if(Fname.isEmpty()){
                        fName.setError("Empty First Name");
                    }else if(Lname.isEmpty()){
                        lName.setError("Empty Last Name");
                    }else if(Phone.isEmpty()){
                        phone.setError("Empty Phone Number");
                    }else if(Add.isEmpty()){
                        add.setError("Empty Address");
                    }else {
                        phone.setError("invalid Phone Number");
                    }
                }else {
                    pb.setVisibility(View.VISIBLE);
                    submit.setVisibility(View.INVISIBLE);

//                    String Fname = fName.getText().toString();
//                    String Lname = lName.getText().toString();
//                    String Phone = phone.getText().toString();
//                    String Add = add.getText().toString();

                    Map<String, Object> user = new HashMap<>();
                    user.put("first", Fname);
                    user.put("last", Lname);
                    user.put("phone", Phone);
                    user.put("add", Add);
                    db.collection("Users")
                            .add(user)
                            .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                                @Override
                                public void onSuccess(DocumentReference documentReference) {
                                    Toast.makeText(AddActivity.this,"done",Toast.LENGTH_LONG).show();
                                    Intent intent = new Intent(AddActivity.this, MainActivity.class);
                                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                    startActivity(intent);
                                }
                            })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(AddActivity.this,"not done",Toast.LENGTH_LONG).show();
                                    pb.setVisibility(View.INVISIBLE);
                                    submit.setVisibility(View.VISIBLE);
                                }
                            });
                }
            }
        });





    }
}