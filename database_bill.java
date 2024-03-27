package edu.wsu.myapplication;

import android.content.Context;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import java.util.HashMap;
import java.util.Map;

public class Database {
    private RequestQueue queue;

    private static final String LOGIN_URL = "http://18.189.7.172/login.php";
	private static final String ADD_BILL_URL = "http://18.189.7.172/addBill.php";
   
    // Define URLs for other PHP scripts as needed

    public Database(Context context) {
        this.queue = Volley.newRequestQueue(context);
    }

    public interface MySQLAccessResponseListener {
        void onResponse(String response);
        void onError(String message);
    }

    // Method for login authorization
    public void logInAuthorization(final String username, final String password, final MySQLAccessResponseListener listener) {
        Map<String, String> params = new HashMap<>();
        params.put("username", username);
        params.put("password", password);

        StringRequest stringRequest = new StringRequest(Request.Method.POST, LOGIN_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        listener.onResponse(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        listener.onError(error.toString());
                    }
                }) {
            @Override
            protected Map<String, String> getParams() {
                return params;
            }
        };

        queue.add(stringRequest);
    }
		// Method for adding bill 
	 public void addBill(final String billName, final String amount, final String dueDate, final MySQLAccessResponseListener listener) {
        Map<String, String> params = new HashMap<>();
        params.put("billName", billName);
        params.put("amount", amount);
        params.put("dueDate", dueDate);

        StringRequest stringRequest = new StringRequest(Request.Method.POST, ADD_BILL_URL,
            new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    listener.onResponse(response);
                }
            },
            new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    listener.onError(error.toString());
                }
            }) {
            @Override
            protected Map<String, String> getParams() {
                return params;
            }
        };

    // Placeholder for the method to fetch summary
    public void fetchSummary(final String someParameter, final MySQLAccessResponseListener listener) {
        // Implementation goes here
    }

    // Placeholder for the method to get user information
    public void getUserInfo(final String username, final MySQLAccessResponseListener listener) {
        // Implementation goes here
    }
}