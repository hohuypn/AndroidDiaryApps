package com.example.diaryapps;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DiaryAdapter extends RecyclerView.Adapter<DiaryAdapter.ViewHolder> {

    List<Diary> diaries;
    AdapterView.OnItemClickListener listener;

    public DiaryAdapter(List<Diary> diaries) {
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_home, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txt_title.setText(diaries.get(position).getTitle());
        holder.txt_content.setText(diaries.get(position).getContent());
    }

    @Override
    public int getItemCount() {
        if (diaries == null){
            return 0;

        } return diaries.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txt_title;
        TextView txt_content;
        Button btn_update;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_title = itemView.findViewById(R.id.txt_title);
            txt_content = itemView.findViewById(R.id.txt_content);


        }
    }
    interface OnItemClickListener {
        void onUpdateClick(int position);
    }
}
