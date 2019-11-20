package com.example.hospitalmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class GetAppointment extends AppCompatActivity {

    EditText GetAppointment_Patient_Id;
    AutoCompleteTextView getAppointment_problem;
    Button BookAppointment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_appointment);

        GetAppointment_Patient_Id=findViewById(R.id.GetAppointment_patientID);
        getAppointment_problem=findViewById(R.id.GetAppointment_problem);
        String[] problems={"Allergists/Immunologists","Anesthesiologists","Cardiologists","Dermatologists"};

        ArrayAdapter myAdapter=new ArrayAdapter(GetAppointment.this,android.R.layout.simple_dropdown_item_1line,problems);
        getAppointment_problem.setAdapter(myAdapter);
        getAppointment_problem.setThreshold(1);

        BookAppointment=findViewById(R.id.GetAppointment_Book);

        BookAppointment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(Patient_Details.no_of_user.containsKey(GetAppointment_Patient_Id.getText().toString()))
                {
                    Toast.makeText(getApplicationContext(),"hello",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
