package com.example.kmy07.senddatatodjango;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;

import java.util.ArrayList;

public class RegistrationScreen extends AppCompatActivity {

    private String userName,userNumber,userAge;
    private EditText name,number,age;
    private Button registerButton;
    private ArrayList<String> userDetails = new ArrayList<String>();
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_screen);

        name = (EditText) findViewById(R.id.userName);
        number = (EditText) findViewById(R.id.userNumber);
        age = (EditText) findViewById(R.id.userAge);
        registerButton = (Button) findViewById(R.id.registerButton);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userDetails.clear();

                userAge = age.getText().toString();
                userName = name.getText().toString();
                userNumber = number.getText().toString();

                InputValidator validator = new InputValidator(userName,userNumber,userAge);
                String inputStatus = validator.validateInput();

                if(!inputStatus.isEmpty()){
                    Toast.makeText(RegistrationScreen.this, inputStatus, Toast.LENGTH_SHORT).show();
                }
                else {
                    userDetails.add(userName);
                    userDetails.add(userNumber);
                    userDetails.add(userAge);
                    Toast.makeText(RegistrationScreen.this, "Registeration on progress...", Toast.LENGTH_SHORT).show();
                    DataTransmitter sender = new DataTransmitter(userDetails,getApplicationContext());
                    sender.newServer("http://yourIpHere/register_user/");
                    try {
                        boolean isSuccess = sender.sendData();
                        if(isSuccess){
                            Toast.makeText(RegistrationScreen.this, "Details Registered Successfully!", Toast.LENGTH_SHORT).show();
                            age.setText("");
                            name.setText("");
                            number.setText("");
                            age.clearFocus();
                            name.requestFocus();
                            name.setCursorVisible(true);
                        }
                        else{
                            Toast.makeText(RegistrationScreen.this, "Details Registered UnSuccessfull!", Toast.LENGTH_SHORT).show();
                        }
                    } catch (JSONException e) {

                    }
                }
            }
        });




    }
}
