package com.dicoding.dhiandraaa.myquickcount;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class Pilpres extends AppCompatActivity {
    private TextView jmlSuara1, jmlSuara2, tdkSah, tvSuara1, tvSuara2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pilpres);

        setTitle("Pemilihan Presiden");

        jmlSuara1 = (TextView) findViewById(R.id.tv_jml_1);
        jmlSuara2 = (TextView) findViewById(R.id.tv_jml_2);
        tvSuara1 = (TextView) findViewById(R.id.tv_suara_1);
        tvSuara2 = (TextView) findViewById(R.id.tv_suara_2);
        tdkSah = (TextView) findViewById(R.id.tv_tdk_sah);

        FloatingActionButton fab = findViewById(R.id.fab_pilpres);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Statement disini akan dijalankan saat FAB di Klik
                // startActivity(CountPres.getActIntent(Pilpres.this));
                Intent countPres = new Intent(Pilpres.this, CountPres.class);
                startActivity(countPres);
            }
        });

        jmlSuara1.setText(getIntent().getStringExtra("data1"));
        jmlSuara2.setText(getIntent().getStringExtra("data2"));
        tdkSah.setText(getIntent().getStringExtra("data3"));

    }
}
