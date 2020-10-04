package com.example.covidtracker;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.covidtracker.adapter.PrecautionsAdapter;
import com.example.covidtracker.model.Precautions;

import java.util.ArrayList;


public class PrecautionsFragment extends Fragment {

    RecyclerView precautionsRecyclerView;
    ArrayList<Precautions> precautions = new ArrayList<>();

    public PrecautionsFragment() {
        // Required empty public constructor
    }


    public static PrecautionsFragment newInstance(String param1, String param2) {
        PrecautionsFragment fragment = new PrecautionsFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        getActivity().setTitle("Precaution");
        return inflater.inflate(R.layout.fragment_precautions, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        precautions.add(new Precautions("Wash Hands","It is always a good precaution to Wash hands regularly at home",R.drawable.ic_wash_your_hands));

        precautionsRecyclerView=view.findViewById(R.id.precautions_rv);
        LinearLayoutManager precautionsLinearLayoutManager = new LinearLayoutManager(getContext());
        precautionsLinearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        precautionsRecyclerView.setLayoutManager(precautionsLinearLayoutManager);
        precautionsRecyclerView.setAdapter(new PrecautionsAdapter(precautions));

    }
}