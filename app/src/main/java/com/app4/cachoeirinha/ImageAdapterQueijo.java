package com.app4.cachoeirinha;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapterQueijo extends BaseAdapter {

    private Context mContext;

    public int[] imageArray = {
            R.drawable.q1, R.drawable.q2, R.drawable.q3, R.drawable.q4, R.drawable.q5,
            R.drawable.q6, R.drawable.q7, R.drawable.q8, R.drawable.q9, R.drawable.q10,
            R.drawable.q11
    };

    public ImageAdapterQueijo(Context mContext){
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
