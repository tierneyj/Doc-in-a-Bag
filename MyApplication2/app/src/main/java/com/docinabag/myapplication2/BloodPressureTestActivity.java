package com.docinabag.myapplication2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class BloodPressureTestActivity extends AppCompatActivity {

    private static Button bloodPressureEnterButton_smb;

    private PatientRecord newPatient;

    private EditText bloodPressureOver_input;

    private EditText bloodPressureUnder_input;

    public  final static String SER_KEY = "com.docinabag.myapplication2.ser";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blood_pressure_test);
        newPatient = (PatientRecord)getIntent().getSerializableExtra(CreateNewPatientActivity.SER_KEY);
        bloodPressureTestButtonListener();
    }

    public void bloodPressureTestButtonListener() {
        bloodPressureOver_input = (EditText)findViewById(R.id.overTextField);
        bloodPressureUnder_input = (EditText)findViewById(R.id.underTextField);
        bloodPressureEnterButton_smb = (Button)findViewById(R.id.bloodPressureEnterButton);
        bloodPressureEnterButton_smb.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (bloodPressureOver_input.getText().toString().matches("")) {
                        } else
                        {
                            newPatient.setBloodPressureOver(Integer.parseInt(bloodPressureOver_input.getText().toString()));
                        }
                        if (bloodPressureUnder_input.getText().toString().matches("")) {

                        } else {
                            newPatient.setBloodPressureUnder(Integer.parseInt(bloodPressureUnder_input.getText().toString()));
                        }
                        Intent intent = new Intent("com.docinabag.myapplication2.SelectTestActivity");
                        Bundle bundle = new Bundle();
                        bundle.putSerializable(SER_KEY, newPatient);
                        intent.putExtras(bundle);
                        startActivity(intent);
                    }
                }
        );
    }
}
