package com.ebookfrenzy.newtodoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static AdaptateurToDo adaptateurToDo;
    public static ArrayList<String> todos;
    int positionClicked;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView lv = findViewById(R.id.listView);
        todos = new ArrayList<>();
        adaptateurToDo = new AdaptateurToDo(this, todos);
        lv.setAdapter(adaptateurToDo);
        EditText editText = findViewById(R.id.AjouterToDo);
        Button boutonAjouter = findViewById(R.id.button);



        boutonAjouter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String todo = editText.getText().toString();
                if(!todo.isEmpty()) {
                    if(!todos.contains(todo)) {
                        todos.add(editText.getText().toString());
                        adaptateurToDo.notifyDataSetChanged();
                    }
                    else{
                        Toast.makeText(getApplicationContext(),"existe deja",
                                Toast.LENGTH_SHORT).show();                    }

                }
            }
        });
    }

    public void addTodo(String todo) {
        todos.add(todo);
    }



    public interface Itodo{
        void removeTodo(int position);
}
}


