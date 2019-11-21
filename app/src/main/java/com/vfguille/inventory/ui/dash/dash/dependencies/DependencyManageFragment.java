package com.vfguille.inventory.ui.dash.dash.dependencies;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.vfguille.inventory.R;


public class DependencyManageFragment extends Fragment {

    public static final String TAG = "dependencyAddFragment";
    private OnFragmentInteractionListener listener;
    private EditText edShortName;
    private EditText edName;
    private EditText edDescription;


    public interface OnFragmentInteractionListener {
        void onFragmentInteraction();
    }


    public static Fragment onNewInstance(Bundle bundle) {
        DependencyManageFragment fragment = new DependencyManageFragment();
        if (bundle!=null) {
            fragment.setArguments(bundle);
        }
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        edDescription = view.findViewById(R.id.edDescription);
        edName = view.findViewById(R.id.edName);
        edShortName = view.findViewById(R.id.edShortName);

        Bundle bundle = new Bundle(getArguments());

        if (bundle != null){
            // TODO: Impl.
        }
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