package com.vfguille.inventory.ui.dash.sections;

import com.vfguille.inventory.data.model.Section;
import com.vfguille.inventory.ui.base.BaseView;

public interface SectionManageContract {

    interface View extends BaseView<Presenter> {
        void onSuccess();
        void showError(int errAddSection);
        void onSuccessValidate();
        void showError(String error);
    }

    interface Presenter {
        void validateSection(Section section);

        void add(Section section);

        void edit(Section section);

        void delete(Section section);
    }
}