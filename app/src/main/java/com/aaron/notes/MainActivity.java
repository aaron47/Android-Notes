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

import com.aaron.notes.entities.Recipe;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private final List<Recipe> recipes = new ArrayList<>();
    private final List<Recipe> dummyRecipes = Recipe.getDummyRecipes();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecipeAdapter recipeAdapter = new RecipeAdapter(dummyRecipes);
        RecyclerView rvTodos = findViewById(R.id.rvNotes);
        rvTodos.setAdapter(recipeAdapter);
        rvTodos.setLayoutManager(new LinearLayoutManager(this));
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
        int itemCount = this.recipes.size()/* Calculate the count of items */;
        badgeCount.setText(String.valueOf(itemCount));

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.miAddItem) {
            AddRecipeDialog addRecipeDialog = new AddRecipeDialog(this, recipe -> {
                this.recipes.add(recipe);
                Toast.makeText(this, "Vous avez ajoute une note avec success", Toast.LENGTH_SHORT).show();
            });

            addRecipeDialog.show();
        }

        return true;
    }
}