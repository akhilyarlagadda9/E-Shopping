package com.example.eshopping;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class OrderDetailsActivity extends AppCompatActivity {

    ImageView imageName;
    TextView tvQuantity, tvName,tvReOrder;
    String name;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);
        imageName = findViewById(R.id.imageName);
        tvQuantity = findViewById(R.id.tvQuantity);
        tvName = findViewById(R.id.tvName);
        tvReOrder = findViewById(R.id.tvReOrder);
        name = getIntent().getStringExtra("name");
        tvReOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(intent);
                finishAffinity();
            }
        });

        tvName.setText(name);

        if (name.equalsIgnoreCase("Apple")) {
            imageName.setImageResource(R.drawable.ic_apple);
        } else if (name.equalsIgnoreCase("Banana")) {
            imageName.setImageResource(R.drawable.ic_banana);
        } else if (name.equalsIgnoreCase("Orange")) {
            imageName.setImageResource(R.drawable.ic_orange);

        } else if (name.equalsIgnoreCase("Mango")) {
            imageName.setImageResource(R.drawable.ic_mango);

        } else if (name.equalsIgnoreCase("Lemon")) {
            imageName.setImageResource(R.drawable.ic_lemon);

        }
    }
}
