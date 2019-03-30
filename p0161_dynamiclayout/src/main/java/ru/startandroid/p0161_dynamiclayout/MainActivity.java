package ru.startandroid.p0161_dynamiclayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams layoutParams =
                new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        setContentView(linearLayout, layoutParams);

        LinearLayout.LayoutParams lpParams =
                new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        TextView tv = new TextView(this);
        tv.setText("Text view");
        tv.setLayoutParams(lpParams);
        linearLayout.addView(tv);

        Button button = new Button(this);
        button.setText("Button");
        linearLayout.addView(button, lpParams);
        //
        LinearLayout.LayoutParams leftMarginParams =
                new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        leftMarginParams.leftMargin = 50; //px

        Button button1 = new Button(this);
        button1.setText("Button1");
        linearLayout.addView(button1, leftMarginParams);
        //
        LinearLayout.LayoutParams rightGravityParams =
                new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        rightGravityParams.gravity = Gravity.RIGHT;

        Button button2 = new Button(this);
        button2.setText("Button2");
        linearLayout.addView(button2, rightGravityParams);

    }
}
