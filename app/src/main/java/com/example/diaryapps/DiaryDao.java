package com.example.diaryapps;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public abstract class DiaryDao {
    @Query("SELECT * FROM Diary")
    public abstract List<Diary> getAll();

    @Insert
    public abstract void insertAll(Diary diary);

    @Delete
    public abstract void deleteAll(Diary diary);
}
