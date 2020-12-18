package com.gunt.exerciseaac;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.room.Room;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public class MainViewModel extends AndroidViewModel {
    AppDatabase db;
    public LiveData<List<Todo>> todos;
    public String todoStr;

    public MainViewModel(@NonNull Application application) {
        super(application);
        db = Room.databaseBuilder(application, AppDatabase.class, "todo-db")
                .build();
        todos = getAll();
    }

    public LiveData<List<Todo>> getAll() {
        return db.todoDAO().getAll();
    }

    public void insert(String todoStr) {
        Observable.just(new Todo(todoStr))
                .subscribeOn(Schedulers.io())
                .subscribe(todoObj -> {
                    db.todoDAO().insert(todoObj);
                    Log.d("Thread name: ", Thread.currentThread().getName());
                });
        Log.d("out Thread name: ", Thread.currentThread().getName());
    }
}
