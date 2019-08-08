package com.example.shakil.sharedpreferencesexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edt_email, edt_password;
    Button btn_save, btn_show, btn_reset;
    TextView txt_show_info;

    UserPreference userPreference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userPreference = new UserPreference(this);

        edt_email = findViewById(R.id.edt_email);
        edt_password = findViewById(R.id.edt_password);

        btn_save = findViewById(R.id.btn_save);
        btn_show = findViewById(R.id.btn_show);
        btn_reset = findViewById(R.id.btn_reset);

        txt_show_info = findViewById(R.id.txt_show_info);

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = edt_email.getText().toString();
                String password = edt_password.getText().toString();

                edt_email.setText("");
                edt_password.setText("");

                userPreference.saveUser(email, password);
                Toast.makeText(MainActivity.this, "Data Saved", Toast.LENGTH_SHORT).show();
            }
        });

        btn_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt_show_info.setText("Email: " + userPreference.showEmail() + "\n" + "Password: " + userPreference.showPassword());
            }
        });

        btn_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userPreference.resetUser();
                Toast.makeText(MainActivity.this, "Data Removed", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
