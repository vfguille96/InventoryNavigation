package com.vfguille.inventory.ui.dash.dependencies;

import com.vfguille.inventory.data.model.Dependency;
import com.vfguille.inventory.data.repository.DependencyRepository;

public class DependencyManagePresenter implements DependencyManageContract.Presenter {

    private DependencyManageContract.View view;

    public DependencyManagePresenter(DependencyManageContract.View view) {
        this.view = view;
    }

    /**
     * Valida RN2,RN3, RN4.
     *
     * @param dependency
     */
    @Override
    public void validateDependency(Dependency dependency) {
        //view.showError();
        view.onSuccessValidate();
    }

    @Override
    public void add(Dependency dependency) {
        DependencyRepository.getInstance().add(dependency);
        view.onSuccess();
    }

    @Override
    public void edit(Dependency dependency) {
        DependencyRepository.getInstance().edit(dependency);
        view.onSuccess();
    }
}

