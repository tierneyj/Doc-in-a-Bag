package com.docinabag.myapplication2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;


public class SearchForPaitentActivity extends AppCompatActivity {

    private static Button search_sbm;

    private EditText uid_input;

    private String uid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_for_paitent);
        searchButtonListener();
    }

    public void searchButtonListener() {
        uid_input = (EditText)findViewById(R.id.uidTextField);
        search_sbm = (Button)findViewById(R.id.searchButton);
        search_sbm.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        uid = uid_input.getText().toString();
                        new HttpRequestTask().execute();

                    }
                }
        );
    }

    private class HttpRequestTask extends AsyncTask<Void, Void, patientContainer> {
        @Override
        protected patientContainer doInBackground(Void... params) {
            try {
                final String url = ("http://52.32.30.227:5000/openemr/api/v0.0/patients/" + uid);
                RestTemplate restTemplate = new RestTemplate();
                restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
                patientContainer newPatient = restTemplate.getForObject(url, patientContainer.class);
                return newPatient;
            } catch (Exception e) {
                Log.e("MainActivity", e.getMessage(), e);
            }

            return null;
        }

        @Override
        protected void onPostExecute(patientContainer newPatient) {
            TextView greetingIdText = (TextView) findViewById(R.id.textView);
            TextView greetingContentText = (TextView) findViewById(R.id.textView2);
            greetingIdText.setText(newPatient.getPatient().getId());
            greetingContentText.setText(newPatient.getPatient().getFirstName());
            Button button = (Button)findViewById(R.id.button3);
            button.setText(newPatient.getPatient().getFirstName() + " " + newPatient.getPatient().getLastName());
        }

    }

}