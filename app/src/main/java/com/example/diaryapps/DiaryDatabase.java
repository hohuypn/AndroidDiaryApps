package com.example.diaryapps;

import androidx.room.Database;
import androidx.room.RoomDatabase;
@Database(entities = Diary.class, version =1, exportSchema = false)
public abstract class DiaryDatabase extends RoomDatabase {
    public abstract DiaryDao diaryDao();
}
