package com.example.hospitalmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

//import com.google.firebase.FirebaseApp;
//import com.google.firebase.database.FirebaseDatabase;
//import com.google.firebase.iid.FirebaseInstanceIdReceiver;

import java.util.Random;

public class NewPatient extends AppCompatActivity {

    EditText newpatient_name,newpatient_age,newpatient_phone,newpatient_email;
    RadioGroup newpatient_gender;
    RadioButton newpatient_male,newpatient_female;
    Button newpatient_submit;
    private FirebaseDatabase mDatabase;
    private DatabaseReference mRef;

//    private Firebase mRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_patient);

        newpatient_name=findViewById(R.id.newpatient_input_name);
        newpatient_email=findViewById(R.id.newpatient_email);
        newpatient_age=findViewById(R.id.newpatient_age);
        newpatient_phone=findViewById(R.id.newpatient_phone);
        newpatient_gender=findViewById(R.id.gender_radio_group);
        newpatient_male=findViewById(R.id.male_radio_btn);
        newpatient_female=findViewById(R.id.female_radio_btn);

        newpatient_submit=findViewById(R.id.newpatient_submit);
        newpatient_gender.clearCheck();

        newpatient_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                     if(newpatient_male.isChecked()==false && newpatient_female.isChecked()==false)
                     {
                         Toast.makeText(NewPatient.this, "please fill all the details", Toast.LENGTH_SHORT).show();
                     }
                     else
                     {
                         Random random=new Random();
                         int userID=random.nextInt(10000);
                         Patient patient;


                         if(newpatient_male.isChecked())
                         {
                           //  Toast.makeText(NewPatient.this,"male",Toast.LENGTH_SHORT).show();
                             patient=new Patient(newpatient_name.getText().toString(),newpatient_phone.getText().toString(),userID+"","male",newpatient_email.getText().toString(),newpatient_age.getText().toString());
                         }
                         else if(newpatient_female.isChecked())
                         {
                             //Toast.makeText(NewPatient.this,"Female",Toast.LENGTH_SHORT).show();
                             patient=new Patient(newpatient_name.getText().toString(),newpatient_phone.getText().toString(),userID+"","female",newpatient_email.getText().toString(),newpatient_age.getText().toString());
                         }
                         else
                         {
                             patient=null;
                         }
//                         int selectedId = newpatient_gender.getCheckedRadioButtonId();
//                             RadioButton radioButton
//                                     = (RadioButton)newpatient_gender
//                                     .findViewById(selectedId);
//
//                              Now display the value of selected item
//                              by the Toast message
//                             Toast.makeText(NewPatient.this,
//                                     radioButton.getText(),
//                                     Toast.LENGTH_SHORT)
//                                     .show();
//                         patient=new Patient(newpatient_name.getText().toString(),newpatient_phone.getText().toString(),userID+"",  radioButton.getText().toString());


                       ApplicationPatient.patients.add(patient);
                       Toast.makeText(NewPatient.this,"UserID = "+userID+"\nName = "+patient.getName()+"\nPhone Number = "+patient.getPhone()+"\nGender = "+patient.getGender(),Toast.LENGTH_SHORT).show();


                       clearText();
                       addFirebase(patient);
                     }


                    // Patient_Details.personAdapter.notifyDataSetChanged();






            }
        });
    }

    public void addFirebase(Patient patient)
    {
        mDatabase=FirebaseDatabase.getInstance();
        mRef=mDatabase.getReference();
        DatabaseReference mRef1=mRef.child("User_ID - "+patient.getUserIdno());

        mRef1.child("Phone").setValue(patient.getPhone());
        mRef1.child("Gender").setValue(patient.getGender());
        mRef1.child("Age").setValue(patient.getAge());
        mRef1.child("Email").setValue(patient.getEmail());
        mRef1.child("Name").setValue(patient.getName());


    }

    public void clearText()
    {
        newpatient_gender.clearCheck();
        newpatient_email.setText("");
        newpatient_name.setText("");
        newpatient_age.setText("");
        newpatient_phone.setText("");
    }
}
