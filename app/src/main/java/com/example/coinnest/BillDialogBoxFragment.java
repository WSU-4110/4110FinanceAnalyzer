package com.example.coinnest;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class BillDialogBoxFragment extends DialogFragment {

    private EditText editTextBillName;
    private EditText editTextAmount;
    private EditText editTextDueDate;

    public interface AddBillListener {
        void onAddBill(String billName, String amount, String dueDate);
    }

    private AddBillListener listener;

    public BillDialogBoxFragment() {
    }

    public void setAddBillListener(AddBillListener listener) {
        this.listener = listener;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_addbill, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        editTextBillName = view.findViewById(R.id.editTextBillName);
        editTextAmount = view.findViewById(R.id.editTextAmount);
        editTextDueDate = view.findViewById(R.id.editTextDueDate);

        Button buttonAddBill = view.findViewById(R.id.buttonAddBill);
        buttonAddBill.setOnClickListener(v -> {
            String billName = editTextBillName.getText().toString();
            String amount = editTextAmount.getText().toString();
            String dueDate = editTextDueDate.getText().toString();

            if (listener != null) {
                listener.onAddBill(billName, amount, dueDate);
            }

            dismiss();
        });
    }
}
