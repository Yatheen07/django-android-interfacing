package com.example.kmy07.senddatatodjango;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;

import java.util.ArrayList;

public class DataTransmitter {

    private ArrayList<String> user = new ArrayList<String>();
    private String data_to_send;
    Context context;
    private String serverAddress;
    private boolean status = true;

    public DataTransmitter(ArrayList<String> userDetails,Context context){
        this.user = userDetails;
        this.context = context;
        this.processInput();
    }

    public void newServer(String url){
        this.serverAddress = url;
    }

    private void processInput() {
        StringBuffer result = new StringBuffer();
        for(String s : user){
            result.append(s+"-");
        }
        data_to_send = result.toString().replace("\\s","");
    }

    public boolean sendData() throws JSONException {

        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(context);
        String url = serverAddress + data_to_send+"/";


        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                //Toast.makeText(RegistrationScreen.this, "Not yet!\n" +error.toString(), Toast.LENGTH_SHORT).show();
                status = false;
            }
        });


        queue.add(stringRequest);
        return status;
    }

}
