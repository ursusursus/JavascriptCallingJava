package com.stylingandroid.vectordrawables;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class ImageFragment extends Fragment {
    public static final String DRAWABLE_ID = "com.stylingandroid.vectordrawables.DRAWABLE_ID";

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_image, container, false);
        int drawableId = 0;
        Bundle arguments = getArguments();
        if (arguments != null) {
            drawableId = arguments.getInt(DRAWABLE_ID, 0);
        }
        setImage(view, drawableId);
        return view;
    }

    private void setImage(View parent, int imageId) {
        View view = parent.findViewById(R.id.image);
        if (imageId > 0 && view instanceof ImageView) {
            final ImageView imageView = (ImageView) view;
            imageView.setImageResource(imageId);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startAnimation(imageView);
                }
            });
        }

    }

    private void startAnimation(ImageView imageView) {
        Drawable drawable = imageView.getDrawable();
        if (drawable != null && drawable instanceof Animatable) {
            ((Animatable) drawable).start();
        }
    }
}
