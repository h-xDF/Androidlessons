package ru.startandroid.p0191_simplecalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    final int MENU_RESET_ID = 1;
    final int MENU_QUIT_ID = 2;
    private final String errorMsg = "На ноль делить нельзя";

    EditText etNum1;
    EditText etNum2;

    Button btnAdd;
    Button btnSub;
    Button btnMult;
    Button btnDiv;

    TextView tvResult;
    String oper = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNum1 = findViewById(R.id.etNum1);
        etNum2 = findViewById(R.id.etNum2);
        btnAdd = findViewById(R.id.btnAdd);
        btnSub = findViewById(R.id.btnSub);
        btnMult = findViewById(R.id.btnMult);
        btnDiv = findViewById(R.id.btnDiv);
        tvResult = findViewById(R.id.tvResult);

        btnAdd.setOnClickListener(this);
        btnSub.setOnClickListener(this);
        btnMult.setOnClickListener(this);
        btnDiv.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        float result = 0;

        // empty space check
        if (TextUtils.isEmpty(etNum1.getText().toString()) ||
                TextUtils.isEmpty(etNum2.getText().toString())) {
            return;
        }

        float num1 = Float.parseFloat(etNum1.getText().toString());
        float num2 = Float.parseFloat(etNum2.getText().toString());

        switch (v.getId()) {
            case R.id.btnAdd:
                oper = "+";
                result = num1 + num2;
                break;
            case R.id.btnSub:
                oper = "-";
                result = num1 - num2;
                break;
            case R.id.btnMult:
                oper = "*";
                result = num1 * num2;
                break;
            case R.id.btnDiv:
                oper  = "/";
                result = num1 / num2;
                break;
        }
        if (Float.isInfinite(result) || Float.isNaN(result)) {
            tvResult.setText(errorMsg);
            Toast.makeText(this, errorMsg, Toast.LENGTH_LONG).show();
        } else {
            tvResult.setText(num1 + " " + oper + " " + num2 + " = " + result);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0,MENU_RESET_ID,0, "Reset");
        menu.add(0, MENU_QUIT_ID, 0, "Quit");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case MENU_RESET_ID:
                etNum1.setText("");
                etNum2.setText("");
                tvResult.setText("");
                break;
            case MENU_QUIT_ID:
                finish(); // close application
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
