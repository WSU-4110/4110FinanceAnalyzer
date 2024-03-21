package com.example.coinnest;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.text.InputType;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

public class BillPageFragment extends Fragment {
    private List<Bill> billList = new ArrayList<>();
    private ListView upcomingBillsListView;
    private Button buttonAddBill;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bill, container, false);

        buttonAddBill = view.findViewById(R.id.buttonAddBill);
        buttonAddBill.setOnClickListener(v -> showAddBillDialog());


        ListView billsListView = view.findViewById(R.id.upcomingBillsListView);
        String[] bills = new String[]{
                "Credit Card: $30.00 Due Date: 04-12-2024",
                "Credit Card 2: $50.00 Due Date: 04-15-2024",
                "Mortgage: $1,500.00 Due Date: 04-20-2024",
                "Car Loan: $550.00 Due Date: 04-25-2024",
                "Student Loans: $1,000 Due Date: 04-30-2024"
        };
        ArrayAdapter<String> billsAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, bills);
        billsListView.setAdapter(billsAdapter);



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
        layout.addView(billNameInput);

        // Create EditText for bill amount
        final EditText billAmountInput = new EditText(getActivity());
        billAmountInput.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        billAmountInput.setHint("Bill Amount");
        layout.addView(billAmountInput);

        // Create EditText for due date
        final EditText billDueDateInput = new EditText(getActivity());
        billDueDateInput.setInputType(InputType.TYPE_CLASS_DATETIME);
        billDueDateInput.setHint("Due Date (MM-DD-YYYY)");
        layout.addView(billDueDateInput);

        builder.setView(layout);


        builder.setPositiveButton("OK", (dialog, which) -> {
            String billName = billNameInput.getText().toString();
            String billAmount = billAmountInput.getText().toString();
            String dueDate = billDueDateInput.getText().toString();

            // Code here for handling saving this information to database

        });

        builder.setNegativeButton("Cancel", (dialog, which) -> dialog.cancel());

        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
