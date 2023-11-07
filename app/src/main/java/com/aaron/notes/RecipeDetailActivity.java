package com.aaron.notes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class RecipeDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_detail);

        Bundle bundle = this.getIntent().getExtras();

        if (bundle != null) {
            String recipeTitle = bundle.getString("RECIPE_TITLE");
            List<String> recipeIngredients = bundle.getStringArrayList("RECIPE_INGREDIENTS");
            String recipeInstructions = bundle.getString("RECIPE_INSTRUCTIONS");

            TextView tvRecipeTitle = findViewById(R.id.tvRecipeTitle);
            TextView tvRecipeIngredients = findViewById(R.id.tvRecipeIngredients);
            TextView tvRecipeInstructions = findViewById(R.id.tvRecipeInstructions);

            tvRecipeTitle.setText(recipeTitle);

            StringBuilder ingredientsBuilder = new StringBuilder();
            for (String ingredient : recipeIngredients) {
                ingredientsBuilder.append("• ").append(ingredient).append("\n");
            }
            tvRecipeIngredients.setText(ingredientsBuilder.toString().trim());

            tvRecipeInstructions.setText(recipeInstructions);
        }
    }
}