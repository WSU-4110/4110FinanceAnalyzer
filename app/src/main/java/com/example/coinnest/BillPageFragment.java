package com.example.coinnest;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.text.InputType;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class BillPageFragment extends Fragment {
    private Button buttonAddBill;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bill, container, false);

        buttonAddBill = view.findViewById(R.id.buttonAddBill);
        buttonAddBill.setOnClickListener(v -> showAddBillDialog());

        return view;
    }

    private void showAddBillDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Add Bill");

        // Container for our EditTexts
        LinearLayout layout = new LinearLayout(getActivity());
        layout.setOrientation(LinearLayout.VERTICAL);

        // Create EditText for bill name
        final EditText billNameInput = new EditText(getActivity());
        billNameInput.setInputType(InputType.TYPE_CLASS_TEXT);
        billNameInput.setHint("Bill Name");
        layout.addView(billNameInput); // Add EditText to the layout

        // Create EditText for bill amount
        final EditText billAmountInput = new EditText(getActivity());
        billAmountInput.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        billAmountInput.setHint("Bill Amount");
        layout.addView(billAmountInput); // Add EditText to the layout

        // Create EditText for due date
        final EditText billDueDateInput = new EditText(getActivity());
        billDueDateInput.setInputType(InputType.TYPE_CLASS_DATETIME);
        billDueDateInput.setHint("Due Date (YYYY-MM-DD)");
        layout.addView(billDueDateInput); // Add EditText to the layout

        builder.setView(layout); // Set the layout with EditTexts as the view of the dialog

        // Set up the buttons
        builder.setPositiveButton("OK", (dialog, which) -> {
            String billName = billNameInput.getText().toString();
            String billAmount = billAmountInput.getText().toString();
            String dueDate = billDueDateInput.getText().toString();

            // Here, you would handle saving this information, possibly creating a Bill object and adding it to a list
            // For now, just log or use a placeholder action
            // Log.d("BillPageFragment", "Bill Added: Name: " + billName + ", Amount: " + billAmount + ", Due Date: " + dueDate);
        });

        builder.setNegativeButton("Cancel", (dialog, which) -> dialog.cancel());

        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
