package com.example.nipunarora.hackdtu;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.Toolbar;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class ReportSymptoms extends AppCompatActivity {
    RequestQueue queue;
    AutoCompleteTextView actv,actv1,actv2;
    AppCompatButton reportSymptom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_symptoms);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        queue = VolleySingleton.getInstance(getApplicationContext()).getRequestQueue();
        reportSymptom=(AppCompatButton)findViewById(R.id.report);
        String[] check = {"Fever", "Headache", "JointPain", "IntestinalPain", "BreathingProblems", "BackPain"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this, android.R.layout.select_dialog_item, check);
        //Getting the instance of AutoCompleteTextView
         actv = (AutoCompleteTextView) findViewById(R.id.autocompletecontext);
        actv.setThreshold(1);//will start working from first character
        actv.setAdapter(adapter);//setting the adapter data into the AutoCompleteTextView

         actv1 = (AutoCompleteTextView) findViewById(R.id.autocompletecontext1);
        actv1.setThreshold(1);//will start working from first character
        actv1.setAdapter(adapter);//setting the adapter data into the AutoCompleteTextView

         actv2 = (AutoCompleteTextView) findViewById(R.id.autocompletecontext2);
        actv2.setThreshold(1);//will start working from first character
        actv2.setAdapter(adapter);//setting the adapter data into the AutoCompleteTextView
        reportSymptom.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
              sendReportSymptoms();

            }
        });

    }

    public void sendReportSymptoms() {
        StringRequest postSymptoms = new StringRequest(Request.Method.GET,String.format("http://192.168.43.116:8000/postSymptoms?symptom1=%s&symptom2=%s&symptom3=%s",actv.getText().toString(),actv1.getText().toString(),actv2.getText().toString()),
                new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response) {
                        Log.d("Response",response);

                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // error
                        // Log.d("Error.Response","hahah");
                        Log.d("error", error.toString());
                    }
                }
        ) ;
        queue.add(postSymptoms);


    }

}
