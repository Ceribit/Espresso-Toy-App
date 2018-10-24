package com.ceribit.android.testingwithtoys.Adapter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.ceribit.android.testingwithtoys.Models.Task;
import com.ceribit.android.testingwithtoys.R;
import com.ceribit.android.testingwithtoys.RecyclerAdapter.RecyclerTaskAdapter;
import com.ceribit.android.testingwithtoys.RecyclerAdapter.TaskRecyclerAdapterPage;

import java.util.ArrayList;

public class TaskAdapterPage extends AppCompatActivity implements
        AdapterView.OnItemClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_adapter_page);

        ArrayList<Task> tasksList = new ArrayList<>();
        ListView listView = findViewById(R.id.task_list_view);
        for(int i = 0; i < 200; i++){
            tasksList.add(
                    new Task("title" + i, "description" + i)
            );
        }

        TaskAdapter taskAdapter = new TaskAdapter(getBaseContext(), -1, tasksList);
        listView.setAdapter(taskAdapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        TaskAdapter adapter= (TaskAdapter) adapterView.getAdapter();
        Task selectedTask = adapter.getItem(i);

        Toast.makeText(
                this,
                "You clicked an item with the description: " + selectedTask.getDescription(),
                Toast.LENGTH_LONG).show();
    }

    public void goToFourthPage(View view){
        Intent intent = new Intent(this, TaskRecyclerAdapterPage.class);
        startActivity(intent);
    }
}
