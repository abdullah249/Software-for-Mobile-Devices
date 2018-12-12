package com.example.abdullah.assignment7;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class Explorer extends Fragment {
    RecyclerView recyclerView;
    ArrayList<Model> arrayList;
    Adapter adapter;
    RecyclerView.LayoutManager layoutManager;

    String[] names={"Outfitters","Junaid Jamshaid","Denizen"};
    String[] address={"Karim Block Lahore","Wapda Town Lahore","Emporium Mall Lahore"};
    int[] Images={R.drawable.outfitter,R.drawable.junaid_jamshaid,R.drawable.denizen};



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_explorer, container, false);
        recyclerView=(RecyclerView) v.findViewById(R.id.recyclerView);
        arrayList=new ArrayList<>();

        for (int i=0;i<3;i++){
            arrayList.add(new Model(Images[i],names[i],address[i]));
        }

        layoutManager = new GridLayoutManager(v.getContext(),3);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new Adapter(arrayList,v.getContext());
        recyclerView.setAdapter(adapter);

        return v;
    }


}
