package com.dicoding.dhiandraaa.myquickcount;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.rengwuxian.materialedittext.MaterialEditText;

public class Pileg extends AppCompatActivity {
    private TextView tvpartai1, tvpartai2, tvpartai3, tvpartai4, tvpartai5;
    private MaterialEditText partai1, partai2, partai3, partai4, partai5;
    private Button btnSubmit;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pileg);

        setTitle("Pemilihan Legislatif");

        tvpartai1 = (TextView) findViewById(R.id.tv_partai1);
        tvpartai2 = (TextView) findViewById(R.id.tv_partai2);
        tvpartai3 = (TextView) findViewById(R.id.tv_partai3);
        tvpartai4 = (TextView) findViewById(R.id.tv_partai4);
        tvpartai5 = (TextView) findViewById(R.id.tv_partai5);

        FloatingActionButton fab = findViewById(R.id.fab_pileg);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Statement disini akan dijalankan saat FAB di Klik
                // startActivity(CountPres.getActIntent(Pilpres.this));
                Intent countLeg = new Intent(Pileg.this, CountLeg.class);
                startActivity(countLeg);
            }
        });
        tvpartai1.setText(getIntent().getStringExtra("data1"));
        tvpartai2.setText(getIntent().getStringExtra("data2"));
        tvpartai3.setText(getIntent().getStringExtra("data3"));
        tvpartai4.setText(getIntent().getStringExtra("data4"));
        tvpartai5.setText(getIntent().getStringExtra("data5"));
    }
}
