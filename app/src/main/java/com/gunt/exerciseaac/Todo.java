package com.gunt.exerciseaac;

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

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("TODO {");
        sb.append("id=").append(id);
        sb.append(", title= ").append(title).append("");
        sb.append("}");
        return sb.toString();
    }
}
