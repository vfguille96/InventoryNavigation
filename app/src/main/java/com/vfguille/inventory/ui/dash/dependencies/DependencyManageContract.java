package com.vfguille.inventory.ui.dash.dependencies;

import com.vfguille.inventory.data.model.Dependency;
import com.vfguille.inventory.ui.base.BaseView;

/**
 * Interfaz que corresponde al contrato que se establece entre DependencyManageFragment (vista)
 * y DependencyManagePresenter (presenter).
 */
public interface DependencyManageContract {

    interface View extends BaseView<Presenter> {
        void onSuccessValidate();
    }

    interface Presenter {
        void validateDependency(Dependency dependency);

        void add(Dependency dependency);

        void edit(Dependency dependency);
    }
}