package falcon_007.kamrulhasan.simpletodolistapp;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

import adepter.CustomToDoListAdapter;
import data.DatabaseHandler;
import data.ToDoList;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton floatingActionButton;
    //----- LIST VIEW INSTANTS------
    private ListView todoListView;
    //-------- DATABASE CLASS INSTANTS-------
    private CustomToDoListAdapter adapter;
    private ArrayList<ToDoList> toDoLists = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("ToDo List");

        /*
         * initialize floating action button
         * and switch activity
         */
        floatingActionButton = (FloatingActionButton) findViewById(R.id.fab);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),TodoEditorActivity.class));
            }
        });

        showList();

    }
    //---- SHOW TODO LIST TROUGH THE LIST VIEW
    public void showList(){
        toDoLists.clear();
        DatabaseHandler handler = new DatabaseHandler(this);
        ArrayList<ToDoList> listFromDb = handler.getToDoData();
        for (int i = 0 ; i<listFromDb.size() ; i++){
            ToDoList list = new ToDoList();
            String taskName = listFromDb.get(i).getTaskName();
            String taskDescription = listFromDb.get(i).getTaskDescription();
            String taskAddedDataTime = listFromDb.get(i).getTimeAndDateText();;
            String taskHintText = String.valueOf(taskName.charAt(0)).toUpperCase();
            list.setTaskName(taskName);
            list.setTaskDescription(taskDescription);
            list.setTimeAndDateText(taskAddedDataTime);
            list.setTaskHintText(taskHintText);
            toDoLists.add(list);
        }
        handler.close();
        todoListView = (ListView) findViewById(R.id.todoList);
        adapter = new CustomToDoListAdapter(MainActivity.this,R.layout.todo_list_item,toDoLists);
        todoListView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}
