package com.example.abdullah.assignment3;

import android.arch.persistence.room.Database;

import android.arch.persistence.room.RoomDatabase;

@Database(entities = {Student.class},version = 1)
public abstract class myAppDatabase extends RoomDatabase {

    public abstract myDao mydao();

}
