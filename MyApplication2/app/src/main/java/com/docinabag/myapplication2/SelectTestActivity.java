package com.docinabag.myapplication2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SelectTestActivity extends AppCompatActivity {

    private static Button glucoseTestButton_sbm;

    private static Button bloodPressureTestButton_sbm;

    private static Button cholesterolTestButton_sbm;

    private static Button submitButton_sbm;

    private static PatientRecord newPatient;

    public  final static String SER_KEY = "com.docinabag.myapplication2.ser";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_test);

        newPatient = (PatientRecord)getIntent().getSerializableExtra(CreateNewPatientActivity.SER_KEY);

        glucoseTestButtonListener();
        bloodPressureTestButtonListener();
        cholesterolTestButtonListener();
        submitTestButtonListener();


    }

    public void glucoseTestButtonListener() {
        glucoseTestButton_sbm = (Button)findViewById(R.id.glucoseTestButton);
        glucoseTestButton_sbm.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent("com.docinabag.myapplication2.GlucoseTestActivity");
                        Bundle bundle = new Bundle();
                        bundle.putSerializable(SER_KEY, newPatient);
                        intent.putExtras(bundle);
                        startActivity(intent);
                    }
                }
        );
    }

    public void bloodPressureTestButtonListener() {
        bloodPressureTestButton_sbm = (Button)findViewById(R.id.bloodPressureTestButton);
        bloodPressureTestButton_sbm.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent("com.docinabag.myapplication2.BloodPressureTestActivity");
                        Bundle bundle = new Bundle();
                        bundle.putSerializable(SER_KEY, newPatient);
                        intent.putExtras(bundle);
                        startActivity(intent);
                    }
                }
        );
    }

    public void cholesterolTestButtonListener() {
        cholesterolTestButton_sbm = (Button)findViewById(R.id.cholesterolTestButton);
        cholesterolTestButton_sbm.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent("com.docinabag.myapplication2.CholesterolTestActivity");
                        Bundle bundle = new Bundle();
                        bundle.putSerializable(SER_KEY, newPatient);
                        intent.putExtras(bundle);
                        startActivity(intent);
                    }
                }
        );
    }

    public void submitTestButtonListener() {
        submitButton_sbm = (Button)findViewById(R.id.submitButton);
        submitButton_sbm.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent("com.docinabag.myapplication2.PatientRecordActivity");
                        Bundle bundle = new Bundle();
                        bundle.putSerializable(SER_KEY, newPatient);
                        intent.putExtras(bundle);
                        startActivity(intent);
                    }
                }
        );
    }
}
