package com.greenmonkey47.testandroid.adapters;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class ImageAdapter extends ArrayAdapter {

    Context context;
    ArrayList<Bitmap> bitmapList = new ArrayList<Bitmap>() ;

    public ImageAdapter(@NonNull Context context, int resource, @NonNull Object[] objects) {
        super(context, resource, objects);
        this.context = context;
        AssetManager assetManager = this.context.getAssets();

        InputStream is;
        try {
            is = assetManager.open("img_1.jpeg");
            Bitmap  bitmap = BitmapFactory.decodeStream(is);
            is.close();

            for(int i=0;i<10*objects.length;i++){
                bitmapList.add(bitmap);
            }

        }
        catch (IOException e){
            Toast.makeText(context, "error in reading image", Toast.LENGTH_SHORT).show();
        }


    }

    @Override
    public int getCount() {
        return bitmapList.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //return super.getView(position, convertView, parent);

        ImageView image_view;
        if(convertView==null){
            image_view = new ImageView(this.context);
        }else{
            image_view = (ImageView) convertView;
        }

        image_view.setImageBitmap(this.bitmapList.get(position));
        return image_view;
    }
}
