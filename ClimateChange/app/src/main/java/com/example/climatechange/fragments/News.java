package com.example.climatechange.fragments;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.example.climatechange.R;
import com.example.climatechange.adapter.BackPressedListener;
import com.example.climatechange.adapter.LinkAdapter;

import java.util.ArrayList;

public class News extends Fragment implements BackPressedListener {
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
        return inflater.inflate(R.layout.fragment_news, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        links.add("https://climate.nasa.gov/news/?page=0&per_page=40&order=publish_date+desc%2C+created_at+desc&search=&category=19%2C98");
        links.add("https://edition.cnn.com/specials/world/cnn-climate");
        links.add("https://economictimes.indiatimes.com/topic/climate-change");
        links.add("https://www.theguardian.com/environment/climate-change");
        links.add("https://transitionnetwork.org/news-and-blog/category/climate-change/?gclid=CjwKCAiAhbeCBhBcEiwAkv2cY69KZzyH1dfJ1ESwmVXRrU6QDuTamVoGLzyu9yk-IAwzTIBOTEVF7hoCCBwQAvD_BwE");
        links.add("https://www.nature.com/nclimate/articles?year=2021");
        links.add("https://www.sciencedaily.com/news/earth_climate/climate/");
        links.add("https://www.independent.co.uk/topic/climate-change");
        links.add("https://www.downtoearth.org.in/climate-change");
        links.add("https://www.teriin.org/climate");

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