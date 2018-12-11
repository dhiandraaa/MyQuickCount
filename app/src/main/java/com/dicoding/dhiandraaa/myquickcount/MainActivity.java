package com.dicoding.dhiandraaa.myquickcount;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

/*
Dhiandra Adithya Agsatra 1617051108
Bisri Mustofa 1617051092
Andres Hidayat 1617051081

Kelas A
 */

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    String title = "Quick Count";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent fab = new Intent(MainActivity.this, FormPilPres.class);
                Snackbar.make(view, "Lengkapi Data", Snackbar.LENGTH_LONG).setAction("Action",null).show();
                startActivity(fab);
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    public void setActionBarTitle(String title) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.exit) {
            MainActivity.this.finish();
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.brt_acara) {
            Intent berita  = new Intent(MainActivity.this, BeritaAcara.class);
            Toast.makeText(this, "Berita Acara Selected",Toast.LENGTH_SHORT).show();
            startActivity(berita);
        } else if (id == R.id.nav_pileg) {
            Intent pileg  = new Intent(MainActivity.this, Pileg.class);
            Toast.makeText(this, "Pemilihan Legislatif Selected",Toast.LENGTH_SHORT).show();
            startActivity(pileg);
        } else if (id == R.id.nav_pilpres) {
            Intent pilpres  = new Intent(MainActivity.this, Pilpres.class);
            Toast.makeText(this, "Pemilihan Presiden Selected",Toast.LENGTH_SHORT).show();
            startActivity(pilpres);
        } else if (id == R.id.nav_out) {
            Intent backLogin = new Intent(MainActivity.this, Login.class);
            Toast.makeText(this, "Logout Berhasil",Toast.LENGTH_SHORT).show();
            startActivity(backLogin);
            finish();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        setActionBarTitle(title);
        return true;
    }
}
