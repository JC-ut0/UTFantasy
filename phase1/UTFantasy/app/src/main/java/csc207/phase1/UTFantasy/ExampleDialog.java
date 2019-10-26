package csc207.phase1.UTFantasy;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatDialogFragment;

import csc207.phase1.UTFantasy.Activities.LoginActivity;
import csc207.phase1.UTFantasy.Activities.ShopActivity;
import csc207.phase1.UTFantasy.Products.Product;

public class ExampleDialog extends AppCompatDialogFragment {

    private EditText editTextAmount;
    private TextView textView;
    private ExampleDialogListener listener;

    //    private TextView notice;
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
        textView = view.findViewById(R.id.potion_amount);
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

    public interface ExampleDialogListener {
        void applyTexts(String amount);
    }
}
