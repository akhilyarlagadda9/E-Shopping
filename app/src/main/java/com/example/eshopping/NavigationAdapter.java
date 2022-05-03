package com.example.eshopping;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.eshopping.dtos.NavDto;
import com.example.eshopping.interfaces.NavItemInterface;

import java.util.ArrayList;

public class NavigationAdapter  extends RecyclerView.Adapter<NavigationAdapter.MyViewHolder> {

    NavItemInterface navItemInterface;
    private Context mContext;
    private ArrayList<NavDto> list = new ArrayList<>();

    public NavigationAdapter(Context mContext, ArrayList<NavDto> list, NavItemInterface navItemInterface) {
        this.mContext = mContext;
        this.list = list;
        this.navItemInterface = navItemInterface;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_nav, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        NavDto dto = list.get(position);

        final String title = dto.getTitle();
        int img = dto.getImg();
        holder.nav_title_tv.setText(title);
        holder.nav_img.setBackgroundResource(img);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navItemInterface.navItemCallBack(title);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView nav_title_tv;
        ImageView nav_img;

        public MyViewHolder(View itemView) {
            super(itemView);

            nav_title_tv = itemView.findViewById(R.id.nav_title_tv);
            nav_img = itemView.findViewById(R.id.nav_img);

        }
    }
}
