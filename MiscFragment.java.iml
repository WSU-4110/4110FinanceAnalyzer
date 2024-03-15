package com.example.coinnest;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

public class MiscFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_shorts, container, false);

        // Settings button
        Button settingsButton = view.findViewById(R.id.settings_button);
        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Add code to open settings activity
                startActivity(new Intent(getActivity(), SettingsActivity.class));
            }
        });

        // Contact Us button
        Button contactUsButton = view.findViewById(R.id.contact_us_button);
        contactUsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Add code to open contact us page
                openContactUsPage();
            }
        });

        // Rate Us button
        Button rateUsButton = view.findViewById(R.id.rate_us_button);
        rateUsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Add code to open rate us page
                openRateUsPage();
            }
        });

        // Theme button
        Button themeButton = view.findViewById(R.id.theme_button);
        themeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Add code to change theme
                changeTheme();
            }
        });

        return view;
    }

    private void openContactUsPage() {
        // Add code to open contact us page (e.g., a web page or an activity)
        // Example: opening a webpage
        String url = "https://example.com/contact";
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }

    private void openRateUsPage() {
        // Add code to open rate us page (e.g., on Google Play)
        // Example: opening the Google Play Store page for the app
        String appPackageName = getActivity().getPackageName();
        try {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)));
        } catch (android.content.ActivityNotFoundException e) {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName)));
        }
    }

    private void changeTheme() {
        // Add code to change theme (e.g., switch between light and dark theme)
        // Example: toggling between light and dark theme
        // Note: You need to implement your own logic for changing the theme
    }
}
