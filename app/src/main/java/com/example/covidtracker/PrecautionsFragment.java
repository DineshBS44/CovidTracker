package com.example.covidtracker;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;

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

        precautions.add(new Precautions("Wash Hands", "It is always a good precaution to wash hands regularly at home", R.drawable.ic_wash_your_hands));
        precautions.add(new Precautions("Cough or Sneeze", "While coughing or sneezing, cover nose and mouth by any means", R.drawable.ic_cough));
        precautions.add(new Precautions("Stay Home", "Staying at home is the best possible way to avoid contact with COVID and one must try their best", R.drawable.ic_stay_at_home));
        precautions.add(new Precautions("Wear Mask", "Always wear a mask before going outside as it might provide a well enough cover against the virus", R.drawable.ic_mask));
        precautions.add(new Precautions("Sanitize", "While outside, it is best to sanitize often before or after touching any object ", R.drawable.ic_sanitize));
        precautions.add(new Precautions("Avoid Touching Face ", "One must avoid touching their eyes, nose or mouth before washing their hands", R.drawable.ic_dont_touch_face));
        precautions.add(new Precautions("Social Distancing", "While outside, it is best to maintain a 2m distance from anyone", R.drawable.ic_social_distance));

        precautionsRecyclerView = view.findViewById(R.id.precautions_rv);
        LinearLayoutManager precautionsLinearLayoutManager = new LinearLayoutManager(getContext());
        precautionsLinearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        precautionsRecyclerView.setLayoutManager(precautionsLinearLayoutManager);
        precautionsRecyclerView.setAdapter(new PrecautionsAdapter(precautions));
        ViewCompat.setNestedScrollingEnabled(precautionsRecyclerView, false);

        LayoutAnimationController controller = AnimationUtils.loadLayoutAnimation(precautionsRecyclerView.getContext(), R.anim.layout_animation_fall_down);

        precautionsRecyclerView.setLayoutAnimation(controller);
        precautionsRecyclerView.getAdapter().notifyDataSetChanged();
        precautionsRecyclerView.scheduleLayoutAnimation();

    }
}