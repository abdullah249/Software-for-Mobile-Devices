package com.example.abdullah.assignment7;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    ArrayList<Model> arrayList;
    Context context;

    public Adapter(ArrayList<Model> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_view, parent, false);
        SheikhViewHolder sheikhViewHolder = new SheikhViewHolder(view, arrayList, context);
        return sheikhViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        final Model model = arrayList.get(position);
        SheikhViewHolder sheikhViewHolder = (SheikhViewHolder) holder;
        sheikhViewHolder.imageView.setImageResource(model.getImage());
        sheikhViewHolder.name.setText(model.getName());
        sheikhViewHolder.address.setText(model.getAdress());
        sheikhViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,model.getName()+" brand Clicked",Toast.LENGTH_LONG).show();
            }
        });
    }

    public void setUpdatedData(ArrayList<Model> arrayList) {
        this.arrayList = arrayList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class SheikhViewHolder extends RecyclerView.ViewHolder {
        AppCompatImageView imageView;
        AppCompatTextView name,address;
        public SheikhViewHolder(View itemView, ArrayList<Model> arrayList, Context context) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image);
            name = itemView.findViewById(R.id.name);
            address = itemView.findViewById(R.id.address);
        }
    }
}
