package com.app4.cachoeirinha;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import androidx.viewpager.widget.PagerAdapter;

public class ImageAdapterGaleria extends BaseAdapter {

    private Context mContext;

    public int[] imageArray = {
            R.drawable.bandeira, R.drawable.foto_antiga0, R.drawable.foto_antiga1, R.drawable.foto_antiga2, R.drawable.foto_antiga3,
            R.drawable.foto_antiga4, R.drawable.foto_antiga5, R.drawable.foto_antiga6, R.drawable.foto_antiga7, R.drawable.primeiro_posto, R.drawable.igreja_fundo2,
            R.drawable.a2, R.drawable.a3, R.drawable.a4, R.drawable.a5, R.drawable.a6, R.drawable.f5, R.drawable.f6, R.drawable.f14,
            R.drawable.g2, R.drawable.g3, R.drawable.g6, R.drawable.q4, R.drawable.q6, R.drawable.q8, R.drawable.q11,
            R.drawable.tour0, R.drawable.tour1, R.drawable.tour2, R.drawable.tour3, R.drawable.tour4, R.drawable.tour5,
            R.drawable.tour6, R.drawable.tour7, R.drawable.tour8, R.drawable.tour9, R.drawable.tour10
    };

    public ImageAdapterGaleria(Context mContext){
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return imageArray.length;
    }

    @Override
    public Object getItem(int i) {
        return imageArray[i];
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImageView imageView = new ImageView(mContext);
        imageView.setImageResource(imageArray[i]);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(new GridView.LayoutParams(340,350));

        return imageView;
    }
}
