package edu.wsu.myapplication;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText usernameInput;
    EditText passwordInput;
    Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameInput = findViewById(R.id.usernameInput);
        passwordInput = findViewById(R.id.passwordInput);
        loginButton = findViewById(R.id.loginButton); // Ensure this ID matches your layout XML

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameInput.getText().toString().trim();
                String password = passwordInput.getText().toString().trim();

                // Directly call logInAuthorization from Database class
                Database database = new Database(getApplicationContext());
                database.logInAuthorization(username, password, new Database.MySQLAccessResponseListener() {
                    @Override
                    public void onResponse(String response) {
                        if ("1".equals(response.trim())) {
                            Toast.makeText(MainActivity.this, "Login Successful.", Toast.LENGTH_SHORT).show();
                            // Navigate to another activity or update UI accordingly
                        } else {
                            Toast.makeText(MainActivity.this, "Login Failed.", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onError(String message) {
                        Toast.makeText(MainActivity.this, "Error: " + message, Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}
