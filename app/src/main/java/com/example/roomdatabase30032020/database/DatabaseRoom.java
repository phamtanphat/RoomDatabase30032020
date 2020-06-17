package com.example.roomdatabase30032020.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.roomdatabase30032020.database.dao.DatabaseRequest;
import com.example.roomdatabase30032020.database.entity.WordEntity;

@Database(entities = WordEntity.class , version = 1 )
public abstract class DatabaseRoom extends RoomDatabase {
    public abstract DatabaseRequest databaseRequest();
    public static DatabaseRoom databaseRoom = null;

    public synchronized static DatabaseRoom getInstance(Context context){
        if (databaseRoom == null){
            databaseRoom = Room.databaseBuilder(
                    context,
                    DatabaseRoom.class,
                    "Quanlytuvung"
            )
                    .build();
        }
        return databaseRoom;
    }
}
