package com.example.telematica.uiappexample.activities;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.example.telematica.uiappexample.R;
import com.example.telematica.uiappexample.fragment.LibroFragment;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setContentFrame(R.id.content_frame);

        switchContent(LibroFragment.nuevoLibroFragment(), null);



    }


}
