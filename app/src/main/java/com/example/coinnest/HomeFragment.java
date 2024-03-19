/*Jordan's Code*/
package com.example.coinnest;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class HomeFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }
}




/*
package com.example.coinnest;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import com.google.android.material.card.MaterialCardView;

public class HomeFragment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MaterialCardView balanceCard = findViewById(R.id.balanceCard);
        balanceCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, OverviewActivity.class);
                startActivity(intent);
            }

        });

        MaterialCardView calendarCard = findViewById(R.id.calendarCard);
        calendarCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, OverviewActivity.class);
                startActivity(intent);
            }

        });

        MaterialCardView upcomingBillsCard = findViewById(R.id.upcomingBillsCard);
        upcomingBillsCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, OverviewActivity.class);
                startActivity(intent);
            }

        });



    }
}
*/