package com.example.hospitalmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainMenu extends AppCompatActivity {

    TextView clientname;
    Button newpatient,getAppointment,patientdetail,medicalReport,contactus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        Intent intent=getIntent();
        String Client=intent.getStringExtra("name");
        clientname=findViewById(R.id.clientname);
        clientname.setText(Client);
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

        getAppointment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainMenu.this,GetAppointment.class);
                startActivity(intent);

            }
        });

        patientdetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent =new Intent(MainMenu.this,Patient_Details.class);
                startActivity(intent);
            }
        });
    }
}
