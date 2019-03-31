package ru.startandroid.p0181_dynamiclayout3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {
    private SeekBar sbWeight;
    private Button btn1;
    private Button btn2;
    private LinearLayout.LayoutParams lParams1;
    private LinearLayout.LayoutParams lParams2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sbWeight = findViewById(R.id.sbWeight);
        sbWeight.setOnSeekBarChangeListener(seekBarChangeListener);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);

        lParams1 = (LinearLayout.LayoutParams) btn1.getLayoutParams();
        lParams2 = (LinearLayout.LayoutParams) btn2.getLayoutParams();
    }

    SeekBar.OnSeekBarChangeListener seekBarChangeListener = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            int leftValue = progress;
            int rightValue = seekBar.getMax() - progress;

            lParams1.weight = leftValue;
            lParams2.weight = rightValue;

            // Вызывается в .setText()
            /*btn1.requestLayout();
            btn2.requestLayout();*/

            btn1.setText(String.valueOf(leftValue));
            btn2.setText(String.valueOf(rightValue));
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    };
}
