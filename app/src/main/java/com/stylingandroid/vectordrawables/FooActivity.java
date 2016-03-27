package com.stylingandroid.vectordrawables;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by Dusan on 27. 3. 2016.
 */
public class FooActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foo);
        String title = getIntent().getStringExtra("asd");
        ((TextView) findViewById(R.id.titleTextView)).setText(title);
    }
}
