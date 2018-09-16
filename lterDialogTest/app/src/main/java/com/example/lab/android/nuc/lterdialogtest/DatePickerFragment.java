package com.example.lab.android.nuc.lterdialogtest;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;



public class DatePickerFragment extends DialogFragment{
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return new AlertDialog.Builder(getActivity())
                .setTitle(R.string.data_picker_title)
                .setPositiveButton(android.R.string.ok,null)
                .create();
    }
}
