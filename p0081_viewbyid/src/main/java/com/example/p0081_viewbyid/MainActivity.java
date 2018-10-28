package com.example.p0081_viewbyid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //View myTextView = findViewById(R.id.myText);

        TextView myTextView = findViewById(R.id.myText);
        myTextView.setText("New text in TextView");

        Button myBtn = findViewById(R.id.myBtn);
        myBtn.setText("My button");
        myBtn.setEnabled(false);

        CheckBox myChb = findViewById(R.id.myCnb);
        myChb.setChecked(true);
    }
}
