package com.ceribit.android.testingwithtoys.RecyclerAdapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.ceribit.android.testingwithtoys.Models.Task;
import com.ceribit.android.testingwithtoys.R;

import java.util.ArrayList;

public class TaskRecyclerAdapterPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_recycler_adapter_page);

        RecyclerView recyclerView = findViewById(R.id.recycler_list_view);

        ArrayList<Task> tasksList = new ArrayList<>();
        for(int i = 0; i < 200; i++){
            tasksList.add(
                    new Task("title" + i, "description" + i)
            );
        }

        RecyclerTaskAdapter adapter = new RecyclerTaskAdapter(this, tasksList);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
