package com.app4.cachoeirinha;


import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class FullScreenFrutaActivity extends AppCompatActivity {

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_screen_fruta);
        imageView = (ImageView) findViewById(R.id.image_view);
        getSupportActionBar().setTitle("Feira da fruta");
        Intent i = getIntent();
        int position = i.getExtras().getInt("id");
        ImageAdapterFruta imageAdapterFruta = new ImageAdapterFruta(this);
        imageView.setImageResource(imageAdapterFruta.imageArray[position]);
    }
}
