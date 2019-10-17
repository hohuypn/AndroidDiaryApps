package com.example.diaryapps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {
    Button btn_add;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

    btn_add = findViewById(R.id.btn_add);

    btn_add.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            showAddScreeen();
        }
    });
    }
    public void showAddScreeen(){
        Intent intent = new Intent(HomeActivity.this, AddActivity.class);
        startActivity(intent);
    }
}
