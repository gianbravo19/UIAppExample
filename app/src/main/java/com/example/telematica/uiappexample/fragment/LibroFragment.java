package com.example.telematica.uiappexample.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.telematica.uiappexample.R;
import com.example.telematica.uiappexample.presenters.UIAdapter;
import com.example.telematica.uiappexample.presenters.Libro;
import com.example.telematica.uiappexample.presenters.LibroPresenter;
import com.example.telematica.uiappexample.views.LibroVIew;

import java.util.List;

/**
 * Created by italiano Leo on 15-01-2016.
 */
public class LibroFragment extends Fragment implements LibroVIew {

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private LibroPresenter mLibroPresenter;
    private UIAdapter  mAdapter;


    public static LibroFragment nuevoLibroFragment(){
        LibroFragment m = new LibroFragment();
        return m;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View mainView = inflater.inflate(R.layout.librofragmentlayout, null);

        mRecyclerView = (RecyclerView) mainView.findViewById(R.id.recyclerView);

        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mLibroPresenter = new LibroPresenter(this);

        return mainView;
    }

    @Override
    public void onResume(){
        super.onResume();
        mLibroPresenter.obtenerLibros();
    }

    @Override
    public void manageLibro(List<Libro> mListLibro) {
        mAdapter = new UIAdapter(mListLibro);
        mRecyclerView.setAdapter(mAdapter);

    }

}
