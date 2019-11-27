package com.example.login;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.VolleyError;

import org.json.JSONException;
import org.json.JSONObject;

public class Registro extends AppCompatActivity implements View.OnClickListener
{
    protected RequestQueue fRequestQueue;
    private VolleyS volley;

    String url = "http://home4.uttics.com/api/registro";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registro);

        volley = VolleyS.getInstance(this.getApplicationContext());
        fRequestQueue = volley.getRequestQueue();
    }
    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.btnRegister:
                Registrarse();
                Clear();
                break;
            case R.id.link_to_login:
                Login();
                break;
        }
    }

    private void Login()
    {
        Intent it=new Intent(this,MainActivity.class);
        startActivity(it);
    }


    private void Registrarse(){
        final JSONObject data = new JSONObject();
        EditText name=findViewById(R.id.txtUserName);
        EditText email=findViewById(R.id.txtEmail);
        EditText pass=findViewById(R.id.txtPass);

        try {
            data.put("name", name.getText());
            data.put("email",email.getText() );
            data.put("password",pass.getText());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        JsonObjectRequest jsonObjectRequest =new JsonObjectRequest(Request.Method.POST, url, data, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Toast.makeText(Registro.this,"Se Agrego correctamente",Toast.LENGTH_SHORT).show();
            }
        },new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("OnErrorResponse1: ", error.toString());
            }
        });
        fRequestQueue.add(jsonObjectRequest);
    }

    public void Clear()
    {
        EditText name=findViewById(R.id.txtUserName);
        EditText email=findViewById(R.id.txtEmail);
        EditText pass=findViewById(R.id.txtPass);
        name.setText("");
        email.setText("");
        pass.setText("");
    }
}
