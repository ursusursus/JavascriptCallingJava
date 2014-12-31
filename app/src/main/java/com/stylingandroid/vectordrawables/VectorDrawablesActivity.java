package com.stylingandroid.vectordrawables;

import android.app.Activity;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;

public class VectorDrawablesActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vector_drawables);
        ImageView androidImageView = (ImageView) findViewById(R.id.android);
        Drawable drawable = androidImageView.getDrawable();
        if (drawable instanceof Animatable) {
            ((Animatable) drawable).start();
        }
    }
}
