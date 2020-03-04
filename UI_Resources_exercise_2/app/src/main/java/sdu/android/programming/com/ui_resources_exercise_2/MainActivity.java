package sdu.android.programming.com.ui_resources_exercise_2;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Bitmap> images = new ArrayList<>();
    private ImageView mImageView;
    private int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Manual loading of images
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inScaled = true;
        images.add(BitmapFactory.decodeResource(getResources(), R.drawable.pexels_photo));
        images.add(BitmapFactory.decodeResource(getResources(), R.drawable.pexels_photo_62592));
        images.add(BitmapFactory.decodeResource(getResources(), R.drawable.pexels_photo_210723));
        images.add(BitmapFactory.decodeResource(getResources(), R.drawable.pexels_photo_462353));
        mImageView = findViewById(R.id.image_view);

        setImage();
    }

    public void setImage() {
        mImageView.setImageBitmap(images.get(index));
    }

    public void nextClick(View view) {
        if (index >= images.size()-1) {
            index = 0;
        } else {
            index++;
        }
        setImage();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }

    public void previousClick(View view) {
        if (index <= 0) {
            index = images.size() - 1;
        } else {
            index--;
        }
        setImage();
    }
}
