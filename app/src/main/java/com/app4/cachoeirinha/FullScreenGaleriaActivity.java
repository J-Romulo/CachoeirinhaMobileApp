package com.app4.cachoeirinha;


import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;

public class FullScreenGaleriaActivity extends AppCompatActivity {

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_screen_galeria);
        imageView = (ImageView) findViewById(R.id.image_view_galeria);
        getSupportActionBar().setTitle("Galeria");
        Intent i = getIntent();
        int position = i.getExtras().getInt("id");
        ImageAdapterGaleria imageAdapter = new ImageAdapterGaleria(this);
        imageView.setImageResource(imageAdapter.imageArray[position]);
    }
}
