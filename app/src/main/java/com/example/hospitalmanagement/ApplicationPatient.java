package com.example.hospitalmanagement;

import android.app.Application;

import java.util.ArrayList;

public class ApplicationPatient extends Application {

    public static ArrayList<Patient> patients;
    @Override
    public void onCreate() {
        super.onCreate();
        patients=new ArrayList<>();
        Patient patient1=new Patient("ashish","aa","hdhdd","hhdhd","dhffnj","djshdsj");
        Patient patient2=new Patient("ashish","aa","hdhdd","hhdhd","hdjd","jdhdj");
        ApplicationPatient.patients.add(patient1);
        ApplicationPatient.patients.add(patient2);
    }
}
