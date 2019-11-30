package com.vfguille.inventory.ui.dash;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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
import com.vfguille.inventory.ui.dash.dependencies.DependencyActivity;
import com.vfguille.inventory.ui.dash.sections.SectionActivity;

public class DashBoardActivity extends AppCompatActivity{
    FloatingActionButton floatingActionButton;
    BottomAppBar bottomAppBar;
    Button btDependencies;
    Button btSecion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board_material);
        floatingActionButton = findViewById(R.id.fabSection);
        bottomAppBar =  findViewById(R.id.babSection);
        btDependencies = findViewById(R.id.btnDependencies);
        btSecion = findViewById(R.id.btnSections);
        setSupportActionBar(bottomAppBar);

        btDependencies.setOnClickListener(new View.OnClickListener() {
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
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.bottom_bar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.profileMenu:
                return true;
            case R.id.settingsMenu:
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}