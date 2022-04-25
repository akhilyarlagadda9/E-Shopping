package com.example.eshopping;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    HomeAdapter homeAdapter;
    ArrayList<String> arraylist1= new ArrayList<String>();
    Context mContext;
    int[] icons = {R.drawable.ic_apple, R.drawable.ic_banana, R.drawable.ic_orange, R.drawable.ic_mango, R.drawable.ic_lemon};
    String[] names = {"Apple", "Banana", "Orange", "Mango","Lemon"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mContext=this;

        List<FruitsModel> fruitsList = new ArrayList<>();
        for (int i = 0; i < icons.length; i++) {
            FruitsModel menu = new FruitsModel();
            menu.setIcon(icons[i]);
            menu.setTitle(names[i]);
            fruitsList.add(menu);
        }

        recyclerView= findViewById(R.id.rv);
        homeAdapter = new HomeAdapter(mContext,fruitsList);
        LinearLayoutManager manager = new LinearLayoutManager(HomeActivity.this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(homeAdapter);
    }
}
