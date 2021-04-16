package com.app4.cachoeirinha;

import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

public class InicioFragment extends Fragment {
    View minhaView;
    ImageButton brasao;
    DrawerLayout drawer;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        minhaView = inflater.inflate(R.layout.content_inicio, container, false);
        brasao = minhaView.findViewById(R.id.brasao_inicio_id);
        brasao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawer.openDrawer(GravityCompat.START);
            }
        });


        return minhaView;
    }

    public InicioFragment(DrawerLayout drawer1) {
        drawer = drawer1;
    }

    public InicioFragment(){}
}
