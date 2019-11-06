package com.vfguille.inventory.ui.dash.dash.dependencies;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.vfguille.inventory.R;
import com.vfguille.inventory.adapter.DependencyAdapter;
import com.vfguille.inventory.data.model.Dependency;

public class DependenciesListActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private DependencyAdapter dependencyAdapter;
    private DependencyAdapter.OnDependencyClickListener onDependencyClickListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dependencies_list);
        View view;
        recyclerView = findViewById(R.id.rvDependencies);
        dependencyAdapter = new DependencyAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        recyclerView.setAdapter(dependencyAdapter);
        initializaListener();
    }

    private void initializaListener() {
        onDependencyClickListener = new DependencyAdapter.OnDependencyClickListener() {
            @Override
            public void onClick(Dependency dependency) {
                Toast.makeText(DependenciesListActivity.this, dependency.getName(), Toast.LENGTH_LONG).show();
            }
        };
        dependencyAdapter.setOnDependencyClickListener(onDependencyClickListener);
    }
}
