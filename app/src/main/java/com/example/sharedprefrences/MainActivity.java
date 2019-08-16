package com.example.sharedprefrences;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
EditText name_edit,password_edit;
Button btn_login;
CheckBox checkBox;
String Name,Password;
Boolean checkbox;
public static final String SHARED_PREF="shardpref";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name_edit=findViewById(R.id.name_edit);
        password_edit=findViewById(R.id.password_edit);
        checkBox=findViewById(R.id.checkbox);
        btn_login=findViewById(R.id.btn_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox.isChecked()) {

                    saveData();
                }
            }
        });
        loadData();
        updateviews();
    }
    public void saveData()
    {
        SharedPreferences sharedPreferences=getSharedPreferences(SHARED_PREF,MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString("Name",name_edit.getText().toString());
        editor.putString("Password",password_edit.getText().toString());
        editor.putBoolean("CheckBox",checkBox.isChecked());
        editor.apply();
    }
    public void loadData()
    {
        SharedPreferences sharedPreferences=getSharedPreferences(SHARED_PREF,MODE_PRIVATE);
        Name=sharedPreferences.getString("Name","");
        Password=sharedPreferences.getString("Password","");
        checkbox=sharedPreferences.getBoolean("CheckBox",false);
    }
    public void updateviews()
    {
        name_edit.setText(Name);
        password_edit.setText(Password);
        checkBox.setChecked(checkbox);
    }
}
