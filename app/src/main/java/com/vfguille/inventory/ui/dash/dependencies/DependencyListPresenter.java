package com.vfguille.inventory.ui.dash.dependencies;

import com.vfguille.inventory.data.model.Dependency;

public class DependencyListPresenter implements DependencyListContract.Presenter {

    DependencyListContract.View view;

    public DependencyListPresenter(DependencyListContract.View view){
        this.view = view;
    }

    @Override
    public void delete(Dependency dependency) {

    }

    @Override
    public void load() {

    }
}
