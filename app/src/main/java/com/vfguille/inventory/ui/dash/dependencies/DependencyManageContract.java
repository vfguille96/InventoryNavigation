package com.vfguille.inventory.ui.dash.dependencies;

import com.vfguille.inventory.data.model.Dependency;
import com.vfguille.inventory.ui.base.BaseView;

/**
 * Interfaz que corresponde al contrato que se establece entre SectionManageFragment (vista)
 * y SectionManagePresenter (presenter).
 */
public interface DependencyManageContract {

    interface View extends BaseView<Presenter> {
        void onSuccess();
        void showError(int errAddDependency);
        void onSuccessValidate();
        void showError(String error);
    }

    interface Presenter {
        void validateDependency(Dependency dependency);

        void add(Dependency dependency);

        void edit(Dependency dependency);

        void delete(Dependency dependency);
    }
}