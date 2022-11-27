package com.ebookfrenzy.newtodoapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.ebookfrenzy.newtodoapp.MainActivity;

import java.util.ArrayList;

public class AdaptateurToDo extends BaseAdapter implements MainActivity.Itodo {

    private ArrayList<String> todos = new ArrayList<>();
    LayoutInflater inflater;
    public AdaptateurToDo(Context ctx, ArrayList<String> todos) {
        inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.todos = todos;
    }

    @Override
    public int getCount() {
        return todos.size();
    }

    @Override
    public Object getItem(int position) {
        return todos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View rowView =inflater.inflate(R.layout.todo_layout, parent, false);
        TextView name = rowView.findViewById(R.id.todolistId);
        name.setText(todos.get(position));

        Button bouton = rowView.findViewById(R.id.effacerId);

        bouton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeTodo(position);
            }
        });

        return rowView;
    }

    @Override
    public void removeTodo(int position){
        todos.remove(position);
        notifyDataSetChanged();
    }
}
