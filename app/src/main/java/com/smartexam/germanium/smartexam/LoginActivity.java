package com.smartexam.germanium.smartexam;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {


    TextView tvName;
    EditText edtUsername;
    EditText edtPassword;
    Button btnLogin;
    TextView tvTerm;
    TextView tvSignUp;
    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        init();

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }


    private void init() {

        tvName = (TextView) findViewById(R.id.tvName);
        edtUsername = (EditText) findViewById(R.id.edtUsername);
        edtPassword = (EditText) findViewById(R.id.edtPassword);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        tvTerm = (TextView) findViewById(R.id.tvTerm);
        tvSignUp = (TextView) findViewById(R.id.tvSignUp);
        toolbar = (Toolbar) findViewById(R.id.toolbar);

    }

    public void Login(View view) {
        Intent intent = new Intent(LoginActivity.this, NavActivity.class);
        startActivity(intent);
    }

    public void ClickSignUp(View view) {
        Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(intent);
    }

    public void ClickTerm(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
        startActivity(browserIntent);
    }

}
