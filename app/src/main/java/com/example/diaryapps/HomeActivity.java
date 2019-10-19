package com.example.diaryapps;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {
    List<Diary> diaries = new ArrayList<>();
    DiaryDatabase db;
    Button btn_add;
    RecyclerView recyclerView;
    DiaryAdapter diaryAdapter;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        db = Room.databaseBuilder(getApplicationContext(),
                DiaryDatabase.class, "database-name").build();
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
              diaries =  db.diaryDao().getAll();
                return null;
            }
        }.execute();

        btn_add = findViewById(R.id.btn_add_2);
        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        diaryAdapter = new DiaryAdapter(diaries);

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
