package ru.startandroid.p0341_simplesqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    final String LOG_TAG = "myLogs";

    Button btnAdd, btnRead, btnClear, btnUpd, btnDel;
    EditText etName, etEmail, etID;

    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);

        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        etID = findViewById(R.id.etID);

        btnUpd = findViewById(R.id.btnUpd);
        btnDel = findViewById(R.id.btnDel);
        btnAdd = findViewById(R.id.btnAdd);
        btnRead = findViewById(R.id.btnRead);
        btnClear = findViewById(R.id.btnClear);

        btnUpd.setOnClickListener(this);
        btnDel.setOnClickListener(this);
        btnAdd.setOnClickListener(this);
        btnRead.setOnClickListener(this);
        btnClear.setOnClickListener(this);

        dbHelper = new DBHelper(this);
    }

    @Override
    public void onClick(View v) {
        ContentValues cv = new ContentValues(); // создаем объект для данных

        // получаем данные из полей ввода
        String name = etName.getText().toString();
        String email = etEmail.getText().toString();
        String id = etID.getText().toString();

        SQLiteDatabase db = dbHelper.getWritableDatabase(); // подключаемся к БД

        switch (v.getId()) {
            case R.id.btnUpd:
                if (id.equalsIgnoreCase("")) {
                    break; //todo надо вывести хотя бы тост?
                }
                Log.d(LOG_TAG, "--- Update mytable: ---");
                cv.put("name", name);
                cv.put("email", email);

                int updCount = db.update("mytable", cv, "id = ?",
                        new String[] { id });

                Log.d(LOG_TAG, "updated rows count = " + updCount);
                break;
            case R.id.btnDel:
                if (id.equalsIgnoreCase("")) {
                    break;
                }
                Log.d(LOG_TAG, "--- Delete from mytable: ---");
                int delCount = db.delete("mytable", "id = " + id, null);
                Log.d(LOG_TAG, "deleted rows count = " + delCount);
                break;
            case R.id.btnAdd:
                Log.d(LOG_TAG, "-- Insert in mytable: --");
                cv.put("name", name);
                cv.put("email", email);
                long rowID = db.insert("mytable", null, cv);
                Log.d(LOG_TAG, "row inserted, ID = " + rowID);
                break;
            case R.id.btnRead:
                Log.d(LOG_TAG, "-- rows in mytable: --");
                Cursor cursor = db.query("mytable", null, null, null, null, null, null);

                if (cursor.moveToFirst()) {

                    int idIndex = cursor.getColumnIndex("id");
                    int nameIndex = cursor.getColumnIndex("name");
                    int emailIndex = cursor.getColumnIndex("email");

                    do {
                        Log.d(LOG_TAG, "ID = " + cursor.getInt(idIndex) +
                                        ", name = " + cursor.getString(nameIndex) +
                                        ", email = " + cursor.getString(emailIndex));
                    } while (cursor.moveToNext());
                } else {
                    Log.d(LOG_TAG, "0 rows");
                }
                cursor.close();
                break;
            case R.id.btnClear:
                Log.d(LOG_TAG, "-- Clear mytable: --");
                int clearCount = db.delete("mytable", null, null);
                Log.d(LOG_TAG, "deleted rows count = " + clearCount);
                break;
        }
        dbHelper.close();
    }

    class DBHelper extends SQLiteOpenHelper {
        /**
         * change version DB ?
         * factory ??????
         */
        public DBHelper(Context context) {
            super(context, "myDB", null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            Log.d(LOG_TAG, "-- onCreate data base --");
            db.execSQL("create table mytable ("
                    + "id integer primary key autoincrement,"
                    + "name text,"
                    + "email text" + ");");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }
}

