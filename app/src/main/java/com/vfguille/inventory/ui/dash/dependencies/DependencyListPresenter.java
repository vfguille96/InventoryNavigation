package com.vfguille.inventory.ui.dash.dependencies;

import android.os.AsyncTask;

import com.vfguille.inventory.data.model.Dependency;
import com.vfguille.inventory.data.repository.DependencyRepository;

import java.util.List;

public class DependencyListPresenter implements DependencyListContract.Presenter {

    DependencyListContract.View view;

    public DependencyListPresenter(DependencyListContract.View view) {
        this.view = view;
    }

    @Override
    public void delete(Dependency dependency) {
        if (DependencyRepository.getInstance().delete(dependency))
            view.onSuccess();
    }

    @Override
    public void load() {
        new AsyncTask<Void, Void, List<Dependency>>() {
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                view.showProgress();
            }

            @Override
            protected void onPostExecute(List<Dependency> dependencyList) {
                super.onPostExecute(dependencyList);
                view.hideProgress();
                if (dependencyList.isEmpty())
                    view.showImageNoData();
                else {
                    if (!view.isVisibleImgNoData())
                        view.hideImageNoData();
                    view.showData(dependencyList);
                }
            }

            @Override
            protected void onProgressUpdate(Void... values) {
                super.onProgressUpdate(values);
            }

            @Override
            protected List<Dependency> doInBackground(Void... voids) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return DependencyRepository.getInstance().getList();
            }
        }.execute();
    }
}
