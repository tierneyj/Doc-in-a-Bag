package com.docinabag.myapplication2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SelectTestActivity extends AppCompatActivity {

    private static Button glucoseTestButton_sbm;

    private static Button bloodPressureTestButton_sbm;

    private static Button cholesterolTestButton_sbm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_test);
        glucoseTestButtonListener();
        bloodPressureTestButtonListener();
        cholesterolTestButtonListener();
    }

    public void glucoseTestButtonListener() {
        glucoseTestButton_sbm = (Button)findViewById(R.id.glucoseTestButton);
        glucoseTestButton_sbm.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent("com.docinabag.myapplication2.GlucoseTestActivity");
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
                        startActivity(intent);
                    }
                }
        );
    }
}
