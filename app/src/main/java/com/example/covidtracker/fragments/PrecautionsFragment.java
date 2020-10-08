package com.example.covidtracker.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ethanhua.skeleton.Skeleton;
import com.ethanhua.skeleton.SkeletonAdapter;
import com.ethanhua.skeleton.SkeletonScreen;
import com.example.covidtracker.R;
import com.example.covidtracker.adapter.PrecautionsAdapter;
import com.example.covidtracker.model.Precautions;


import java.util.ArrayList;


public class PrecautionsFragment extends Fragment {

    RecyclerView precautionsRecyclerView;
    ArrayList<Precautions> precautions = new ArrayList<>();
    private RecyclerView.SmoothScroller smoothScroller;
    private static final float MILLISECONDS_PER_INCH = 40f;
    private SkeletonScreen skeletonScreen;
    private Context context;

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

        precautions.add(new Precautions("Wash Hands", "It is always a good precautionary measure to wash hands regularly while at home", R.drawable.ic_wash_your_hands));
        precautions.add(new Precautions("Cough or Sneeze", "While coughing or sneezing, cover nose and mouth by any means", R.drawable.ic_cough));
        precautions.add(new Precautions("Stay Home", "Staying at home is the best possible way to avoid contact with COVID", R.drawable.ic_stay_at_home));
        precautions.add(new Precautions("Wear Mask", "Always wear a mask while going outside as it is a good block of entry for the virus", R.drawable.ic_mask));
        precautions.add(new Precautions("Sanitize", "While outside, it is best to sanitize often before or after touching any object ", R.drawable.ic_sanitize));
        precautions.add(new Precautions("Avoid Touching Face ", "One must avoid touching their eyes, nose or mouth before washing their hands", R.drawable.ic_dont_touch_face));
        precautions.add(new Precautions("Social Distancing", "While outside, it is always best to maintain a 2m distance from anyone", R.drawable.ic_social_distance));

        precautionsRecyclerView = view.findViewById(R.id.precautions_rv);


        LinearLayoutManager precautionsLinearLayoutManager = new LinearLayoutManager(getContext());
        precautionsLinearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        precautionsRecyclerView.setLayoutManager(precautionsLinearLayoutManager);

        SkeletonAdapter skeletonAdapter = new SkeletonAdapter();
        skeletonScreen = Skeleton.bind(precautionsRecyclerView)
                .adapter(skeletonAdapter)
                .shimmer(true)
                .angle(20)
                .duration(1200)
                .load(R.layout.skeleton_item_precautions)
                .count(10)
                .show();

        Runnable mRunnable;
        Handler mHandler = new Handler();

        mRunnable = new Runnable() {

            @Override
            public void run() {
                precautionsRecyclerView.setAdapter(new PrecautionsAdapter(precautions));
                ViewCompat.setNestedScrollingEnabled(precautionsRecyclerView, false);

                precautionsRecyclerView.getAdapter().notifyDataSetChanged();
                precautionsRecyclerView.scheduleLayoutAnimation();
            }
        };

        mHandler.postDelayed(mRunnable, 1300);

    }
}