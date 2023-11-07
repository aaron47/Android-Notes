package com.aaron.notes;

import android.content.Context;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatDialog;

import com.aaron.notes.entities.Recipe;

import java.util.Arrays;
import java.util.List;

public class AddRecipeDialog extends AppCompatDialog {

    private TextView tvAdd;
    private TextView tvCancel;
    private EditText etRecipeTitle;
    private EditText etRecipeIngredients;
    private EditText etRecipeInstructions;

    private final AddDialogListener addDialogListener;

    public AddRecipeDialog(@NonNull Context context, AddDialogListener addDialogListener) {
        super(context);
        this.addDialogListener = addDialogListener;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_add_recipe);

        this.tvAdd = findViewById(R.id.tvAdd);
        this.tvCancel = findViewById(R.id.tvCancel);
        this.etRecipeTitle = findViewById(R.id.etRecipeTitle);
        this.etRecipeIngredients = findViewById(R.id.etRecipeIngredients);
        this.etRecipeInstructions = findViewById(R.id.etRecipeIntructions);


        this.tvAdd.setOnClickListener(v -> {
            String recipeTitle = this.etRecipeTitle.getText().toString();
            List<String> recipeIngredients = Arrays.asList(this.etRecipeIngredients.getText().toString().split("\\s+"));
            String recipeInstructions = this.etRecipeInstructions.getText().toString();

            if (recipeTitle.isEmpty()) {
                Toast.makeText(this.getContext(), "Please enter your recipe's name", Toast.LENGTH_SHORT).show();
                return;
            }

            if (recipeIngredients.isEmpty()) {
                Toast.makeText(this.getContext(), "Please enter your recipe's ingredients", Toast.LENGTH_SHORT).show();
                return;
            }

            if (recipeInstructions.isEmpty()) {
                Toast.makeText(this.getContext(), "Please enter your recipe's instructions", Toast.LENGTH_SHORT).show();
                return;
            }

            Recipe recipe = new Recipe(recipeTitle, recipeIngredients, recipeInstructions);
            this.addDialogListener.onAddButtonClicked(recipe);
            this.dismiss();
        });

        this.tvCancel.setOnClickListener(v -> {
            this.cancel();
        });
    }
}
