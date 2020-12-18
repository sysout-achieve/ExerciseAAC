package com.gunt.exerciseaac;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.room.Room;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public class MainViewModel extends AndroidViewModel {
    AppDatabase db;

    public MainViewModel(@NonNull Application application) {
        super(application);
        db = Room.databaseBuilder(application, AppDatabase.class, "todo-db")
                .build();
    }

    public LiveData<List<Todo>> getAll(){
        return db.todoDAO().getAll();
    }

    public void insert(Todo todo){
        Observable.just(todo)
                .subscribeOn(Schedulers.io())
                .subscribe(todoObj -> db.todoDAO().insert(todoObj));
    }
}
