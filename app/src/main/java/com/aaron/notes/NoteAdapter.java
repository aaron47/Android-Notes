package com.aaron.notes;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aaron.notes.entities.Note;

import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteViewHolder> {

    private final List<Note> notes;

    public NoteAdapter(List<Note> notes) {
        this.notes = notes;
    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_note, parent, false);
        return new NoteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {
        TextView tvTitle = holder.itemView.findViewById(R.id.tvTitle);
        CheckBox cbChecked = holder.itemView.findViewById(R.id.cbChecked);
        tvTitle.setText(this.notes.get(position).getTitle());
        cbChecked.setChecked(this.notes.get(position).isChecked());
    }

    @Override
    public int getItemCount() {
        return this.notes.size();
    }


    public static class NoteViewHolder extends RecyclerView.ViewHolder {
        public NoteViewHolder(View itemView) {
            super(itemView);
        }
    }
}

