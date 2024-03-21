package com.example.coinnest;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class SettingActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting); // Ensure you have a corresponding layout file
        ListView listView = findViewById(R.id.myListView2); // Use findViewById directly on the Activity
        String[] names = {"Notification", "Credits", "Term of use", "Logout"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, names); // Use 'this' instead of 'getContext()' if you're inside an Activity
        listView.setAdapter(adapter);
    }

}

