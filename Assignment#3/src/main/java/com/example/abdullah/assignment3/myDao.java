package com.example.abdullah.assignment3;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface myDao {

     @Insert
     void adduser(Student user);

     @Query("select * from Student")
     public List<Student> getStudents();

     @Update
     void update(Student user);

}
