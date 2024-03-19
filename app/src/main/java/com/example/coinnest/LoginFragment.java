package com.example.coinnest;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginFragment extends Fragment {

    private EditText usernameInput;
    private EditText passwordInput;
    private Button loginButton;

    public LoginFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        usernameInput = view.findViewById(R.id.usernameInput);
        passwordInput = view.findViewById(R.id.passwordInput);
        loginButton = view.findViewById(R.id.loginButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String username = usernameInput.getText().toString().trim();
                final String password = passwordInput.getText().toString().trim();

                // Use the Database class to authorize login
                Database database = new Database(getActivity().getApplicationContext());
                database.logInAuthorization(username, password, new Database.MySQLAccessResponseListener() {
                    @Override
                    public void onResponse(String response) {
                        if ("1".equals(response.trim())) {
                            Toast.makeText(getActivity(), "Login Successful.", Toast.LENGTH_SHORT).show();
                            // Notify the MainActivity that login was successful
                            ((MainActivity)getActivity()).onLoginSuccess();
                        } else {
                            Toast.makeText(getActivity(), "Login Failed.", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onError(String message) {
                        Toast.makeText(getActivity(), "Error: " + message, Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        return view;
    }
}
