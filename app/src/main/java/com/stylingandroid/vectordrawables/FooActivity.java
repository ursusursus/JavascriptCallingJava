package com.stylingandroid.vectordrawables;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Dusan on 27. 3. 2016.
 */
public class FooActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foo);
    }

    public static void launch(android.content.Context context) {
        Intent intent = new Intent(context, FooActivity.class);
        context.startActivity(intent);
    }
}
