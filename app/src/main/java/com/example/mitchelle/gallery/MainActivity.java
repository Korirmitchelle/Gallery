package com.example.mitchelle.gallery;

import android.content.DialogInterface;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;



public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    CollapsingToolbarLayout collapsingToolbarLayout;
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    FloatingActionButton fab;
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupNavigationView();
        setupCollapsingToolbarLayout();
        setupToolbar();
        setupTablayout();
        setupToolbar();
    }
    private void setupCollapsingToolbarLayout(){
        collapsingToolbarLayout=(CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        if (collapsingToolbarLayout!=null){
            collapsingToolbarLayout.setTitle(toolbar.getTitle());
        }
    }
    private void setupTablayout(){
        tabLayout=(TabLayout)  findViewById(R.id.tabLayout);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.addTab(tabLayout.newTab().setText("Tab1"));
        tabLayout.addTab(tabLayout.newTab().setText("Tab2"));
        tabLayout.addTab(tabLayout.newTab().setText("Tab3"));
        tabLayout.addTab(tabLayout.newTab().setText("Tab4"));



    }
    private void setupNavigationView(){
        drawerLayout=(DrawerLayout) findViewById(R.id.drawer_layout);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;

        }
        return super.onOptionsItemSelected(item);
    }

    private void setupFab(){
        fab=(FloatingActionButton)findViewById(R.id.fab);
        fab.setOnClickListener(this);
    }
    private void setupToolbar(){
        Toolbar toolbar=(Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //show menu
        final ActionBar ab=getSupportActionBar();
        ab.setDisplayShowHomeEnabled(true);
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setHomeAsUpIndicator(R.drawable.ic_menu);
    }
    public  void onClick(View view){
        if ( view.getId()==R.id.fab){
            Snackbar
                    .make(findViewById(R.id.rootLayout),"Snackbar", Snackbar.LENGTH_LONG)
                    .setAction("Action",this)
                    .show();

        }
    }
}
