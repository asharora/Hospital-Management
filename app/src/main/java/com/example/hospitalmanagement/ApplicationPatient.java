package com.example.hospitalmanagement;

import android.app.Application;

import java.util.ArrayList;

public class ApplicationPatient extends Application {

    public static ArrayList<Patient> patients;
    @Override
    public void onCreate() {
        super.onCreate();
        patients=new ArrayList<>();
    }
}
