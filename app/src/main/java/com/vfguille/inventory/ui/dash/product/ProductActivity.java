package com.vfguille.inventory.ui.dash.product;

import android.os.Bundle;

import androidx.fragment.app.FragmentManager;

import com.vfguille.inventory.R;
import com.vfguille.inventory.ui.base.BaseActivity;

public class ProductActivity extends BaseActivity {

    private ProductFragment productFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        showProductFragment();
    }

    private void showProductFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        productFragment = (ProductFragment) fragmentManager.findFragmentByTag(ProductFragment.TAG);
        if (productFragment == null){
            productFragment = ProductFragment.newInstance();
            fragmentManager.beginTransaction()
                    .replace(R.id.content, productFragment)
                    .commit();
        }
    }
}
