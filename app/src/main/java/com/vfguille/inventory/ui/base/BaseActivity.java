package com.vfguille.inventory.ui.base;

import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.navigation.NavigationView;
import com.vfguille.inventory.R;

public class BaseActivity extends AppCompatActivity {

    protected DrawerLayout drawerLayout;
    protected NavigationView navigationView;
    protected Toolbar toolbar;
    protected BottomAppBar bottomAppBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation);
        toolbar = findViewById(R.id.toolbar);
        bottomAppBar = findViewById(R.id.babSection);
        setSupportActionBar(bottomAppBar);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setupNavigationView();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                    drawerLayout.openDrawer(GravityCompat.START);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.bottom_bar_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    private void setupNavigationView(){
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){

                    case R.id.app_bar_search:
                        Toast.makeText(BaseActivity.this, getString(R.string.search), Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.settingsMenu:
                        Toast.makeText(BaseActivity.this, getString(R.string.settings), Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.help:
                        Toast.makeText(BaseActivity.this, getString(R.string.help), Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.profileMenu:
                        Toast.makeText(BaseActivity.this, getString(R.string.profile), Toast.LENGTH_SHORT).show();
                        break;
                }
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });
    }
}
