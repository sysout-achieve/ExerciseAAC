package com.gunt.exerciseaac.data;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import com.gunt.exerciseaac.data.domain.*;

@Database(entities = {Todo.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract TodoDAO todoDAO();
}
