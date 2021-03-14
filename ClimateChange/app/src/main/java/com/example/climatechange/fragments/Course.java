package com.example.climatechange.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.climatechange.R;
import com.example.climatechange.adapter.BackPressedListener;
import com.example.climatechange.adapter.LinkAdapter;

import java.util.ArrayList;


public class Course extends Fragment implements BackPressedListener {
    Context mContext;
    ListView listView;
    LinkAdapter urlAdapter;
    ArrayList<String> links = new ArrayList<>();


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
        return inflater.inflate(R.layout.fragment_course, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        links.add("https://www.coursera.org/specializations/climate-change-and-health");
        links.add("https://www.coursera.org/learn/climate-change-mitigation");
        links.add("https://www.coursera.org/specializations/our-responses-climate-change");
        links.add("https://www.edx.org/course/climate-change-the-science-and-global-impact");
        links.add("https://www.edx.org/course/climate-change-financial-risks-and-opportunities");
        links.add("https://www.edx.org/course/the-health-effects-of-climate-change");
        links.add("https://www.edx.org/course/climate-action-solutions-for-a-changing-planet");
        links.add("https://www.onlinestudies.com/Causes-of-Climate-Change-Course-University-of-Bergen/Norway/FutureLearn/");
        links.add("https://www.futurelearn.com/courses/climate-change-the-science");
        links.add("https://online-learning.harvard.edu/course/health-effects-climate-change?delta=1");
        listView = view.findViewById(R.id.list);
        urlAdapter = new LinkAdapter(mContext, links);
        listView.setAdapter(urlAdapter);
    }

    @Override
    public void onBackPressed() {
        links.clear();
        urlAdapter.notifyDataSetChanged();
    }
}