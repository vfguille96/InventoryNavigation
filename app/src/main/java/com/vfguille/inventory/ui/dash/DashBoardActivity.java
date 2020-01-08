package com.vfguille.inventory.ui.dash;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.vfguille.inventory.R;
import com.vfguille.inventory.ui.base.BaseActivity;
import com.vfguille.inventory.ui.dash.dependencies.DashBoardFragment;
import com.vfguille.inventory.ui.dash.dependencies.DependencyActivity;
import com.vfguille.inventory.ui.dash.dependencies.DependencyListFragment;
import com.vfguille.inventory.ui.dash.sections.SectionActivity;

public class DashBoardActivity extends BaseActivity implements DashBoardFragment.OnFragmentInteractionListener{
    FloatingActionButton floatingActionButton;
    BottomAppBar bottomAppBar;
    Button btDependencies;
    Button btSecion;
    DashBoardFragment dashBoardFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_dash_board_material);
//        floatingActionButton = findViewById(R.id.fabSection);
//        bottomAppBar =  findViewById(R.id.babSection);
//        btDependencies = findViewById(R.id.btnDependencies);
//        btSecion = findViewById(R.id.btnSections);
        //setSupportActionBar(bottomAppBar);

       /* btDependencies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DashBoardActivity.this, DependencyActivity.class));
            }
        });

        btSecion.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DashBoardActivity.this, SectionActivity.class));
            }
        });*/

        FragmentManager fragmentManager = getSupportFragmentManager();
        dashBoardFragment = (DashBoardFragment) fragmentManager.findFragmentByTag(DashBoardFragment.TAG);
        if (dashBoardFragment == null) {
            dashBoardFragment = (DashBoardFragment) DashBoardFragment.newInstance();
            fragmentManager.beginTransaction().replace(R.id.content, dashBoardFragment, DependencyListFragment.TAG).commit();
        }
    }
}