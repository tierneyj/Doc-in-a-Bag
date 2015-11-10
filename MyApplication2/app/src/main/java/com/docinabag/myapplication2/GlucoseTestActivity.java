package com.docinabag.myapplication2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class GlucoseTestActivity extends AppCompatActivity {

    private static Button enter_sbm;

    private PatientRecord newPatient;

    private EditText glucose_input;

    public  final static String SER_KEY = "com.docinabag.myapplication2.ser";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glucose_test);
        newPatient = (PatientRecord)getIntent().getSerializableExtra(CreateNewPatientActivity.SER_KEY);
        enterButtonListener();
    }

    public void enterButtonListener() {
        glucose_input = (EditText)findViewById(R.id.glucoseTextField);
        enter_sbm = (Button)findViewById(R.id.enterButton);
        enter_sbm.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        newPatient.setGlucose(Integer.parseInt(glucose_input.getText().toString()));
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
