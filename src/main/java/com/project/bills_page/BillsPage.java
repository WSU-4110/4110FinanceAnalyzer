package com.project.bills_page;


import android.os.Bundle;
import android.view.View;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class BillsPage extends AppCompatActivity {

    private EditText editTextBillName;
    private EditText editTextDueDate;
    private EditText editTextAmount;
    private TextView textViewUpcomingBill;
    private List<Bill> billList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bill_page);

        editTextBillName = findViewById(R.id.editTextBillName);
        editTextAmount = findViewById(R.id.editTextAmount);
        editTextDueDate = findViewById(R.id.editTextDueDate);
        textViewUpcomingBill = findViewById(R.id.textViewUpcomingBill);

        billList = new ArrayList<>();

        displayUpcomingBill();
    }

    public void addBill(View view) {
        Log.d("BillsPage", "addBill method called");
        String billName = editTextBillName.getText().toString();
        String amount = editTextAmount.getText().toString();
        String dueDateString = editTextDueDate.getText().toString();

        // Parse the due date
        Date dueDate = parseDate(dueDateString);

        // TODO: Save the bill data to database)
        Bill newBill = new Bill(billName, amount, dueDate);
        billList.add(newBill);

        // Sort bills by due date
        billList.sort(Comparator.comparing(Bill::getDueDate));


        // Display the upcoming bill
        displayUpcomingBill();

        // Clear input fields
        editTextBillName.setText("");
        editTextAmount.setText("");
        editTextDueDate.setText("");
    }
    private void displayUpcomingBill() {
        Log.d("BillsPage", "Displaying upcoming bills.");
        if (!billList.isEmpty()) {
            Bill upcomingBill = billList.get(0);
            String upcomingBillText = "Upcoming Bill: " +
                    upcomingBill.getBillName() +
                    " - $" +
                    upcomingBill.getAmount() +
                    " (Due on " +
                    formatDate(upcomingBill.getDueDate()) +
                    ")";
            textViewUpcomingBill.setText(upcomingBillText);
        } else {
            textViewUpcomingBill.setText("No upcoming bills.");
        }
    }



    private Date parseDate(String dateString) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
            return dateFormat.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
            return new Date(); // Return current date if parsing fails
        }
    }

    private String formatDate(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM dd, yyyy", Locale.US);
        return dateFormat.format(date);
    }
}
