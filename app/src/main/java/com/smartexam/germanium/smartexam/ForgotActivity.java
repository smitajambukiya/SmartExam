package com.smartexam.germanium.smartexam;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by home on 8/1/2016.
 */

public class ForgotActivity extends AppCompatActivity {

    EditText edtEmail;
    Button btnForGotPassword;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgotpassword);

        init();

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    public void forGotPassword(View view) {
        this.finish();
    }

    private void init() {
        edtEmail = (EditText) findViewById(R.id.edtEmail);
        btnForGotPassword = (Button) findViewById(R.id.btnForgotPassword);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
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
