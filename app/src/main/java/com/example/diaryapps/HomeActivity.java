package com.example.diaryapps;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

    Button save = findViewById(R.id.save);

    save.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {


        }
    });
    }
}
