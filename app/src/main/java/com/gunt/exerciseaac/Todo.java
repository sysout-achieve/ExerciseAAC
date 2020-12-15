package com.gunt.exerciseaac;


import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import lombok.Data;

@Data
@Entity
public class Todo {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String title;

    public Todo(String title) {
        this.title = title;
    }

    @NonNull
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("TODO {");
        sb.append("id=").append(id);
        sb.append(", title= ").append(title).append("\n");
        sb.append("}");
        return super.toString();
    }
}
