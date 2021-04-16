package com.app4.cachoeirinha;


import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class FullScreenGadoActivity extends AppCompatActivity {

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_screen_gado);
        imageView = (ImageView) findViewById(R.id.image_view3);
        getSupportActionBar().setTitle("Feira do gado");
        Intent i = getIntent();
        int position = i.getExtras().getInt("id");
        ImageAdapterGado imageAdapterGado = new ImageAdapterGado(this);
        imageView.setImageResource(imageAdapterGado.imageArray[position]);
    }
}
