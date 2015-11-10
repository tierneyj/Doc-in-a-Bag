package com.docinabag.myapplication2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class PatientRecordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_record);

        PatientRecord newPatient = (PatientRecord)getIntent().getSerializableExtra(CreateNewPatientActivity.SER_KEY);

        TextView textViewName = (TextView)findViewById(R.id.textView_firstName);
        TextView textViewDOB = (TextView)findViewById(R.id.textViewDOB);
        TextView textViewHeight = (TextView)findViewById(R.id.textViewHeight);
        TextView textViewWeight = (TextView)findViewById(R.id.textViewWeight);
        TextView textViewGlucose = (TextView)findViewById(R.id.textViewGlucose);
        TextView textViewCholesterol = (TextView)findViewById(R.id.textViewCholesterol);
        TextView textViewPulse = (TextView)findViewById(R.id.textViewPulse);
        TextView textViewBloodPressure = (TextView)findViewById(R.id.textViewBloodPresure);



        textViewName.setText(newPatient.getFirstName() + " " + newPatient.getLastName());
        textViewDOB.setText(newPatient.getMonth() + "/" + newPatient.getDay() + "/" + newPatient.getYear());
        textViewHeight.setText(Integer.toString(newPatient.getHeight()) + " in.");
        textViewWeight.setText(Integer.toString(newPatient.getWeight()) + " lbs.");
        textViewGlucose.setText(Integer.toString(newPatient.getGlucose()) + " mg/dL");
        textViewCholesterol.setText(Integer.toString(newPatient.getCholesterol()) + " mg/dL");
        textViewPulse.setText("(N/A)");
        textViewBloodPressure.setText(Integer.toString(newPatient.getBloodPressureOver()) + "/" + Integer.toString(newPatient.getBloodPressureUnder()));


    }
}
