package com.aaron.notes.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.aaron.notes.entities.Recipe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class DbHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "recipe_db";
    private static final int DB_VERSION = 1;
    private static final String TABLE_NAME = "recipes";
    private static final String ID_COL = "id";
    private static final String TITLE_COL = "title";
    private static final String INGREDIENTS_COL = "ingredients";
    // below variable for our course description column.
    private static final String INSTRUCTIONS_COL = "instructions";
    // below variable is for our course tracks column.
    private static final String IS_FAVOURITE_COL = "is_favourite";


    public DbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + TITLE_COL + " TEXT,"
                + INGREDIENTS_COL + " TEXT,"
                + INSTRUCTIONS_COL + " TEXT,"
                + IS_FAVOURITE_COL + " TEXT)";

        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }

    public void addRecipe(Recipe recipe) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(TITLE_COL, recipe.getTitle());
        values.put(INGREDIENTS_COL, recipe.getIngredients().toString());
        values.put(INSTRUCTIONS_COL, recipe.getInstructions());
        values.put(IS_FAVOURITE_COL, recipe.isFavourite());

        db.insert(TABLE_NAME, null, values);

        db.close();
    }

    public List<Recipe> getAllRecipes() {
        List<Recipe> recipeList = new ArrayList<>();

        // Select All Query
        String selectQuery = "SELECT * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // Looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Recipe recipe = new Recipe(null, null, null);

                int titleIndex = cursor.getColumnIndex(TITLE_COL);
                if (titleIndex != -1) {
                    recipe.setTitle(cursor.getString(titleIndex));
                }

                int ingredientsIndex = cursor.getColumnIndex(INGREDIENTS_COL);
                if (ingredientsIndex != -1) {
                    String ingredientsString = cursor.getString(ingredientsIndex);
                    List<String> ingredientsList = stringToList(ingredientsString);
                    recipe.setIngredients(ingredientsList);
                }

                int instructionsIndex = cursor.getColumnIndex(INSTRUCTIONS_COL);
                if (instructionsIndex != -1) {
                    recipe.setInstructions(cursor.getString(instructionsIndex));
                }

                int isFavouriteIndex = cursor.getColumnIndex(IS_FAVOURITE_COL);
                if (isFavouriteIndex != -1) {
                    recipe.setFavourite(cursor.getString(isFavouriteIndex).equals("1"));
                }

                // Adding recipe to list
                recipeList.add(recipe);
            } while (cursor.moveToNext());
        }

        // close db connection
        db.close();

        // return recipe list
        return recipeList;
    }

    public boolean updateRecipeFavouriteStatus(String recipeTitle, boolean isFavourite) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();


        values.put(IS_FAVOURITE_COL, isFavourite ? "1" : "0");

        int updateStatus = db.update(TABLE_NAME, values, TITLE_COL + " = ?", new String[] { String.valueOf(recipeTitle) });
        db.close();

        return updateStatus > 0;
    }


    private List<String> stringToList(String ingredientsString) {
        if (ingredientsString == null || ingredientsString.isEmpty()) {
            return new ArrayList<>();
        }

        return new ArrayList<>(Arrays.asList(ingredientsString.split(",\\s*")));
    }


}
