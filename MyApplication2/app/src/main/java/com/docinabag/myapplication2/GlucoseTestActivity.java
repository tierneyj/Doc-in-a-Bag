package com.docinabag.myapplication2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GlucoseTestActivity extends AppCompatActivity {

    private static Button enter_sbm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glucose_test);
        enterButtonListener();
    }

    public void enterButtonListener() {
        enter_sbm = (Button)findViewById(R.id.enterButton);
        enter_sbm.setOnClickListener(
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
