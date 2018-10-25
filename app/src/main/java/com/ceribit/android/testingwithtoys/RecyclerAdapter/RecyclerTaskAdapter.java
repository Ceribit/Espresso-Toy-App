package com.ceribit.android.testingwithtoys.RecyclerAdapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ceribit.android.testingwithtoys.Models.Task;
import com.ceribit.android.testingwithtoys.R;

import java.util.ArrayList;
import java.util.List;

public class RecyclerTaskAdapter extends RecyclerView.Adapter<RecyclerTaskAdapter.ViewHolder>{

    private List<Task> mTasks;

    private Context mContext;

    RecyclerTaskAdapter(Context context, List<Task> tasks) {
        mTasks = tasks;
        mContext = context;
    }

    // Inflates the item layout and creates the holder
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);

        View taskView = layoutInflater.inflate(R.layout.task_list_item, viewGroup, false);

        ViewHolder viewHolder = new ViewHolder(taskView);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        Task task = mTasks.get(position);

        // Set Views based off data from the Task
        viewHolder.mTitleView.setText(task.getTitle());
        viewHolder.mDescriptionView.setText(task.getDescription());
    }

    @Override
    public int getItemCount() {
        return mTasks.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        ImageView mImageView;
        TextView mTitleView;
        TextView mDescriptionView;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView = (ImageView) itemView.findViewById(R.id.task_image);
            mTitleView = (TextView) itemView.findViewById(R.id.task_title);
            mDescriptionView = (TextView) itemView.findViewById(R.id.task_description);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mTitleView.setText(mContext.getString(R.string.task_changed_title));
                }
            });
        }
    }
}
