package com.example.eshopping;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.eshopping.utils.Validaters;

public class SignUpActivity extends AppCompatActivity {
    TextView createAcc;
    EditText ed_name, ed_mobile, ed_email, ed_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        createAcc = findViewById(R.id.bt_createaccount);
        ed_name = findViewById(R.id.ed_name);
        ed_mobile = findViewById(R.id.ed_mobile);
        ed_email = findViewById(R.id.ed_email);
        ed_password = findViewById(R.id.ed_password);
        createAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String name = ed_name.getText().toString();
                String mobileNumber = ed_mobile.getText().toString();
                String email = ed_email.getText().toString();
                String password = ed_password.getText().toString();

                if (name.length() == 0) {
                    Toast.makeText(getApplicationContext(), "Please enter name", Toast.LENGTH_LONG).show();

                } else if (mobileNumber.length() == 0) {
                    Toast.makeText(getApplicationContext(), "Please enter mobile number", Toast.LENGTH_LONG).show();

                } else if (email.length() == 0) {
                    Toast.makeText(getApplicationContext(), "Please enter email id", Toast.LENGTH_LONG).show();

                } else if (Validaters.emailValidate(((EditText) findViewById(R.id.ed_email)).getText().toString().trim()) == false) {

                    Toast.makeText(getApplicationContext(), "Invalid email address", Toast.LENGTH_LONG).show();

                } else if (password.length() == 0) {
                    Toast.makeText(getApplicationContext(), "Please enter password", Toast.LENGTH_LONG).show();

                } else {
                    Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                    startActivity(intent);
                }


            }
        });
    }
}


