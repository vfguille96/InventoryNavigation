package com.vfguille.inventory.ui.dash.dependencies;

import com.vfguille.inventory.data.model.Dependency;
import com.vfguille.inventory.ui.base.BaseView;

import java.util.List;

public interface DependencyListContract {
    interface View extends BaseView<Presenter> {
        void showProgress();
        void hideProgress();
        void hideImageNoData();
        void showImageNoData();
        void onSuccessDeleted();
        boolean isVisibleImgNoData();
        void showData(List<Dependency> dependencyList);
        void onSuccessUndo(Dependency dependency);
    }

    interface Presenter{
        void delete(Dependency dependency);
        void load();
        void undo(Dependency dependency);
    }
}