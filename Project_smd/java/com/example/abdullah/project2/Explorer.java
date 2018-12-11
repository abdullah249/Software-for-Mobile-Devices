package com.example.abdullah.project2;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;


public class Explorer extends Fragment {
    RecyclerView recyclerView;
    ArrayList<Model> arrayList;
    // Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    private RequestQueue mQueue;
    DatabaseReference databaseReference;
    FirebaseRecyclerOptions<Model> recyclerOptions;
    FirebaseRecyclerAdapter<Model, Adapter.SheikhViewHolder> recyclerAdapter;


    private static final int PERMISSIONS_REQUEST_INTERNET = 100;
    // String[] names={"Outfitters","Junaid Jamshaid","Denizen"};
    //String[] address={"Karim Block Lahore","Wapda Town Lahore","Emporium Mall Lahore"};
    //int[] Images={R.drawable.outfitter,R.drawable.junaid_jamshaid,R.drawable.denizen};


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_explorer, container, false);

        recyclerView = (RecyclerView) v.findViewById(R.id.recyclerView);
        databaseReference = FirebaseDatabase.getInstance().getReference().child("Brands");
        recyclerOptions = new FirebaseRecyclerOptions.Builder<Model>().setQuery(databaseReference, Model.class).build();

        recyclerAdapter = new FirebaseRecyclerAdapter<Model, Adapter.SheikhViewHolder>(recyclerOptions) {
            @Override
            protected void onBindViewHolder(@NonNull Adapter.SheikhViewHolder holder, int position, @NonNull Model model) {
                Picasso.get().load(model.getImage()).into(holder.imageView);
                holder.name.setText(model.getName());
                holder.address.setText(model.getAdress());


            }

            @NonNull
            @Override
            public Adapter.SheikhViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_view, parent, false);
                return new Adapter.SheikhViewHolder(view);
            }
        };


        layoutManager = new GridLayoutManager(v.getContext(), 3);
        recyclerView.setLayoutManager(layoutManager);
        recyclerAdapter.startListening();
        recyclerView.setAdapter(recyclerAdapter);

        return v;
    }


    @Override
    public void onStart() {
        super.onStart();
        if (recyclerAdapter != null) {
            recyclerAdapter.startListening();
        }


    }

    @Override
    public void onStop() {
        super.onStop();
        recyclerAdapter.stopListening();
    }
}
