package com.dicoding.dhiandraaa.myquickcount;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.rengwuxian.materialedittext.MaterialEditText;

public class CountPres extends AppCompatActivity {
    private Button btnsubmit;
    private MaterialEditText jml_suara,jml_suara2,tdkSah;
    private DatabaseReference database;

    private static final String TAG = "Presiden";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count_pres);

        setTitle("Form Presiden");

        database = FirebaseDatabase.getInstance().getReference();

        jml_suara = (MaterialEditText) findViewById(R.id.jml_suara);
        jml_suara2 = (MaterialEditText) findViewById(R.id.jml_suara2);
        tdkSah = (MaterialEditText) findViewById(R.id.tdk_sah);

        btnsubmit = (Button) findViewById(R.id.submit_button);
        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Sjml1 = jml_suara.getText().toString();
                String Sjml2 = jml_suara2.getText().toString();
                String StdkSah = tdkSah.getText().toString();

                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("Calon1");
                DatabaseReference myRef2 = database.getReference("Calon2");
                DatabaseReference myRef3 = database.getReference("TidakSah");

                myRef.setValue(Sjml1);
                myRef2.setValue(Sjml2);
                myRef3.setValue(StdkSah);

                Intent backPres = new Intent(CountPres.this, Pilpres.class);
                backPres.putExtra("data1", jml_suara.getText().toString());
                backPres.putExtra("data2", jml_suara2.getText().toString());
                backPres.putExtra("data3", tdkSah.getText().toString());
                startActivity(backPres);
            }
        });
    }

   /* private void submitSuara (presiden presiden) {
        database.child("presiden")
                .push()
                .setValue(presiden)
                .addOnSuccesListener(this,(OnSuccessListener)(aVoid)->{
                    loading.dismiss();
                    jml_suara.setText("");
                    jml_suara2.setText("");
                    tdkSah.setText("");

                    Toast.makeText(CountPres.this,
                            "Data Berhasil Ditambahkan",
                            Toast.LENGTH_SHORT).show();
                })
    }*/
}
    /*
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.submit_button) {
            if (!)
            Snackbar.make(findViewById(R.id.submit_button), "Data berhasil ditambahkan", Snackbar.LENGTH_LONG).show();
            FirebaseDatabase database = FirebaseDatabase.getInstance().;
            DatabaseReference getReference;

            String getCalon1 = jml_suara.getText().toString();
            String getCalon2 = jml_suara2.getText().toString();

        }
    }


    public static Intent getActIntent(Pilpres pilpres) {
            // kode untuk pengambilan Intent
            return new Intent(pilpres, CountPres.class);

    }

    private void submitSuara(Pilpres presiden) {
        database.child("presiden").push().setValue(presiden).addOnSuccessListener(this, new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                jml_suara.setText("");
                jml_suara2.setText("");
                Snackbar.make(findViewById(R.id.submit_button), "Data berhasil ditambahkan", Snackbar.LENGTH_LONG).show();
            }
        });
    }

    public static Intent getActIntent(Activity activity) {
        // kode untuk pengambilan Intent
        return new Intent(activity, CountPres.class);
    }
    */

