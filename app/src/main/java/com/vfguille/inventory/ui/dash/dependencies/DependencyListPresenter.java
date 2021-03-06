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

    /**
     * Eliminar no influye en los filtros del presenter.
     * No influye en el orden
     * @param dependency
     */
    @Override
    public void delete(Dependency dependency) {
        //  1- Realizar operación en el repositorio y comprobar el resultado.
        if (DependencyRepository.getInstance().delete(dependency)) {
            //  1.2 Comprobar si no hay datos.
            if (DependencyRepository.getInstance().getList().isEmpty())
                view.showImageNoData();
            view.onSuccessDeleted();
        }
    }

    @Override
    public void load() {
        new AsyncTask<Void, Void, List<Dependency>>() {
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                checkImageNoDataIsVisible();
                view.showProgress();
            }

            @Override
            protected void onPostExecute(List<Dependency> dependencyList) {
                super.onPostExecute(dependencyList);
                view.hideProgress();
                if (dependencyList.isEmpty())
                    view.showImageNoData();
                else {
                    checkImageNoDataIsVisible();
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

    @Override
    public void undo(Dependency dependency) {
        if (DependencyRepository.getInstance().add(dependency)){
            // Hay que actualizar el adapter
            view.onSuccessUndo(dependency);
            if (DependencyRepository.getInstance().getList().size() == 1)
                view.hideImageNoData();
        }

    }

    private void checkImageNoDataIsVisible() {
        if (!view.isVisibleImgNoData())
            view.hideImageNoData();
    }
}