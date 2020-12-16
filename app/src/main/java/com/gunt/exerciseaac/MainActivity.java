package com.gunt.exerciseaac;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    TextView txt_list;
    EditText et_todo;
    AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        txt_list = findViewById(R.id.txt_list);
        et_todo = findViewById(R.id.et_todo);
        db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "todo-db")
                .build();

        db.todoDAO().getAll().observe(this, todos -> txt_list.setText(todos.toString()));

        findViewById(R.id.btn_input).setOnClickListener(v -> {
            Observable.just(et_todo.getText().toString())
                    .subscribeOn(Schedulers.io())
                    .subscribe(str -> db.todoDAO().insert(new Todo(str)));
        });

    }

}