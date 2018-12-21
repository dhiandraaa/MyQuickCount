package com.dicoding.dhiandraaa.myquickcount;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FormPilPres extends AppCompatActivity implements View.OnClickListener {

    EditText Alamat;
    TextView tvNama,tvNIK, tvAlamat, tvTPU;
    Button Simpan;
    private FirebaseDatabase fb;
    SharedPreferences prf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_pil_pres);

        Alamat = (EditText)findViewById(R.id.input_alamat);

        prf = getSharedPreferences("user_details", MODE_PRIVATE);
        tvNama = (TextView)findViewById(R.id.hasil_nama);
        tvNama.setText(prf.getString("username", null));
        tvNIK = (TextView)findViewById(R.id.hasil_nik);
        tvNIK.setText(prf.getString("password", null));
        tvAlamat = (TextView)findViewById(R.id.hasil_alamat);
        tvTPU = (TextView)findViewById(R.id.hasil_tpu);
        tvTPU.setText(prf.getString("TPU", null));

        Simpan = (Button)findViewById(R.id.simpan_button);
        Simpan.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.simpan_button) {
            String FrAlamat = Alamat.getText().toString();

            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference myRef = database.getReference("Alamat");

            myRef.setValue(FrAlamat);

            Toast.makeText(this, "Berhasil Menyimpan", Toast.LENGTH_LONG).show();
            tvNama.setText(prf.getString("username", null));
            // tvNama.setText(nama);
            tvNIK.setText(prf.getString("password", null));
            // tvNIK.setText(nik);
            String alamat = Alamat.getText().toString();
            tvAlamat.setText(alamat);
            tvTPU.setText(prf.getString("TPU", null));
            // tvTPU.setText(tpu);
        }
    }
}
