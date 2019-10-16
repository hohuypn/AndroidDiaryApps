package com.example.diaryapps;


import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.Query;

@Entity
public class Diary  {
    @PrimaryKey(autoGenerate = true)
    public int id;

    public String title;
    public String content;
    public String date;


    public Diary(int id, String title, String content, String date) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
