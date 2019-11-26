package com.vfguille.inventory.ui.dash.dependencies;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import com.vfguille.inventory.R;
import com.vfguille.inventory.data.model.Dependency;

public class DependencyActivity extends AppCompatActivity implements
        DependencyListFragment.OnManageDependencyListener{

    private DependencyListFragment dependencyListFragment;
    private DependencyManageFragment dependencyManageFragment;
    private DependencyManagePresenter dependencyManagePresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dependencies);
        showListFragment();
    }

    /**
     * Muestra el DependenciesFragment
     */
    private void showListFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        dependencyListFragment = (DependencyListFragment) fragmentManager.findFragmentByTag(DependencyListFragment.TAG);
        if (dependencyListFragment == null)
            dependencyListFragment = (DependencyListFragment) DependencyListFragment.onNewInstance(null);
        fragmentManager.beginTransaction().add(android.R.id.content, dependencyListFragment, DependencyListFragment.TAG).commit();

        // Depués de crear la vista, se crea el Presenter (inicialización del contrato).
       // dependencyListFragment = new DependencyListPresenter(dependencyListFragment);
       // dependencyListFragment.setPresenter(dependencyManagePresenter);
    }
/*
    private void showAddFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        dependencyManageFragment = (DependencyManageFragment) fragmentManager.findFragmentByTag(DependencyManageFragment.TAG);
        if (dependencyManageFragment == null)
            dependencyManageFragment = (DependencyManageFragment) DependencyManageFragment.onNewInstance(null);
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(android.R.id.content, dependencyManageFragment, DependencyManageFragment.TAG);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }*/

    @Override
    public void onManageDependency(Dependency dependency) {
        Bundle b = null;
        dependencyManageFragment = (DependencyManageFragment) getSupportFragmentManager().findFragmentByTag(DependencyManageFragment.TAG);
        if (dependencyManageFragment == null) {
            if (dependency != null) {
                b = new Bundle();
                b.putParcelable(Dependency.TAG, dependency);
            }
            dependencyManageFragment = (DependencyManageFragment) DependencyManageFragment.onNewInstance(b);
        }

        // Depués de crear la vista, se crea el Presenter (inicialización del contrato).
        dependencyManagePresenter = new DependencyManagePresenter(dependencyManageFragment);
        dependencyManageFragment.setPresenter(dependencyManagePresenter);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(android.R.id.content, dependencyManageFragment, DependencyManageFragment.TAG)
                .addToBackStack(null)
                .commit();
    }
}