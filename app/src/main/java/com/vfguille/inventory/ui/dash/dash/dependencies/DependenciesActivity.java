package com.vfguille.inventory.ui.dash.dash.dependencies;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.vfguille.inventory.R;
import com.vfguille.inventory.data.model.Dependency;

public class DependenciesActivity extends AppCompatActivity implements DependenciesListFragment.OnManageDependencyListener,
        DependencyManageFragment.OnFragmentInteractionListener {
    private DependenciesListFragment dependenciesListFragment;
    private DependencyManageFragment dependencyManageFragment;

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
        dependenciesListFragment = (DependenciesListFragment) fragmentManager.findFragmentByTag(DependenciesListFragment.TAG);
        if (dependenciesListFragment == null)
            dependenciesListFragment = (DependenciesListFragment) DependenciesListFragment.onNewInstance(null);
        fragmentManager.beginTransaction().add(android.R.id.content, dependenciesListFragment, DependenciesListFragment.TAG).commit();

    }

    private void showAddFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        dependencyManageFragment = (DependencyManageFragment) fragmentManager.findFragmentByTag(DependencyManageFragment.TAG);
        if (dependencyManageFragment == null)
            dependencyManageFragment = (DependencyManageFragment) DependencyManageFragment.onNewInstance(null);
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(android.R.id.content, dependencyManageFragment, DependencyManageFragment.TAG);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public void onFragmentInteraction() {

    }

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

        getSupportFragmentManager()
                .beginTransaction()
                .replace(android.R.id.content, dependencyManageFragment, DependencyManageFragment.TAG)
                .addToBackStack(null)
                .commit();
    }
}