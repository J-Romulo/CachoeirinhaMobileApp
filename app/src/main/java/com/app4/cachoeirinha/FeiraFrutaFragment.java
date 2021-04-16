package com.app4.cachoeirinha;

//import androidx.annotation.NonNull;
//import androidx.appcompat.app.AppCompatActivity;

import androidx.fragment.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

public class FeiraFrutaFragment extends Fragment {

    View minhaView;
    GridView gridView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        minhaView = inflater.inflate(R.layout.content_feira_fruta, container, false);
        gridView = minhaView.findViewById(R.id.grid_view);
        gridView.setAdapter(new ImageAdapterFruta(minhaView.getContext()));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(minhaView.getContext(), FullScreenFrutaActivity.class);
                intent.putExtra("id",position);
                startActivity(intent);
            }
        });

        return minhaView;
    }
}
