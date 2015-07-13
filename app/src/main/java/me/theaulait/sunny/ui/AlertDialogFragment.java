package me.theaulait.sunny.ui;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;

import me.theaulait.sunny.R;

/**
 * Created by c4q-vanice on 6/15/15.
 */
public class AlertDialogFragment extends android.support.v4.app.DialogFragment{
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        // AlertDialog has three buttons for us to set: positive, negative and neutral.

        Context context = getActivity();
        AlertDialog.Builder builder = new AlertDialog.Builder(context) // initial a builder but have not created yet.
                .setTitle(context.getString(R.string.error_title))
                .setMessage(context.getString(R.string.error_message)) // Negative
                .setPositiveButton(context.getString(R.string.error_okay_button), null); // This is for the user to press okay to the message. Null is used, instead of OnClickListener,  when I do not want the button to perform any task.

        AlertDialog dialog = builder.create(); // This is where the builder is created and named dialog
        return dialog;
    }
}
