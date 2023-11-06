package com.aaron.notes;

import android.content.Context;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatDialog;

import com.aaron.notes.entities.Note;

public class AddNoteDialog extends AppCompatDialog {

    private TextView tvAdd;
    private TextView tvCancel;
    private EditText etNote;

    private final AddDialogListener addDialogListener;

    public AddNoteDialog(@NonNull Context context, AddDialogListener addDialogListener) {
        super(context);
        this.addDialogListener = addDialogListener;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_add_note);

        this.tvAdd = findViewById(R.id.tvAdd);
        this.tvCancel = findViewById(R.id.tvCancel);
        this.etNote = findViewById(R.id.etNote);

        this.tvAdd.setOnClickListener(v -> {
            String noteTitle = this.etNote.getText().toString();

            if (noteTitle.isEmpty()) {
                Toast.makeText(this.getContext(), "Veuillez entrer votre note", Toast.LENGTH_SHORT).show();
                return;
            }

            Note note = new Note(noteTitle);
            this.addDialogListener.onAddButtonClicked(note);
            this.dismiss();
        });

        this.tvCancel.setOnClickListener(v -> {
            this.cancel();
        });
    }
}
