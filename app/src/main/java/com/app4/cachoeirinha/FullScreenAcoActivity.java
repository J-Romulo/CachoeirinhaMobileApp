package com.app4.cachoeirinha;


import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class FullScreenAcoActivity extends AppCompatActivity {

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_screen_aco);
        imageView = (ImageView) findViewById(R.id.image_view2);
        getSupportActionBar().setTitle("Feira do couro e aco");
        Intent i = getIntent();
        int position = i.getExtras().getInt("id");
        ImageAdapterAco imageAdapterAco = new ImageAdapterAco(this);
        imageView.setImageResource(imageAdapterAco.imageArray[position]);
    }
}
