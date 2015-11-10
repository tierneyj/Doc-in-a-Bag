package com.docinabag.myapplication2;

import java.io.Serializable;

public class PatientRecord implements Serializable {
    String firstName;
    String lastName;
    String month;
    String day;
    String year;
    Integer height;
    Integer weight;
    Integer glucose;
    Integer cholesterol;
    Integer bloodPressureOver;
    Integer bloodPressureUnder;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getGlucose() {
        return glucose;
    }

    public void setGlucose(Integer glucose) {
        this.glucose = glucose;
    }

    public Integer getCholesterol() {
        return cholesterol;
    }

    public void setCholesterol(Integer cholesterol) {
        this.cholesterol = cholesterol;
    }

    public Integer getBloodPressureOver() {
        return bloodPressureOver;
    }

    public void setBloodPressureOver(Integer bloodPressureOver) {
        this.bloodPressureOver = bloodPressureOver;
    }

    public Integer getBloodPressureUnder() {
        return bloodPressureUnder;
    }

    public void setBloodPressureUnder(Integer bloodPressureUnder) {
        this.bloodPressureUnder = bloodPressureUnder;
    }
}

