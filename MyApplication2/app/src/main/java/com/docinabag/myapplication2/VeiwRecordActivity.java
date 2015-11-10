package com.docinabag.myapplication2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class VeiwRecordActivity extends AppCompatActivity {

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
        if (newPatient.getHeight() == null) {
        } else {
            textViewHeight.setText(Integer.toString(newPatient.getHeight()) + " in.");
        }
        if (newPatient.getWeight() == null) {
        } else {
            textViewWeight.setText(Integer.toString(newPatient.getWeight()) + " lbs.");
        }
        if (newPatient.getGlucose() == null) {
        } else {
            textViewGlucose.setText(Integer.toString(newPatient.getGlucose()) + " mg/dL");
        }
        if (newPatient.getCholesterol() == null) {
        } else {
            textViewCholesterol.setText(Integer.toString(newPatient.getCholesterol()) + " mg/dL");
        }
        if (newPatient.getBloodPressureOver() == null || newPatient.getBloodPressureUnder() == null) {
        } else {
            textViewBloodPressure.setText(Integer.toString(newPatient.getBloodPressureOver()) + "/" + Integer.toString(newPatient.getBloodPressureUnder()));
        }
        textViewPulse.setText("(N/A)");



    }
}
