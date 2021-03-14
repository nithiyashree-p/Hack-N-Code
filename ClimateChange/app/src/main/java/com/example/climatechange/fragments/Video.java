package com.example.climatechange.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.climatechange.R;
import com.example.climatechange.adapter.BackPressedListener;
import com.example.climatechange.adapter.VideoAdapter;

import java.util.ArrayList;


public class Video extends Fragment implements BackPressedListener {
    Context mContext;
    VideoAdapter videoAdapter;
    RecyclerView recyclerView;
    ArrayList<String> video = new ArrayList<>();

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
        return inflater.inflate(R.layout.fragment_video, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        video.add("https://www.youtube.com/watch?v=dcBXmj1nMTQ");
        video.add("https://www.youtube.com/watch?v=G4H1N_yXBiA");
        video.add("https://www.youtube.com/watch?v=ifrHogDujXw");
        video.add("https://www.youtube.com/watch?v=7vOwjNTDwBE");
        video.add("https://www.youtube.com/watch?v=DkZ7BJQupVA");
        video.add("https://www.youtube.com/watch?v=-D_Np-3dVBQ");
        video.add("https://www.youtube.com/watch?v=Sv7OHfpIRfU");
        video.add("https://www.youtube.com/watch?v=DhhVr5iLF-c");
        video.add("https://www.youtube.com/watch?v=nWvN-UQa5SA");
        video.add("https://www.youtube.com/watch?v=g6H9Q8wB4h8");
        video.add("https://www.youtube.com/watch?v=PslL9WC-2cQ");
        recyclerView = view.findViewById(R.id.video_recycler);
        videoAdapter = new VideoAdapter(mContext, video);
        recyclerView.setItemViewCacheSize(video.size());
        RecyclerView.LayoutManager manager = new LinearLayoutManager(mContext);
        recyclerView.setLayoutManager(manager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(videoAdapter);
        recyclerView.setHasFixedSize(true);
    }

    @Override
    public void onBackPressed() {
        video.clear();
        videoAdapter.notifyDataSetChanged();
    }
}