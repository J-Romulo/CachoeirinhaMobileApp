package com.app4.cachoeirinha;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapFragment extends Fragment implements OnMapReadyCallback {
    GoogleMap map;
    View minhaView;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        minhaView = inflater.inflate(R.layout.content_map, container, false);
        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        return minhaView;
    }

    @Override
    public void onMapReady(GoogleMap googleMap){
        float zoomLevel = 15.0f;
        map = googleMap;
        LatLng Cachoeirinha = new LatLng(-8.490766, -36.237859);
        map.addMarker(new MarkerOptions().position(Cachoeirinha).title("Cachoeirinha"));
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(Cachoeirinha, zoomLevel));
    }
}
