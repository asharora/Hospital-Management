package com.example.hospitalmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainMenu extends AppCompatActivity {

    Button newpatient,getAppointment,patientdetail,medicalReport,contactus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        newpatient=findViewById(R.id.newpatient);
        getAppointment=findViewById(R.id.GetAppointment);
        patientdetail=findViewById(R.id.PatientDetial);
        medicalReport=findViewById(R.id.MedicalReport);
        contactus=findViewById(R.id.contactus);

        newpatient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainMenu.this,NewPatient.class);
                startActivity(intent);
            }
        });
    }
}
