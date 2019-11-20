package com.vfguille.inventory.ui.dash.dash.dependencies;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vfguille.inventory.R;


public class DependencyAddFragment extends Fragment {

    public static final String TAG = "dependencyAddFragment";
    private OnFragmentInteractionListener listener;

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction();
    }


    public static Fragment onNewInstance(Bundle bundle) {
        DependencyAddFragment fragment = new DependencyAddFragment();
        if (bundle!=null) {
            fragment.setArguments(bundle);
        }
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_dependency_add, container, false);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            listener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

}
