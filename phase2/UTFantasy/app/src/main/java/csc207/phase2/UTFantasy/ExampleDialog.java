package csc207.phase2.UTFantasy;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatDialogFragment;

public class ExampleDialog extends AppCompatDialogFragment {
    /**
     * the EditText called editTextAmount
     */
    private EditText editTextAmount;
    /**
     * the ExampleDialogListener
     */
    private ExampleDialogListener listener;

    /** Create a dialogue*/
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.activity_shop_dialog, null);
        builder.setView(view)
                .setTitle("Purchase")
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setPositiveButton("Buy", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String amount = editTextAmount.getText().toString();
                        listener.applyTexts(amount);
                    }
                });


        editTextAmount = view.findViewById(R.id.amount);
        return builder.create();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            listener = (ExampleDialogListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() +
                    "must implement ExampleDialogListener");
        }
    }

    /**
     * the interface of ExampleDialogListener.
     */
    public interface ExampleDialogListener {
        void applyTexts(String amount);
    }
}
