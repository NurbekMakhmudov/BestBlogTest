package uz.nursoft.nurbek.makhmudov.kurs.bestblogtest;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import android.support.design.widget.FloatingActionButton;

import android.support.v7.app.AlertDialog;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.WindowManager;
import android.widget.Toast;

import uz.nursoft.nurbek.makhmudov.kurs.bestblogtest.app_locale.MyContextWrapperLanguage;
import uz.nursoft.nurbek.makhmudov.kurs.bestblogtest.fragments.FrBasic;
import uz.nursoft.nurbek.makhmudov.kurs.bestblogtest.retmet.RetMet;
import uz.nursoft.nurbek.makhmudov.kurs.bestblogtest.shp.ShP;

public class AcBasic extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(MyContextWrapperLanguage.wrap(newBase, ShP.getInstance(newBase).getLang()));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.ac_basic);

        firstConfig();
        frDefault();
    }

    private void firstConfig() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.acBasicToolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(getResources().getString(R.string.app_name));

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (ShP.getInstance(AcBasic.this).isServerReg()) {
                    startActivity(new Intent(AcBasic.this, AcWrite.class));
                } else {
                    startActivity(new Intent(AcBasic.this, AcAccount.class)
                            .putExtra("appData", "reg"));
                }
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);

        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            if (ShP.getInstance(this).isBackPressed()) {
                exitApp();
            } else {
                //when fragment need to back
                int count = getSupportFragmentManager().getBackStackEntryCount();
                if (count == 0) {
                    exitApp();
                } else {
                    getSupportFragmentManager().popBackStack();
                }
            }
        }
    }

    private void exitApp() {
        new AlertDialog.Builder(this)
                .setMessage(getResources().getString(R.string.exit_the_program))
                .setCancelable(true)
                .setPositiveButton(getResources().getString(R.string.yes), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        finish();
                    }
                })
                .setNegativeButton(getResources().getString(R.string.no), null)
                .show();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.ac_basic_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_search) {
            Toast.makeText(this, "search", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.action_account) {

            if (ShP.getInstance(this).isServerReg()) {
                startActivity(new Intent(this, AcAccount.class)
                        .putExtra("appData", "profile"));
            } else {
                startActivity(new Intent(this, AcAccount.class)
                        .putExtra("appData", "reg"));
            }


        } else if (id == R.id.action_share) {
            Toast.makeText(this, "share", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.action_rate) {
            Toast.makeText(this, "rate", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.action_settings) {
            Toast.makeText(this, "settings", Toast.LENGTH_SHORT).show();

        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_tools) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }


        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void frDefault() {
        RetMet.getInstance(this)
                .replaceFragment(getSupportFragmentManager(), new FrBasic(), R.id.acBasicContentConsL);
    }


}
