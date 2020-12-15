package com.gunt.exerciseaac.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.gunt.exerciseaac.data.AppDatabase;
import com.gunt.exerciseaac.R;
import com.gunt.exerciseaac.data.domain.Todo;

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
                .allowMainThreadQueries()
                .build();

        printTodoList();

        findViewById(R.id.btn_input).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.todoDAO().insert(new Todo(et_todo.getText().toString()));
                printTodoList();
            }
        });

    }

    private void printTodoList(){
        txt_list.setText(db.todoDAO().getAll().toString());
    }

}