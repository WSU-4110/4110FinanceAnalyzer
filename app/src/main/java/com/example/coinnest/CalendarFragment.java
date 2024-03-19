
/*Jordan's Code*/

package com.example.coinnest;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class CalendarFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        return inflater.inflate(R.layout.fragment_calendar, container, false);
    }
}
/*


package com.example.coinnest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class CalendarFragment extends AppCompatActivity implements View.OnClickListener {

    Button btnDatePicker;
    TextView txtDate;
    private int sYear, sMonth, sDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDatePicker = (Button) findViewById(R.id.btn_pickdate);
        txtDate = (TextView)findViewById(R.id.txtview_showdate);

        btnDatePicker.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if (v == btnDatePicker) {
            final  Calendar calendar = Calendar.getInstance();
            sYear = calendar.get(Calendar.YEAR);
            sMonth = calendar.get(Calendar.MONTH);
            sDay = calendar.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                    //set the date here
                    sYear = i;
                    sMonth = i1;
                    sDay = i2;
                    txtDate.setText((sMonth + 1) + "/" + sDay + "/" + sYear);
                }
            }, sYear, sMonth, sDay);

            datePickerDialog.show();
        }
    }


}
*/
