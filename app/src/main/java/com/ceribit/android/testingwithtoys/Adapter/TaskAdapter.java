package com.ceribit.android.testingwithtoys.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ceribit.android.testingwithtoys.Models.Task;
import com.ceribit.android.testingwithtoys.R;

import java.util.List;

public class TaskAdapter extends ArrayAdapter<Task> {
    private Context mContext;
    private List<Task> taskList;

    @Override
    public int getCount() {
        return taskList.size();
    }

    public TaskAdapter(Context context, int resource, List<Task> tasks){
        super(context, resource);
        mContext = context;
        taskList = tasks;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Log.e("nani", "called");
        LayoutInflater inflater = (LayoutInflater) mContext
            .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.task_list_item, parent, false);
        TextView titleTextView = rowView.findViewById(R.id.task_title);
        TextView descriptionTextView = rowView.findViewById(R.id.task_description);
        ImageView imageView = rowView.findViewById(R.id.task_image);

        titleTextView.setText(taskList.get(position).getTitle());
        descriptionTextView.setText(taskList.get(position).getDescription());
        imageView.setImageResource(android.R.drawable.btn_star);
        return rowView;
    }

    @NonNull
    @Override
    public Task getItem(int position) {
        if(position < 0 || position > taskList.size()-1){
            return new Task("Null", "Null");
        } else {
            return taskList.get(position);
        }
    }
}
