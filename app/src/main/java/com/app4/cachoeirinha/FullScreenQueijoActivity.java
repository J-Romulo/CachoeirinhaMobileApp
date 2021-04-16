package com.app4.cachoeirinha;


import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class FullScreenQueijoActivity extends AppCompatActivity {

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_screen_queijo);
        imageView = (ImageView) findViewById(R.id.image_view4);
        getSupportActionBar().setTitle("Feira do queijo");
        Intent i = getIntent();
        int position = i.getExtras().getInt("id");
        ImageAdapterQueijo imageAdapterQueijo = new ImageAdapterQueijo(this);
        imageView.setImageResource(imageAdapterQueijo.imageArray[position]);
    }
}
