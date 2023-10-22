package com.abid.prefrenceass;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.Toast;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    EditText e1,e2;
    CheckBox ch;
    Button btn;
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1 = findViewById(R.id.editTextText);
        e2 = findViewById(R.id.editTextText2);
        ch = findViewById(R.id.checkBox);
        btn = findViewById(R.id.button);
        pref = getSharedPreferences("Login", Context.MODE_PRIVATE);
        editor = pref.edit();

        if(pref.getString("name_key",null)!=null&&pref.getString("pass_key",null)!=null){
           e1.setText(pref.getString("name_key",null));
            e2.setText(pref.getString("pass_key",null));
        }
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = e1.getText().toString();
                String pass = e2.getText().toString();
                if (ch.isChecked()){
                    editor.putString("name_key",name);
                   editor.putString("pass_key",pass);
                    editor.commit();
                    e1.setText("");
                    e2.setText("");
                }else {
                editor.clear();
                editor.commit();
            }
                Toast.makeText(MainActivity.this, "Login Succesfully", Toast.LENGTH_SHORT).show();
            }
        });
    }
}