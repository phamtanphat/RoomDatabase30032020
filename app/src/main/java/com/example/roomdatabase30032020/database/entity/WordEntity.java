package com.example.roomdatabase30032020.database.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "Word")
public class WordEntity {

    @PrimaryKey(autoGenerate = true)
    private long id;

    @ColumnInfo(name = "english")
    private String en;

    @ColumnInfo(name = "vietnamese")
    private String vn;


    @ColumnInfo(name = "ismemorized" , defaultValue = "false")
    private Boolean ismemorized;

    public WordEntity() {
    }

    @Ignore
    public WordEntity(String en, String vn) {
        this.en = en;
        this.vn = vn;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEn() {
        return en;
    }

    public void setEn(String en) {
        this.en = en;
    }

    public String getVn() {
        return vn;
    }

    public void setVn(String vn) {
        this.vn = vn;
    }

    public Boolean getIsmemorized() {
        return ismemorized;
    }

    public void setIsmemorized(Boolean ismemorized) {
        this.ismemorized = ismemorized;
    }
}
