package com.example.eshopping;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    private TextView  bt_submit,signup_free;
    EditText ed_mobile_number,ed_repassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        bt_submit = (TextView) findViewById(R.id.bt_submit);
        signup_free = (TextView) findViewById(R.id.signup_free);
        ed_mobile_number =  findViewById(R.id.ed_mobile_number);
        ed_repassword =  findViewById(R.id.ed_repassword);
        bt_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String loginMobileNumber = ed_mobile_number.getText().toString();
                String password = ed_repassword.getText().toString();

                if (loginMobileNumber.length() == 0) {
                    Toast.makeText(getApplicationContext(),"Please enter mobile number",Toast.LENGTH_LONG).show();

                } else if (password.length() == 0) {

                    Toast.makeText(getApplicationContext(),"Please enter password",Toast.LENGTH_LONG).show();

                } else {
                    Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                    startActivity(intent);
                }



            }
        });

        signup_free.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SignUpActivity.class);
                startActivity(intent);
            }
        });

    }


}