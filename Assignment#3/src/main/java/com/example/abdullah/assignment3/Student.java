package com.example.abdullah.assignment3;
import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "Student")
public class Student {
    @PrimaryKey
    public int rollno;

    @ColumnInfo(name = "name")
    public String name;
    @ColumnInfo(name = "gpa")
    public float gpa;


    public int getRollno() {
        return rollno;
    }

    public void setRollno(int rollno) {
        this.rollno = rollno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }

    public float getGpa() {
        return gpa;
    }
}
