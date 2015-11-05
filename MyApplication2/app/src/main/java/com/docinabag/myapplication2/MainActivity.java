package com.docinabag.myapplication2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static Button create_sbm;

    private static Button search_sbm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createButtonListener();
        searchButtonListener();
    }

    public void createButtonListener() {
        create_sbm = (Button)findViewById(R.id.button);
        create_sbm.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent("com.docinabag.myapplication2.CreateNewPatientActivity");
                        startActivity(intent);
                    }
                }
        );
    }

    public void searchButtonListener() {
        search_sbm = (Button)findViewById(R.id.button2);
        search_sbm.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent("com.docinabag.myapplication2.SearchForPaitentActivity");
                        startActivity(intent);
                    }
                }
        );
    }
}
