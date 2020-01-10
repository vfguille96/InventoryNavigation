package com.vfguille.inventory.ui.dash.product;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vfguille.inventory.R;

public class ProductMapFragment extends Fragment {

    public ProductMapFragment() {
        // Required empty public constructor
    }

    public static ProductMapFragment newInstance() {
        ProductMapFragment fragment = new ProductMapFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_product_map, container, false);
    }

}
