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


public class Quiz extends Fragment implements BackPressedListener {

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
        return inflater.inflate(R.layout.fragment_quiz, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        links.add("https://climate.nasa.gov/climate_resource_center/interactives/quizzes");
        links.add("https://www.earthday.org/the-climate-change-quiz/");
        links.add("https://climate.nasa.gov/climate_resources/16/quiz-global-warming/");
        links.add("https://blogs.ei.columbia.edu/2018/09/27/interactive-quiz-test-knowledge-climate-change-impacts/");
        links.add("https://cleanet.org/clean/literacy/climate/quiz.html");
        links.add("https://www.washingtonpost.com/climate-solutions/2019/11/22/quiz-how-much-do-you-know-about-climate-change/?arc404=true");
        links.add("https://www.nationalgeographic.com/environment/article/global-warming-quiz");
        links.add("https://www.britannica.com/quiz/climate-change");
        links.add("https://www.abc.net.au/science/games/quizzes/2009/climatechange/");
        links.add("https://www.energy.gov/articles/quiz-test-your-climate-change-iq");
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