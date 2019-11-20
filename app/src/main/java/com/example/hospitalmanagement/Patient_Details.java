package com.example.hospitalmanagement;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.core.Tag;

import java.util.ArrayList;
import java.util.Map;

public class Patient_Details extends AppCompatActivity {

    public static Map<String,Object> no_of_user;
    public ArrayList<Patient> patients;
    public static RecyclerView.Adapter personAdapter;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient__details);

        recyclerView =findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(Patient_Details.this));

        patients=new ArrayList<>();

        DatabaseReference mRef= FirebaseDatabase.getInstance().getReference();

        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                patients.clear();
                no_of_user=(Map<String, Object>) dataSnapshot.getValue();
                for(DataSnapshot snapshot:dataSnapshot.getChildren())
                {
                    Patient p=new Patient();
                    Map<String,Object> data=(Map<String, Object>) snapshot.getValue();
                    p.setUserIdno(snapshot.getKey());
                    p.setPhone(data.get("Phone").toString());
                    p.setAge(data.get("Age").toString());
                    p.setEmail(data.get("Email").toString());
                    p.setName(data.get("Name").toString());
                    p.setGender(data.get("Gender").toString());
                    patients.add(p);
                    Log.d("hello",data.get("Name").toString()+"\n"+data.get("Email").toString()+"\n"+data.get("Age").toString()+"\n"+data.get("Phone").toString()+"\n"+data.get("Gender").toString() +"\n"+snapshot.getKey());                }
                personAdapter =new PersonAdapter(patients);
                recyclerView.setAdapter(personAdapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                Log.w("hi", "Failed to read value.", databaseError.toException());
            }
        });




    }
}
