package com.vfguille.inventory.ui.dash.dependencies;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.vfguille.inventory.R;
import com.vfguille.inventory.data.model.Dependency;


public class DependencyManageFragment extends Fragment implements DependencyManageContract.View {

    public static final String TAG = "dependencyAddFragment";
    private OnFragmentInteractionListener listener;
    private EditText edShortName;
    private EditText edName;
    private EditText edDescription;
    private FloatingActionButton floatingActionButton;
    private Spinner spInventory;
    private DependencyManageContract.Presenter dependencyManagePresenter;

    // Métodos del contrato DependencyManageContract
    @Override
    public void setPresenter(DependencyManageContract.Presenter presenter) {
        this.dependencyManagePresenter = presenter;
    }

    @Override
    public void showError(String error) {
        Toast.makeText(getContext(), error, Toast.LENGTH_LONG).show();
    }

    /**
     * Es llamado desde el Presenter después de realizar una de las acciones de add/edit y se muestra la lista.
     */
    @Override
    public void onSuccess() {
        getActivity().onBackPressed();
    }

    @Override
    public void showError(int errAddDependency) {
        Toast.makeText(getContext(), getString(errAddDependency), Toast.LENGTH_LONG).show();
    }

    /**
     * Es llamado desde el Presenter después de comprobar que la dependencia es correcta.
     */
    @Override
    public void onSuccessValidate() {
        Dependency dependency = getDependency();
        if (getArguments() != null)
            dependencyManagePresenter.edit(dependency);
        else
            dependencyManagePresenter.add(dependency);
    }
    // ---


    public interface OnFragmentInteractionListener {
        void onFragmentInteraction();
    }


    public static Fragment onNewInstance(Bundle bundle) {
        DependencyManageFragment fragment = new DependencyManageFragment();
        if (bundle != null)
            fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initializeViewElements(view);
        initializeFab();

        Bundle bundle = getArguments();
        if (bundle != null)
            setDependencyInView(bundle);
    }

    private void initializeViewElements(@NonNull View view) {
        edDescription = view.findViewById(R.id.edDescription);
        edName = view.findViewById(R.id.edName);
        edShortName = view.findViewById(R.id.edShortName);
        spInventory = view.findViewById(R.id.spInventory);
        floatingActionButton = view.findViewById(R.id.floatingActionButton);
    }

    private void setDependencyInView(Bundle bundle) {
        Dependency dependency = bundle.getParcelable(Dependency.TAG);
        edShortName.setEnabled(false);
        edShortName.setText(dependency.getShortName());
        edName.setText(dependency.getName());
        edDescription.setText(dependency.getDescription());
    }


    /**
     * Valida la dependencia. Añade o edita.
     */
    private void initializeFab() {
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isDependencyValid())
                    dependencyManagePresenter.validateDependency(getDependency());
            }
        });
    }

    /**
     * Recoge los datos de la vista y se crea una Dependencia.
     *
     * @return
     */
    private Dependency getDependency() {
        Dependency dependency = new Dependency();
        dependency.setName(edName.getText().toString());
        dependency.setShortName(edShortName.getText().toString());
        dependency.setInventory(spInventory.getSelectedItem().toString());
        dependency.setDescription(edDescription.getText().toString());
        return dependency;
    }

    /**
     * Comprueba las reglas de negocio del Modelo Dependency
     *
     * @return
     */
    private boolean isDependencyValid() {
        // RN1: campos no vacíos
        if (TextUtils.isEmpty(edName.getText().toString())) {
            showError(getString(R.string.errNameEmpty));
            return false;
        }

        if (TextUtils.isEmpty(edShortName.getText().toString())) {
            showError(getString(R.string.errShortNameEmpty));
            return false;
        }

        if (TextUtils.isEmpty(edDescription.getText().toString())) {
            showError(getString(R.string.errDescriptionEmpty));
            return false;
        }

        return true;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_dependency_add, container, false);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            listener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }
}