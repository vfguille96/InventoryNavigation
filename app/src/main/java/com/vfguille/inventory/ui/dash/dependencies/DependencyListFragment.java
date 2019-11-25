package com.vfguille.inventory.ui.dash.dependencies;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

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

public class DependencyListFragment extends Fragment {

    /**
     * Comunica al listener que se ha pulsado el botón add.
     */
    interface OnManageDependencyListener {
        void onManageDependency(Dependency dependency);
    }

    public static final String TAG = "dependenciesListFragment";
    private RecyclerView recyclerView;
    private DependencyAdapter dependencyAdapter;
    // Objeto-Delegado que sirve de comunicación con la clase Activity.
    private DependencyAdapter.OnManageDependencyListener onManageDependencyAdapterListener;
    private OnManageDependencyListener onManageDependencyListener;

    private final int SPAN_COUNT = 2;
    FloatingActionButton floatingActionButton;
    BottomAppBar bottomAppBar;

    public static Fragment onNewInstance(Bundle bundle) {
        DependencyListFragment fragment = new DependencyListFragment();
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
            onManageDependencyListener = (OnManageDependencyListener) context;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        onManageDependencyListener = null;
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
        bottomAppBar = view.findViewById(R.id.bottomAppBar);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onManageDependencyListener.onManageDependency(null);
            }
        });
    }

    private void initRvDependency(@NonNull View view) {
        // 1- Inicializar el listener del adapter.
        initializeListenerAdapter(onManageDependencyListener);

        // 2- Crear Adapter
        dependencyAdapter = new DependencyAdapter();
        dependencyAdapter.setOnManageDependencyClickListener(onManageDependencyAdapterListener);
        //LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false);

        // 3- Diseño del RV.
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), SPAN_COUNT);
        recyclerView.setLayoutManager(gridLayoutManager);

        // 4- Vincula la vista al modelo.
        recyclerView.setAdapter(dependencyAdapter);

    }

    @Override
    public void onResume() {
        super.onResume();
        dependencyAdapter.notifyDataSetChanged();
    }

    /**
     * Método que inicializa el listener que escucha los eventos del Adapter.
     */
    private void initializeListenerAdapter(final OnManageDependencyListener onManageDependencyListener) {
        onManageDependencyAdapterListener = new DependencyAdapter.OnManageDependencyListener() {

            /**
             * Se ha pulsado sobre un elemento de la lista y hay que mostrar el fragment DependencyManageFragment. Se llama al método de la Activity
             * para mostrar el fragment.
             * @param dependency
             */
            @Override
            public void onEditDependency(Dependency dependency) {
                onManageDependencyListener.onManageDependency(dependency);
            }

            /**
             * Se ha pulsado largo sobre un elemento de la lista y hay que borrar el elemento. Pide confirmación de borrado.
             * @param dependency
             */
            @Override
            public void onDeleteDependency(Dependency dependency) {
                Toast.makeText(getActivity(), "Se ha pulsado la dependencia: " + dependency.getShortName(), Toast.LENGTH_LONG).show();
            }
        };
    }


}