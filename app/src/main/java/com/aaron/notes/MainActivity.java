package com.aaron.notes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.aaron.notes.entities.Note;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private final List<Note> notes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notes.add(new Note(":DDDDDDDDD"));
        notes.add(new Note("second note hahahaha", true));
        notes.add(new Note("third note XDDDDDD", true));

        NoteAdapter noteAdapter = new NoteAdapter(notes);
        RecyclerView rvTodos = findViewById(R.id.rvNotes);
        rvTodos.setAdapter(noteAdapter);
        rvTodos.setLayoutManager(new LinearLayoutManager(this));

        Button btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(v -> {
            EditText etTodo = findViewById(R.id.etNote);
            String title = etTodo.getText().toString();

            Note note = new Note(title);

            notes.add(note);
            noteAdapter.notifyItemInserted(notes.size() - 1);
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.app_bar_menu, menu);

        MenuItem favouriteItem = menu.findItem(R.id.miFavourite);

        // Set a custom action view for the miFavourite menu item
        favouriteItem.setActionView(R.layout.badge_layout);

        // Initialize the badge TextView
        TextView badgeCount = favouriteItem.getActionView().findViewById(R.id.tvFavourites);

        // Update the badge count here with the actual count of items
        int itemCount = this.notes.size()/* Calculate the count of items */;
        badgeCount.setText(String.valueOf(itemCount));

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.miAddItem) {
            AddNoteDialog addNoteDialog = new AddNoteDialog(this, note -> {
                this.notes.add(note);
                Toast.makeText(this, "Vous avez ajoute une note avec success", Toast.LENGTH_SHORT).show();
            });

            addNoteDialog.show();
        }

        return true;
    }
}