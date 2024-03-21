package com.example.coinnest;

import android.app.AlertDialog;
import android.graphics.Color;
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
import java.util.Arrays;
import java.util.List;

public class BillPageFragment extends Fragment {
    private List<String> billsList = new ArrayList<String>();
    private ListView upcomingBillsListView;
    private Button buttonAddBill;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bill, container, false);

        buttonAddBill = view.findViewById(R.id.buttonAddBill);
        buttonAddBill.setOnClickListener(v -> showAddBillDialog());


        ListView billsListView = view.findViewById(R.id.upcomingBillsListView);
        

        ArrayAdapter<String> billsAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, billsList);
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
            String newBill = billName + ": $" + billAmount + " Due Date: " + dueDate;
            billsList.add(newBill);

            // Update the ListView
            updateListView();
        });

        builder.setNegativeButton("Cancel", (dialog, which) -> dialog.cancel());

        AlertDialog dialog = builder.create();
        dialog.show();
    }
    private void updateListView() {
        ListView billsListView = getView().findViewById(R.id.upcomingBillsListView); // Make sure this ID matches your layout
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, billsList);
        billsListView.setAdapter(adapter);
    }

}
