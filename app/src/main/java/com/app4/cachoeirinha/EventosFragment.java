package com.app4.cachoeirinha;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;

public class EventosFragment extends Fragment {

    View minhaView;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        minhaView = inflater.inflate(R.layout.activity_eventos, container, false);
        return minhaView;
    }

}
