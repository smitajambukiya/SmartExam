package com.smartexam.germanium.smartexam;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

/**
 * Created by home on 7/31/2016.
 */

public class InstructionActivity extends AppCompatActivity {

    Toolbar toolbar;
    Button btnStart;
    CheckBox checkBox;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instruction);

        init();

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }

    private void init() {

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        btnStart = (Button) findViewById(R.id.btnStart);
        checkBox = (CheckBox) findViewById(R.id.checkBox);
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

    public void btnStart(View view) {
        Intent in = new Intent(this, Qustionary.class);
        startActivity(in);
        this.finish();
    }
}
