package ru.startandroid.p0141_menuadv;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    CheckBox chb;
    
    /*public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu, menu);
        return super.onCreateOptionsMenu(menu);
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        // находим элемент
        tv = findViewById(R.id.textView);
        chb = findViewById(R.id.chbExtMenu);
    }

    //создание меню
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        menu.add(0,1,0, "add");
        menu.add(0,2,0, "edit");
        menu.add(0,3,3, "delete");
        menu.add(1,4,1, "copy");
        menu.add(1,5,2, "paste");
        menu.add(1,6,4, "exit");

        return super.onCreateOptionsMenu(menu);
    }

    //обновление меню
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        // пункты меню с ID группы = 1 видны, если в CheckBox стоит галка
        menu.setGroupVisible(1, chb.isChecked());

        return super.onPrepareOptionsMenu(menu);
    }

    //обработка нажатий
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        StringBuilder sb = new StringBuilder();

        //выводим в тексВью информацию о нажатом пункте
        sb.append("Item Menu");
        sb.append("\r\n groupId: " + String.valueOf(item.getGroupId()));
        sb.append("\r\n itemId: " + String.valueOf(item.getItemId()));
        sb.append("\r\n order: " + String.valueOf(item.getOrder()));
        sb.append("\r\n title: " + String.valueOf(item.getTitle()));
        tv.setText(sb);

        return super.onOptionsItemSelected(item);
    }
}
