package id.dila.mod_3;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 * Created by dilacim on 3/12/2017.
 */

public class StudiKasusActivity extends AppCompatActivity {
    EditText dobPicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studi_kasus);

        dobPicker = (EditText) findViewById(R.id.dobPicker);

        dobPicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar newCalendar = Calendar.getInstance();
                DatePickerDialog datePickerDialog = new DatePickerDialog(StudiKasusActivity.this, new DatePickerDialog.OnDateSetListener() {                         public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                    Calendar newDate = Calendar.getInstance();
                    newDate.set(year, monthOfYear, dayOfMonth);
                    SimpleDateFormat dateFormatter = new SimpleDateFormat("dd MMMM yyyy", Locale.US);
                    Toast.makeText(StudiKasusActivity.this,dateFormatter.format(newDate.getTime()),Toast.LENGTH_SHORT).show();
                }
                },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
                datePickerDialog.show();
            }
        });
    }
}
