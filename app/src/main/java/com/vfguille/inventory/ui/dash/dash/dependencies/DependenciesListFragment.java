package com.vfguille.inventory.ui.dash.dash.dependencies;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.vfguille.inventory.R;
import com.vfguille.inventory.adapter.DependencyAdapter;
import com.vfguille.inventory.data.model.Dependency;

public class DependenciesListFragment extends Fragment {

    /**
     * Comunica al listener que se ha pulsado el botón add.
     */
    interface OnAddDependencyListener{
        void onAddDependency();
    }

    public static final String TAG = "dependenciesListFragment";
    private RecyclerView recyclerView;
    private DependencyAdapter dependencyAdapter;
    private OnAddDependencyListener onAddDependencyListener;
    private final int SPAN_COUNT = 2;
    FloatingActionButton floatingActionButton;
    BottomAppBar bottomAppBar;



    public static Fragment onNewInstance(Bundle bundle){
        DependenciesListFragment fragment = new DependenciesListFragment();
        if (bundle != null)
            fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dependencies_list, container, false);
        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            onAddDependencyListener = (OnAddDependencyListener) context;
        }catch (Exception e){
            throw e;
        }

    }

    @Override
    public void onDetach() {
        super.onDetach();
        onAddDependencyListener = null;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.rvDependencies);
        initRvDependency(view);
        initializeFab(view);
    }

    private void initializeFab(@NonNull View view) {
        floatingActionButton = view.findViewById(R.id.floatingActionButton);
        bottomAppBar =  view.findViewById(R.id.bottomAppBar);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onAddDependencyListener.onAddDependency();
            }
        });
    }

    private void initRvDependency(@NonNull View view) {
        dependencyAdapter = new DependencyAdapter();
        //LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), SPAN_COUNT);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(dependencyAdapter);
    }
}
