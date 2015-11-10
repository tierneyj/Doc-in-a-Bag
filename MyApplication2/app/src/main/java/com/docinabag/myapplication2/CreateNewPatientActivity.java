package com.docinabag.myapplication2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CreateNewPatientActivity extends AppCompatActivity {

    private static Button create_sbm;

    public  final static String SER_KEY = "com.docinabag.myapplication2.ser";

    private EditText first_input;
    private EditText last_input;
    private EditText month_input;
    private EditText day_input;
    private EditText year_input;
    private EditText height_input;
    private EditText weight_input;

    private PatientRecord newPatient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_patient);
        newPatient = new PatientRecord();
        createButtonListener();
    }

    public void createButtonListener() {
        first_input = (EditText)findViewById(R.id.firstNameTextField);
        last_input  = (EditText)findViewById(R.id.lastNameTextField);
        month_input = (EditText)findViewById(R.id.monthTextField);
        day_input = (EditText)findViewById(R.id.dayTextField);
        year_input = (EditText)findViewById(R.id.yeartextFeild);
        height_input = (EditText)findViewById(R.id.heightTextField);
        weight_input = (EditText)findViewById(R.id.weightTextField);

        create_sbm = (Button)findViewById(R.id.createButton);
        create_sbm.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //get user input from text field
                        newPatient.setFirstName(first_input.getText().toString());
                        newPatient.setLastName(last_input.getText().toString());
                        newPatient.setMonth(month_input.getText().toString());
                        newPatient.setDay(day_input.getText().toString());
                        newPatient.setYear(year_input.getText().toString());
                        newPatient.setHeight(Integer.parseInt(height_input.getText().toString()));
                        newPatient.setWeight(Integer.parseInt(weight_input.getText().toString()));

                        //create new intents intent is next screen intent2 is where data is going
                        Intent intent = new Intent("com.docinabag.myapplication2.SelectTestActivity");
                        Bundle bundle = new Bundle();
                        bundle.putSerializable(SER_KEY, newPatient);
                        intent.putExtras(bundle);


                        //switch display to the next activity
                        startActivity(intent);
                    }
                }
        );
    }
}
