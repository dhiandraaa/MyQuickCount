package com.dicoding.dhiandraaa.myquickcount;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.rengwuxian.materialedittext.MaterialEditText;

public class CountLeg extends AppCompatActivity implements View.OnClickListener {

    private Button btnSubmit;
    private MaterialEditText s1,s2,s3,s4,s5;
    private DatabaseReference database;

    private static final String TAG = "Legislatif";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count_leg);

        setTitle("Form Legislatif");

        database = FirebaseDatabase.getInstance().getReference();

        s1 = (MaterialEditText) findViewById(R.id.partai1);
        s2 = (MaterialEditText) findViewById(R.id.partai2);
        s3 = (MaterialEditText) findViewById(R.id.partai3);
        s4 = (MaterialEditText) findViewById(R.id.partai4);
        s5 = (MaterialEditText) findViewById(R.id.partai5);

        btnSubmit= (Button) findViewById(R.id.submit_button);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String SS1 = s1.getText().toString();
                String SS2 = s2.getText().toString();
                String SS3 = s3.getText().toString();
                String SS4 = s4.getText().toString();
                String SS5 = s5.getText().toString();

                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("Partai1");
                DatabaseReference myRef2 = database.getReference("Partai2");
                DatabaseReference myRef3 = database.getReference("Partai3");
                DatabaseReference myRef4 = database.getReference("Partai4");
                DatabaseReference myRef5 = database.getReference("Partai5");

                myRef.setValue(SS1);
                myRef2.setValue(SS2);
                myRef3.setValue(SS3);
                myRef4.setValue(SS4);
                myRef5.setValue(SS5);

                Intent backPres = new Intent(CountLeg.this, Pileg.class);
                backPres.putExtra("data1", s1.getText().toString());
                backPres.putExtra("data2", s2.getText().toString());
                backPres.putExtra("data3", s3.getText().toString());
                backPres.putExtra("data4", s4.getText().toString());
                backPres.putExtra("data5", s5.getText().toString());
                startActivity(backPres);
            }
        });
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.submit_button) {
            Snackbar.make(findViewById(R.id.submit_button), "Data berhasil ditambahkan", Snackbar.LENGTH_LONG).show();
        }
    }
}
