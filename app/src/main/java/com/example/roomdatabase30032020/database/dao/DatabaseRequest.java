package com.example.roomdatabase30032020.database.dao;

import android.database.Observable;
import android.provider.UserDictionary;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.roomdatabase30032020.database.entity.WordEntity;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Maybe;

@Dao
public interface DatabaseRequest {

    @Query("SELECT * FROM Word")
    Flowable<List<WordEntity>> getList();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Maybe<Long> insertWord(WordEntity wordEntity);

    @Delete
    Completable deleteWord(WordEntity wordEntity);

    @Update
    Completable updateWord(WordEntity wordEntity);

}
