package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.link_to_register:
                Registro();
                break;
        }
    }

    public void Registro()
    {
        Intent it = new Intent(this,Registro.class);
        startActivity(it);
    }
}
