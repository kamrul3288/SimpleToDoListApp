package falcon_007.kamrulhasan.simpletodolistapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class TodoEditorActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_editor);
        getSupportActionBar().setTitle("ToDo Editor");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }


}
