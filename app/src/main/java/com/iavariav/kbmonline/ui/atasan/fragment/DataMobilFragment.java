package com.iavariav.kbmonline.ui.atasan.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.iavariav.kbmonline.R;
import com.iavariav.kbmonline.model.MobilModel;
import com.iavariav.kbmonline.ui.atasan.presenter.MobilPresenter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class DataMobilFragment extends Fragment {


    private RecyclerView rv;
    private MobilPresenter mobilPresenter;
    private ArrayList<MobilModel> mobilModels;
    private LinearLayout div;

    public DataMobilFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_data_mobil, container, false);
        initView(view);
        mobilPresenter = new MobilPresenter();
        mobilPresenter.getDataMobil(getActivity(), "getDataMobil", rv, div);

        return view;
    }

    private void initView(View view) {
        rv = view.findViewById(R.id.rv);
        div = view.findViewById(R.id.div);
    }
}
