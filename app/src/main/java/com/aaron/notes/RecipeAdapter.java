package com.aaron.notes;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aaron.notes.entities.Recipe;

import java.util.ArrayList;
import java.util.List;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder> {

    private final List<Recipe> recipes;

    public RecipeAdapter(List<Recipe> recipes) {
        this.recipes = recipes;
    }

    @NonNull
    @Override
    public RecipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recipe, parent, false);
        return new RecipeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeViewHolder holder, int position) {
        Recipe recipe = this.recipes.get(position);
        TextView tvTitle = holder.itemView.findViewById(R.id.tvTitle);
        CheckBox cbChecked = holder.itemView.findViewById(R.id.cbChecked);
        tvTitle.setText(recipe.getTitle());
        cbChecked.setChecked(recipe.isFavourite());

        holder.itemView.setOnClickListener(v -> {
            Intent recipeDetailIntent = new Intent(v.getContext(), RecipeDetailActivity.class);


            Bundle bundle = new Bundle();
            bundle.putString("RECIPE_TITLE", recipe.getTitle());
            bundle.putStringArrayList("RECIPE_INGREDIENTS", (ArrayList<String>) recipe.getIngredients());
            bundle.putString("RECIPE_INSTRUCTIONS", recipe.getInstructions());


            recipeDetailIntent.putExtras(bundle);

            v.getContext().startActivity(recipeDetailIntent);
        });
    }

    @Override
    public int getItemCount() {
        return this.recipes.size();
    }


    public static class RecipeViewHolder extends RecyclerView.ViewHolder {
        public RecipeViewHolder(View itemView) {
            super(itemView);
        }
    }
}

