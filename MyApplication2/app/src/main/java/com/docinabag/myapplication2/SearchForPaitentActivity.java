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

    private TextView pubpid;
    private TextView date;
    private TextView fname;
    private TextView dob;
    private TextView sex;
    private TextView status;
    private TextView email;
    private TextView street;
    private TextView postal_code;
    private TextView city;
    private TextView state;
    private TextView country_code;
    private TextView phone_contact;
    private TextView phone_cell;
    private TextView ss;

    private String uid;

    private View mInitialView;
    private ContactInfo record;
    private View mRecordView;
    private boolean mVisible;
    private Button submitButton;


    //public patientContainer newPatient;

    public ContactInfo newPatient;

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
        mInitialView = findViewById(R.id.initialView);
        mRecordView = findViewById(R.id.recordView);
        mRecordView.setVisibility(View.GONE);
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
                        newPatient = null;
                        new HttpRequestTask().execute();

                    }
                }
        );
    }

    private void showRecord () {
        mRecordView.setVisibility(View.VISIBLE);
        mInitialView.setVisibility(View.GONE);
         //pubpid = (TextView)findViewById(R.id.
         //date = (TextView)findViewById(R.id.
         fname = (TextView)findViewById(R.id.textView_firstName);
         dob = (TextView)findViewById(R.id.textViewDOB);
         sex = (TextView)findViewById(R.id.textViewGender);
         status = (TextView)findViewById(R.id.textViewStatus);
         email = (TextView)findViewById(R.id.textViewEmail);
//         street = (TextView)findViewById(R.id.
//         postal_code = (TextView)findViewById(R.id.
//         city = (TextView)findViewById(R.id.
//         state = (TextView)findViewById(R.id.
//         country_code = (TextView)findViewById(R.id.
//         phone_contact = (TextView)findViewById(R.id.
//         phone_cell = (TextView)findViewById(R.id.
//         ss = (TextView)findViewById(R.id.
        fname.setText(newPatient.getFname() + " " + newPatient.getLname());
        dob.setText(newPatient.getDob());
        sex.setText(newPatient.getSex());
        status.setText(newPatient.getStatus());
        email.setText(newPatient.getEmail());

    }

    private class HttpRequestTask extends AsyncTask<Void, Void, ContactInfo> {
        @Override
        protected ContactInfo doInBackground(Void... params) {
            try {
                final String url = ("http://52.36.163.49:8000/api/patient-data/" + uid +".json/");
                RestTemplate restTemplate = new RestTemplate();
                restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
                //newPatient = restTemplate.getForObject(url, patientContainer.class);
                newPatient = restTemplate.getForObject(url, ContactInfo.class);

                return newPatient;
            } catch (Exception e) {
                Log.e("Spring Problem", e.getMessage(), e);
            }

            return null;
        }

        @Override
        protected void onPostExecute(ContactInfo newPatient) {
            showRecord();
            try {
                GMailSender sender = new GMailSender("noreply@remotehcs.com", "seniorDesign15");
                sender.sendMail("This is Subject",
                        "This is Body",
                        "noreply@remotehcs.com",
                        "jht3394@yahoo.com");
            } catch (Exception e) {
                Log.e("SendMail", e.getMessage(), e);
            }
            buttonButtonListener();
        }

        public void buttonButtonListener() {
            button.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            try {
                                GMailSender sender = new GMailSender("noreply@remotehcs.com", "seniordesign15");
                                sender.sendMail("This is Subject",
                                        "This is Body",
                                        "noreply@remotehcs.com",
                                        "jht3394@yahoo.com");
                            } catch (Exception e) {
                                Log.e("SendMail", e.getMessage(), e);
                            }

                        }
                    }
            );
        }

    }

}