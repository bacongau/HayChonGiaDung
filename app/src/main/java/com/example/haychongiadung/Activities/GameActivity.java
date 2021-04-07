package com.example.haychongiadung.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.haychongiadung.Database.DataBase;
import com.example.haychongiadung.Model.CauHoi;
import com.example.haychongiadung.Model.DapAn;
import com.example.haychongiadung.R;

import java.util.ArrayList;

public class GameActivity extends AppCompatActivity {
    String DATABASE_NAME = "cauhoi db.db";
    SQLiteDatabase database;

    ArrayList<CauHoi> cauHoiArrayList;
    ArrayList<DapAn> dapAnArrayList;
    CauhoiAdapter adapter;

    TextView tv_causo,tv_somang,tv_cauhoi;
    Button btn_chotdapan;
    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        anhxa();
        laycauhoi();
    }

    private void laycauhoi() {
        database = DataBase.initDatabase(GameActivity.this, DATABASE_NAME);
        Cursor cursor = database.rawQuery("SELECT * FROM Cauhoi", null);
        cauHoiArrayList.clear();
        for (int i = 0; i < cursor.getCount(); i++) {
            cursor.moveToPosition(i);
            int id = cursor.getInt(0);
            String cauhoi = cursor.getString(1);
            cauHoiArrayList.add(new CauHoi(id,cauhoi));
        }
        adapter.notifyDataSetChanged();

        Cursor cursor2 = database.rawQuery("SELECT * FROM Dapan", null);
        dapAnArrayList.clear();
        for (int i = 0; i < cursor.getCount(); i++) {
            cursor2.moveToPosition(i);
            String dapan1 = cursor.getString(0);
            String dapan2 = cursor.getString(1);
            String dapan3 = cursor.getString(2);
            String dapandung = cursor.getString(3);
            int id = cursor.getInt(4);
            dapAnArrayList.add(new DapAn(id,dapan1,dapan2,dapan3,dapandung));
        }
        adapter.notifyDataSetChanged();
    }

    private void anhxa() {
        tv_cauhoi = findViewById(R.id.tv_cauhoi);
        tv_somang = findViewById(R.id.tv_somang);
        tv_causo = findViewById(R.id.tv_causo);
        btn_chotdapan = findViewById(R.id.btn_chotdapan);
        rv = findViewById(R.id.rv_cacdapan);

        cauHoiArrayList = new ArrayList<>();
        dapAnArrayList = new ArrayList<>();
    }
}