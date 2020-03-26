package com.example.myfragment2;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {
    private SharedPreferenceConfig sharedPreferenceConfig;
    EditText username;
    EditText password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = findViewById(R.id.firstname) ;
        password = findViewById(R.id.lastname);
        sharedPreferenceConfig = new SharedPreferenceConfig(getApplicationContext());

        if(sharedPreferenceConfig.read_login_status()){
            startActivity(new Intent(this, SecondFragment.class));
            finish();
        }
    }

    public void Login(View view) {
        String uname = username.getText().toString();
        String pass = password.getText().toString();

        if (uname.equals(getResources().getString(R.string.username))  && pass.equals(getResources().getString(R.string.password))){
            startActivity(new Intent(this, SecondFragment.class));
            sharedPreferenceConfig.login_status(true);
            finish();
        }
        else{
            Toast.makeText(this, "Not Valid", Toast.LENGTH_SHORT).show();
            username.setText("");
            password.setText("");
        }
    }
}
