package sg.edu.rp.c346.id20010021.demo_time_and_date_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    DatePicker dp;
    TimePicker tp;
    Button btndisplaydate;
    Button btndisplaytime;
    Button reset;
    TextView tvDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dp=findViewById(R.id.dp);
        tp=findViewById(R.id.tp);
        btndisplaydate=findViewById(R.id.btndisplaydate);
        btndisplaytime=findViewById(R.id.btndisplaytime);
        reset=findViewById(R.id.reset);
        tvDisplay=findViewById(R.id.tvDisplay);


        btndisplaytime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg="Time is ";
                int hour=tp.getCurrentHour();
                int min=tp.getCurrentMinute();
                msg=msg+hour+":"+min;
                tvDisplay.setText(msg);
            }
        });

        btndisplaydate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg="Date is ";
                int year=dp.getYear();
                int month=dp.getMonth();
                int dayOM=dp.getDayOfMonth();
                dp.updateDate(year, month, dayOM);
                tvDisplay.setText(msg);
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int hour=12;
                int min=00;
                int month=1;
                int day=1;
                int year=2020;
                dp.updateDate(year, month, day);
                tp.setCurrentHour(hour);
                tp.setCurrentMinute(min);
            }
        });


    }
}