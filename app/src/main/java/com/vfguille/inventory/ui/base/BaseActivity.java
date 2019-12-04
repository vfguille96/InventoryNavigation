package com.vfguille.inventory.ui.base;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.vfguille.inventory.R;

public class BaseActivity extends AppCompatActivity {
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.bottom_bar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){

            case R.id.app_bar_search:
                Toast.makeText(this, getString(R.string.search), Toast.LENGTH_SHORT).show();
                break;
            case R.id.settingsMenu:
                Toast.makeText(this, getString(R.string.settings), Toast.LENGTH_SHORT).show();
                break;
            case R.id.help:
                Toast.makeText(this, getString(R.string.help), Toast.LENGTH_SHORT).show();
                break;
            case R.id.profileMenu:
                Toast.makeText(this, getString(R.string.profile), Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
