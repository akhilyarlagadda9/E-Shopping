package com.example.eshopping;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class CartActivity extends AppCompatActivity {
    String name;
    ImageView iv;
    TextView tvName,tvPlaceOrder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        iv = findViewById(R.id.iv);
        tvName = findViewById(R.id.tvName);
        tvPlaceOrder = findViewById(R.id.tvPlaceOrder);
        name = getIntent().getStringExtra("name");
        tvName.setText(name);

        if (name.equalsIgnoreCase("Apple")) {
            iv.setImageResource(R.drawable.ic_apple);
        } else if (name.equalsIgnoreCase("Banana")) {
            iv.setImageResource(R.drawable.ic_banana);
        } else if (name.equalsIgnoreCase("Orange")) {
            iv.setImageResource(R.drawable.ic_orange);

        } else if (name.equalsIgnoreCase("Mango")) {
            iv.setImageResource(R.drawable.ic_mango);

        } else if (name.equalsIgnoreCase("Lemon")) {
            iv.setImageResource(R.drawable.ic_lemon);

        }
        tvPlaceOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Order Placed",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(),HomeActivity.class);
               startActivity(intent);
               finish();
            }
        });

    }
}
