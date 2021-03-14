package com.example.climatechange.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.climatechange.R;
import com.google.android.material.card.MaterialCardView;

public class Contribution extends Fragment {

    Context mContext;
    MaterialCardView materialCardView1, materialCardView2, materialCardView3, materialCardView4;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_contribution, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        materialCardView1=view.findViewById(R.id.cardView1);
        materialCardView2=view.findViewById(R.id.cardView2);
        materialCardView3=view.findViewById(R.id.cardView3);
        materialCardView4=view.findViewById(R.id.cardView4);
        materialCardView1.setOnClickListener(view1 -> openFragment("https://www.carbonfootprint.com/calculator.aspx"));
        materialCardView2.setOnClickListener(view14 -> openFragment("https://cotap.org/reduce-carbon-footprint/"));
        materialCardView3.setOnClickListener(view12 -> openFragment("https://davidsuzuki.org/what-you-can-do/top-10-ways-can-stop-climate-change/"));
        materialCardView4.setOnClickListener(view13 -> openFragment("https://www.funkidslive.com/learn/marina-ventura/climate-explorers/"));
    }

    public void openFragment(String tag) {
        FragmentManager fragmentManager = getFragmentManager();
        final FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.home, new ViewLink(), tag);
        fragmentTransaction.commit();
    }
}