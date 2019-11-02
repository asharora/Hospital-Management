package com.example.hospitalmanagement;

public class Patient {

    private String name;
    private String phone;
    private String userIdno;
    private String gender;


    public Patient(String name, String phone, String userIdno, String gender) {
        this.name = name;
        this.phone = phone;
        this.userIdno = userIdno;
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUserIdno() {
        return userIdno;
    }

    public void setUserIdno(String userIdno) {
        this.userIdno = userIdno;
    }
}
