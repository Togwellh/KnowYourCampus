package com.example.knowyourcampus;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class TaskListActivity extends AppCompatActivity {
    private RecyclerView taskRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    private String[] DEMO_TASK_INFO_REWARDS = {
      "The library holds over 65,000 map sheets, focusing on maps of the British Isles and Scotland in particular. They are stored on level 7!",
      "The library currently holds nearly 1.4 million printed books",
      "The current 12-storey version of the library was originally built in 1968",
      "The Library is open 361 days of the year!",
    };
    private ArrayList<Task> tasks = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_list);

        tasks.add(new Task(DEMO_TASK_INFO_REWARDS[0], TaskType.QUESTION));
        tasks.add(new Task(DEMO_TASK_INFO_REWARDS[1], TaskType.AR));
        tasks.add(new Task(DEMO_TASK_INFO_REWARDS[2], TaskType.PICTURE));
        tasks.add(new Task(DEMO_TASK_INFO_REWARDS[3], TaskType.SELFIE));

        taskRecyclerView = findViewById(R.id.task_list_recycler);
        layoutManager = new LinearLayoutManager(this);
        taskRecyclerView.setLayoutManager(layoutManager);
        mAdapter = new TaskAdapter(tasks);
        taskRecyclerView.setAdapter(mAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        boolean quizEnabled = true;
        for (Task t : tasks) {
            if (!t.isCompleted()) {
                quizEnabled = false;
                break;
            }
        }
        findViewById(R.id.bt_take_quiz).setEnabled(quizEnabled);
    }

    public void onAbandonClicked(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(TaskListActivity.this);
        builder.setMessage("Do you really want to abandon the curren tour?");
        builder.setTitle("Abandon tour?");
        builder.setCancelable(false);

        builder.setPositiveButton("Abandon", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(TaskListActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        builder.show();
    }
}