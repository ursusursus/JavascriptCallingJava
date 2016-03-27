package com.stylingandroid.vectordrawables;

import android.content.Intent;

/**
 * Created by Dusan on 27. 3. 2016.
 */
public class NotifUtils {

    public static void launch(android.content.Context context, String title) {
        Intent intent = new Intent(context, FooActivity.class);
        intent.putExtra("asd", title);
        context.startActivity(intent);
    }

}
