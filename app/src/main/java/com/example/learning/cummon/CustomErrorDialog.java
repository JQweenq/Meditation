package com.example.learning.cummon;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class CustomErrorDialog extends DialogFragment {
    private final CharSequence textError;
    private final Context ctx;

    CustomErrorDialog(Context ctx, CharSequence textError) {
        this.textError = textError;
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(ctx)
                .setTitle("Ошибка!")
                .setNeutralButton("Ok", null)
                .setMessage(textError);

        Dialog dialog = builder.create();

        return dialog;
    }
}
