package com.vfguille.inventory.ui.dash.sections;

import android.os.AsyncTask;

import com.vfguille.inventory.data.model.Section;
import com.vfguille.inventory.data.repository.SectionRepository;

import java.util.List;

public class SectionListPresenter implements SectionListContract.Presenter{
    private SectionListContract.View view;

    public SectionListPresenter(SectionListContract.View view) {
        this.view = view;
    }

    @Override
    public void delete(Section section) {
        if (SectionRepository.getInstance().delete(section)) {
            if (SectionRepository.getInstance().getList().isEmpty())
                view.showImageNoData();
            view.onSuccessDeleted();
        }
    }

    @Override
    public void load() {
        new AsyncTask<Void, Void, List<Section>>() {
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                checkImageNoDataIsVisible();
                view.showProgress();
            }

            @Override
            protected void onPostExecute(List<Section> sectionList) {
                super.onPostExecute(sectionList);
                view.hideProgress();
                if (sectionList.isEmpty())
                    view.showImageNoData();
                else {
                    checkImageNoDataIsVisible();
                    view.showData(sectionList);
                }
            }

            @Override
            protected List<Section> doInBackground(Void... voids) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return SectionRepository.getInstance().getList();
            }
        }.execute();
    }

    @Override
    public void undo(Section section) {
        if (SectionRepository.getInstance().add(section)){
            view.onSuccessUndo(section);
            if (SectionRepository.getInstance().getList().size() == 1)
                view.hideImageNoData();
        }
    }

    private void checkImageNoDataIsVisible() {
        if (!view.isVisibleImgNoData())
            view.hideImageNoData();
    }
}
