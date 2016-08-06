package com.smartexam.germanium.smartexam;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by home on 8/1/2016.
 */

public class RegisterActivity extends AppCompatActivity {

    Toolbar toolbar;
    Button btnRegister;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        init();
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }

    private void init() {

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        btnRegister = (Button) findViewById(R.id.btnRegister);
    }

    public void btnRegister(View view) {
        Intent in = new Intent(this, NavActivity.class);
        startActivity(in);
        this.finish();
    }

    public void Login(View view) {
        Intent in = new Intent(this, LoginActivity.class);
        startActivity(in);
        this.finish();
    }

    public void ClickForgot(View view) {
        Intent in = new Intent(this, ForgotActivity.class);
        startActivity(in);
        this.finish();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
