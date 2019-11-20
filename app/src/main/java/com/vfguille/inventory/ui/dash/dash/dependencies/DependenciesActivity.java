package com.vfguille.inventory.ui.dash.dash.dependencies;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.vfguille.inventory.R;
import com.vfguille.inventory.adapter.DependencyAdapter;
import com.vfguille.inventory.data.model.Dependency;

public class DependenciesActivity extends AppCompatActivity implements DependenciesListFragment.OnAddDependencyListener, DependencyAddFragment.OnFragmentInteractionListener{
    private DependenciesListFragment dependenciesListFragment;
    private DependencyAddFragment dependencyAddFragment;

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
        if (dependenciesListFragment == null){
            dependenciesListFragment = (DependenciesListFragment) DependenciesListFragment.onNewInstance(null);
            fragmentManager.beginTransaction().add(android.R.id.content, dependenciesListFragment, DependenciesListFragment.TAG).commit();
        }
    }

    @Override
    public void onAddDependency() {
        showAddFragment();
    }

    private void showAddFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        dependencyAddFragment = (DependencyAddFragment) fragmentManager.findFragmentByTag(DependencyAddFragment.TAG);
        if (dependencyAddFragment == null)
            dependencyAddFragment = (DependencyAddFragment) DependencyAddFragment.onNewInstance(null);
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(android.R.id.content, dependencyAddFragment, DependencyAddFragment.TAG);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public void onFragmentInteraction() {

    }
}
