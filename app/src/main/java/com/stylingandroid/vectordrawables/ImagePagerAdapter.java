package com.stylingandroid.vectordrawables;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public final class ImagePagerAdapter extends FragmentPagerAdapter {
    private static final String DRAWABLE = "drawable";
    private final Context content;
    private final int[] drawbleIds;

    public static ImagePagerAdapter newInstance(FragmentActivity activity) {
        FragmentManager fragmentManager = activity.getSupportFragmentManager();
        Resources resources = activity.getResources();
        String[] resourceStrings = resources.getStringArray(R.array.image_ids);
        int[] drawableIds = new int[resourceStrings.length];
        for (int i = 0; i < resourceStrings.length; i++) {
            drawableIds[i] = resources.getIdentifier(resourceStrings[i], DRAWABLE, activity.getPackageName());
        }
        return new ImagePagerAdapter(activity, fragmentManager, drawableIds);
    }

    private ImagePagerAdapter(Context content, FragmentManager fragmentManager, int[] drawbleIds) {
        super(fragmentManager);
        this.content = content;
        this.drawbleIds = drawbleIds;
    }

    @Override
    public Fragment getItem(int i) {
        Bundle arguments = new Bundle();
        arguments.putInt(ImageFragment.DRAWABLE_ID, drawbleIds[i]);
        return Fragment.instantiate(content, ImageFragment.class.getName(), arguments);
    }

    @Override
    public int getCount() {
        return drawbleIds.length;
    }
}
