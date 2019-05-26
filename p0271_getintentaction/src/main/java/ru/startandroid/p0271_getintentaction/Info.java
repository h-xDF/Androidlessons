package ru.startandroid.p0271_getintentaction;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Info extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        TextView tvDate = findViewById(R.id.tvInfo);

        Intent intent = getIntent();
        String action = intent.getAction();
        String format = "", textInfo = "";

        if (action.equals("ru.startandroid.intent.action.showtime")) {
            format = "HH:mm:ss";
            textInfo = "Time: ";
        } else if (action.equals("ru.startandroid.intent.action.showdate")) {
            format = "dd.MM.yyyy";
            textInfo = "Date:";
        }

        SimpleDateFormat sdf = new SimpleDateFormat(format);
        String dataTime = sdf.format(new Date(System.currentTimeMillis()));

        tvDate.setText(textInfo + dataTime);
    }
}
