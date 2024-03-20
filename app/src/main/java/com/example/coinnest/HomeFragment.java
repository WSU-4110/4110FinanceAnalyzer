/*Jordan's Code*/
package com.example.coinnest;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public class HomeFragment extends Fragment {

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ListView listView = view.findViewById(R.id.listBalances);

        TextView currentDateTextView = view.findViewById(R.id.currentDateTextView);
        String currentDate = new SimpleDateFormat("EEE, d MMM yyyy", Locale.getDefault()).format(new Date());
        currentDateTextView.setText(currentDate);

        // Apply the adapter to the ListView
        String[] items = new String[] {"Credit Card 1 = $234.22", "Credit Card 2: $567.23", "Mortgage: $80,500.00",
                "Car Loan: $35,000.00", "Student Loans: $20,000.00"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, items);
        listView.setAdapter(adapter);

        ListView billsListView = view.findViewById(R.id.upcomingBillsListView);
        String[] bills = new String[] {"Credit Card: $30.00", "Credit Card 2: $50.00",
                "Mortgage: $1,500.00" , "Car Loan: $550.00", "Student Loans: $1,000"};
        ArrayAdapter<String> billsAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, bills);
        billsListView.setAdapter(billsAdapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }
}



