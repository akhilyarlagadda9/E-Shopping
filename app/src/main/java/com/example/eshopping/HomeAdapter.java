package com.example.eshopping;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;




import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.awt.font.TextAttribute;
import java.util.ArrayList;
import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {
    private Context mContext;

    private List<FruitsModel> fruitsList;
    public HomeAdapter(Context mContext, List<FruitsModel> fruits) {
        this.mContext = mContext;

        this.fruitsList = fruits;

    }

    @NonNull
    @Override
    public HomeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home, parent, false);

        return new HomeAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeAdapter.ViewHolder holder, int position) {
        FruitsModel fruitsModel= fruitsList.get(position);

        holder.tvName.setText(fruitsModel.getTitle());
        holder.iv.setImageResource(fruitsModel.getIcon());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, CartActivity.class);
                intent.putExtra("name", fruitsModel.getTitle());
                mContext.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return fruitsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        ImageView iv;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            iv = itemView.findViewById(R.id.iv);
        }
    }
}
