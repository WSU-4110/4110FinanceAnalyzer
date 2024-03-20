package com.example.coinnest;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class BillsPage extends AppCompatActivity implements BillDialogBoxFragment.AddBillListener {
    private TextView textViewUpcomingBill;
    private List<Bill> billList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_bill);

        textViewUpcomingBill = findViewById(R.id.textViewUpcomingBill);

        findViewById(R.id.buttonAddBill).setOnClickListener(v -> showAddBillDialog());
    }

    private void showAddBillDialog() {
        BillDialogBoxFragment dialogFragment = new BillDialogBoxFragment();
        dialogFragment.setAddBillListener(this);
        dialogFragment.show(getSupportFragmentManager(), "AddBillDialog");
    }

    @Override
    public void onAddBill(String billName, String amount, String dueDate) {
        Date dueDateParsed = parseDate(dueDate);
        Bill newBill = new Bill(billName, amount, dueDateParsed);
        billList.add(newBill);
        billList.sort(Comparator.comparing(Bill::getDueDate));
        displayUpcomingBill();
    }

    private void displayUpcomingBill() {
        if (!billList.isEmpty()) {
            Bill upcomingBill = billList.get(0);
            String upcomingBillText = "Upcoming Bill: " + upcomingBill.getBillName() + " - $" +
                    upcomingBill.getAmount() + " (Due on " + formatDate(upcomingBill.getDueDate()) + ")";
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
            return null; // Consider handling this case more gracefully
        }
    }

    private String formatDate(Date date) {
        if (date == null) return "N/A";
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM dd, yyyy", Locale.US);
        return dateFormat.format(date);
    }
}
