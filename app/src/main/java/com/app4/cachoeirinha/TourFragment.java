package com.app4.cachoeirinha;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

public class TourFragment extends Fragment {

    View minhaView;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        minhaView = inflater.inflate(R.layout.content_tour, container, false);
        return minhaView;
    }
}
