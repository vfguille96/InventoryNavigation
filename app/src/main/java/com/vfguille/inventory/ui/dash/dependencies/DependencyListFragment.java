package com.vfguille.inventory.ui.dash.dependencies;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.vfguille.inventory.R;
import com.vfguille.inventory.adapter.DependencyAdapter;
import com.vfguille.inventory.data.model.Dependency;

import java.util.List;

public class DependencyListFragment extends Fragment implements DependencyListContract.View {

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
    private DependencyListContract.Presenter presenter;

    private final int SPAN_COUNT = 2;
    FloatingActionButton floatingActionButton;
    BottomAppBar bottomAppBar;
    LottieAnimationView lottieAnimationView;
    LottieAnimationView skele1;
    LottieAnimationView skele2;

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
        initializeAnimations(view);
        initializeFab(view);
    }

    private void initializeAnimations(@NonNull View view) {
        lottieAnimationView = view.findViewById(R.id.ivNoData);
        skele1 = view.findViewById(R.id.ivSkele1);
        skele2 = view.findViewById(R.id.ivSkele2);
        lottieAnimationView.setVisibility(View.GONE);
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
    public void onStart() {
        super.onStart();

    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.load();
    }

    // ------------------------------------------------------------------------------------------------
    @Override
    public void showProgress() {
        skele1.setVisibility(View.VISIBLE);
        skele1.playAnimation();
        skele2.setVisibility(View.VISIBLE);
        skele2.playAnimation();
        recyclerView.setVisibility(View.GONE);
    }

    @Override
    public void hideProgress() {
        skele1.setVisibility(View.GONE);
        skele1.cancelAnimation();
        skele2.setVisibility(View.GONE);
        skele2.cancelAnimation();
        recyclerView.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideImageNoData() {
        lottieAnimationView.setVisibility(View.GONE);
        lottieAnimationView.cancelAnimation();
        recyclerView.setVisibility(View.VISIBLE);
    }

    /**
     * Actualiza el adapter para mostrar los datos.
     *
     * @param dependencyList
     */
    @Override
    public void showData(List<Dependency> dependencyList) {
        lottieAnimationView.setVisibility(View.GONE);
        dependencyAdapter.clear();
        dependencyAdapter.load(dependencyList);
    }

    @Override
    public void setPresenter(DependencyListContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void showError(String error) {

    }

    /**
     * Comprueba si hay datos en el fragment.
     *
     * @return
     */
    @Override
    public boolean isVisibleImgNoData() {
        return lottieAnimationView.getVisibility() == View.GONE;
    }

    @Override
    public void showImageNoData() {
        lottieAnimationView.setAnimation(R.raw.nodatabox);
        lottieAnimationView.setVisibility(View.VISIBLE);
        lottieAnimationView.playAnimation();
        recyclerView.setVisibility(View.GONE);
    }

    @Override
    public void onSuccess() {

    }

    @Override
    public void showError(int errAddDependency) {

    }

    //-------------------------------------------------------------------------------------------------


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
            public void onDeleteDependency(final Dependency dependency) {
                new MaterialAlertDialogBuilder(getContext())
                        .setTitle(R.string.delete_dependency)
                        .setMessage(getString(R.string.delete_body) + " " + dependency.getShortName())
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                presenter.delete(dependency);
                                presenter.load();
                            }
                        })
                        .setNegativeButton(android.R.string.no, null)
                        .show();
            }
        };
    }
}