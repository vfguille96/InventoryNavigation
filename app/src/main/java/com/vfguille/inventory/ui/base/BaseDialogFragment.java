package com.vfguille.inventory.ui.base;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.vfguille.inventory.R;

public class BaseDialogFragment extends DialogFragment {
    public static final String TITLE = "title";
    public static final String MESSAGE = "message";
    public static final String TAG = "baseDialogFragment";

    //  Método callback del listener del DialogFragment
    //  Cuando se acepta
    public interface OnFinishDialogListener {
        void onFinishDialog();
    }


    public static BaseDialogFragment newInstance(Bundle bundle) {
        BaseDialogFragment dialogFragment = new BaseDialogFragment();
        if (bundle != null)
            dialogFragment.setArguments(bundle);
        return dialogFragment;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        String title = getArguments().getString(TITLE);
        String message = getArguments().getString(MESSAGE);

        // Se crea el diálogo con el patrón CREATOR
        MaterialAlertDialogBuilder materialAlertDialogBuilder = new MaterialAlertDialogBuilder(getActivity());
        materialAlertDialogBuilder.setTitle(title).setMessage(message).setPositiveButton(getString(android.R.string.yes),
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        OnFinishDialogListener listener = (OnFinishDialogListener) getTargetFragment();
                        listener.onFinishDialog();
                    }
                });
        materialAlertDialogBuilder.setNegativeButton(getString(android.R.string.no),
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
        return materialAlertDialogBuilder.create();
    }
}