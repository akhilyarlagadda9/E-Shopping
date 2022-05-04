package com.example.eshopping;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.eshopping.dtos.NavDto;
import com.example.eshopping.interfaces.NavItemInterface;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity implements NavItemInterface, View.OnClickListener {
    RecyclerView recyclerView, nav_recycler_view;
    HomeAdapter homeAdapter;
    ImageView imMenu;
    ArrayList<String> arraylist1 = new ArrayList<String>();
    Context mContext;
    int[] icons = {R.drawable.ic_apple, R.drawable.ic_banana, R.drawable.ic_orange, R.drawable.ic_mango, R.drawable.ic_lemon};
    String[] names = {"Apple", "Banana", "Orange", "Mango", "Lemon"};

    private DrawerLayout mDrawerLayout;
    private ArrayList<NavDto> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mContext = this;


        List<FruitsModel> fruitsList = new ArrayList<>();
        for (int i = 0; i < icons.length; i++) {
            FruitsModel menu = new FruitsModel();
            menu.setIcon(icons[i]);
            menu.setTitle(names[i]);
            fruitsList.add(menu);
        }

        recyclerView = findViewById(R.id.rv);
        nav_recycler_view = findViewById(R.id.nav_recycler_view);
        imMenu = findViewById(R.id.imMenu);
        imMenu.setOnClickListener(this);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        homeAdapter = new HomeAdapter(mContext, fruitsList);
        LinearLayoutManager manager = new LinearLayoutManager(HomeActivity.this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(homeAdapter);
        setNavigationAdapter();
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {


            case R.id.imMenu:
                if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
                    mDrawerLayout.closeDrawer(GravityCompat.START);
                } else {
                    mDrawerLayout.openDrawer(GravityCompat.START);
                }
                break;
        }

    }


    private void setNavigationAdapter() {
        NavDto dto1 = new NavDto(getResources().getString(R.string.home), R.drawable.androidlogo);
        list.add(dto1);

        NavDto dto2 = new NavDto(getResources().getString(R.string.about), R.drawable.androidlogo);
        list.add(dto2);
        /*NavDto dto3 = new NavDto(getResources().getString(R.string.users), R.drawable.androidlogo);
        list.add(dto3);*/

        NavDto dto3 = new NavDto(getResources().getString(R.string.logout), R.drawable.androidlogo);
        list.add(dto3);

        NavigationAdapter mAdapter = new NavigationAdapter(mContext, list, this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        nav_recycler_view.setLayoutManager(mLayoutManager);
        nav_recycler_view.setItemAnimator(new DefaultItemAnimator());
        nav_recycler_view.setAdapter(mAdapter);
    }

    @Override
    public void navItemCallBack(String title) {
        if (title.equalsIgnoreCase(getResources().getString(R.string.home))) {
            Intent intent = new Intent(this, HomeActivity.class);
            startActivity(intent);
            finish();

        } else if (title.equalsIgnoreCase(getResources().getString(R.string.profile))) {
            /*Intent inte = new Intent(this, ProfileActivity.class);
            startActivity(inte);*/
            Toast.makeText(getApplicationContext(), "Under Development", Toast.LENGTH_LONG).show();


        } else if (title.equalsIgnoreCase(getResources().getString(R.string.users))) {
            /*Intent inte = new Intent(this, ListUsersActivity.class);
            startActivity(inte);*/
            Toast.makeText(getApplicationContext(), "Under Development", Toast.LENGTH_LONG).show();


        } else if (title.equalsIgnoreCase(getResources().getString(R.string.about))) {
            Intent intent = new Intent(this, AboutUsActivity.class);
            startActivity(intent);
        } else if (title.equalsIgnoreCase(getResources().getString(R.string.logout))) {

            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
            finishAffinity();

        }

    }
}
