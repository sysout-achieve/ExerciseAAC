package com.gunt.exerciseaac;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

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

        MainViewModel viewModel = new ViewModelProvider(this, new ViewModelProvider.AndroidViewModelFactory(getApplication())).get(MainViewModel.class);

        viewModel.getAll().observe(this, todos -> txt_list.setText(todos.toString()));

        findViewById(R.id.btn_input).setOnClickListener(v -> viewModel.insert(new Todo(et_todo.getText().toString())));

    }

}