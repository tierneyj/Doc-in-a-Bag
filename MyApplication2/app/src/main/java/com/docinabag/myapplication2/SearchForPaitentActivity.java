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

    public patientContainer newPatient;

    public Button button;

    public  final static String SER_KEY = "com.docinabag.myapplication2.ser";

    public TextView patientLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_for_paitent);
        button = (Button)findViewById(R.id.button3);
        patientLabel = (TextView)findViewById(R.id.patientFound);
        button.setVisibility(View.GONE);
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
                final String url = ("http://52.34.73.235:5000/openemr/api/v0.0/patients/" + uid);
                RestTemplate restTemplate = new RestTemplate();
                restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
                newPatient = restTemplate.getForObject(url, patientContainer.class);
                return newPatient;
            } catch (Exception e) {
                Log.e("MainActivity", e.getMessage(), e);
            }

            return null;
        }

        @Override
        protected void onPostExecute(patientContainer newPatient) {
            button.setVisibility(View.VISIBLE);
            patientLabel.setText("Patient Found");
            button.setText("Begin Testing For " + newPatient.getPatient().getFirstName() + " " + newPatient.getPatient().getLastName());
            newPatient.getPatient().setMonth((newPatient.getPatient().getDob()).substring(0,2));
            newPatient.getPatient().setDay((newPatient.getPatient().getDob()).substring(3,5));
            newPatient.getPatient().setYear((newPatient.getPatient().getDob()).substring(6,10));
            buttonButtonListener();
        }

        public void buttonButtonListener() {
            button.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent("com.docinabag.myapplication2.SelectTestActivity");
                            Bundle bundle = new Bundle();
                            bundle.putSerializable(SER_KEY, newPatient.getPatient());
                            intent.putExtras(bundle);
                            startActivity(intent);

                        }
                    }
            );
        }

    }

}