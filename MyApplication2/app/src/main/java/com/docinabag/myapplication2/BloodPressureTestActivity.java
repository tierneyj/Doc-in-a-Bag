package com.docinabag.myapplication2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BloodPressureTestActivity extends AppCompatActivity {

    private static Button bloodPressureEnterButton_smb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blood_pressure_test);
        bloodPressureTestButtonListener();
    }

    public void bloodPressureTestButtonListener() {
        bloodPressureEnterButton_smb = (Button)findViewById(R.id.bloodPressureEnterButton);
        bloodPressureEnterButton_smb.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent("com.docinabag.myapplication2.SelectTestActivity");
                        startActivity(intent);
                    }
                }
        );
    }
}
