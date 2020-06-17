package com.example.roomdatabase30032020.repository;

import android.content.Context;

import com.example.roomdatabase30032020.database.DatabaseRoom;
import com.example.roomdatabase30032020.database.dao.DatabaseRequest;
import com.example.roomdatabase30032020.database.entity.WordEntity;

import java.util.List;

import io.reactivex.Flowable;

public class DatabaseRepository {
    public static DatabaseRepository repository = null;
    private DatabaseRequest databaseRequest;

    public DatabaseRepository(Context context){
        databaseRequest = DatabaseRoom.getInstance(context).databaseRequest();
    }
    public static DatabaseRepository getInstance(Context context){
        if (repository == null){
            repository = new DatabaseRepository(context);
        }
        return repository;
    }

    public Flowable<List<WordEntity>> getListDataWord(){
        return databaseRequest.getList();
    }

}
