package com.example.knowyourcampus;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder> {
    private List<Task> tasks;

    public static class TaskViewHolder extends RecyclerView.ViewHolder {
        public Button taskButton;
        public TextView taskInfoView;

        public TaskViewHolder(LinearLayout v) {
            super(v);
            taskButton = v.findViewById(R.id.bt_task_name);
            taskInfoView = v.findViewById(R.id.tv_task_info_reward);
        }
    }

    public TaskAdapter(List<Task> tasks) {
        this.tasks = tasks;
    }

    @Override
    public TaskAdapter.TaskViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LinearLayout v = (LinearLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.task_view_row, parent, false);
        TaskViewHolder vh = new TaskViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(TaskViewHolder holder, int position) {
        Task t = tasks.get(position);
        holder.taskButton.setText(String.format("Task %d", position + 1));
        holder.taskInfoView.setText(t.getInfoReward());
        holder.taskInfoView.setVisibility(t.isCompleted() ? View.VISIBLE : View.GONE);
    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }

}
