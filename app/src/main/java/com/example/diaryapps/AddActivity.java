package com.example.diaryapps;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AddActivity extends AppCompatActivity {
    Button btn_add_backSreen;
    DiaryDatabase db;
    EditText editTitle;
    EditText editContent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        db = Room.databaseBuilder(getApplicationContext(),
                DiaryDatabase.class, "database-name").build();
        editContent = findViewById(R.id.edit_content);
        editTitle = findViewById(R.id.edit_title);

        btn_add_backSreen = findViewById(R.id.btn_add_2);
        btn_add_backSreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                add();
                finish();
            }
        });
    }
    public void add(){
        final String title = editTitle.getText().toString();
        final  String content = editContent.getText().toString();

        if (title.isEmpty()){
            Toast.makeText(this, "Tiêu đề không được để trống", Toast.LENGTH_SHORT).show();
            return;
        }
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                Diary diary = new Diary(title, content);
                db.diaryDao().insertAll(diary);
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                Toast.makeText(AddActivity.this, "Đã thêm", Toast.LENGTH_SHORT).show();
            }
        }.execute();


        Intent intent = new Intent(AddActivity.this, HomeActivity.class);
        startActivity(intent);
    }
}
