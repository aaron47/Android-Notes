package com.aaron.notes.entities;


import java.util.ArrayList;
import java.util.List;

public class Recipe {

    private String title;

    private List<String> ingredients;

    private String instructions;
    private boolean isFavourite;


    public Recipe(String title, List<String> ingredients, String instructions) {
        this.title = title;
        this.ingredients = ingredients;
        this.instructions = instructions;
        this.isFavourite = false;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public boolean isFavourite() {
        return isFavourite;
    }

    public void setFavourite(boolean favourite) {
        isFavourite = favourite;
    }


    public static List<Recipe> getDummyRecipes() {
        List<Recipe> recipes = new ArrayList<>();

        List<String> ingredients1 = new ArrayList<>();
        ingredients1.add("1 cup flour");
        ingredients1.add("1 egg");
        ingredients1.add("1 cup milk");
        ingredients1.add("Salt to taste");
        String instructions1 = "1. Mix flour, egg, milk, and salt in a bowl.\n2. Cook in a hot pan.";
        Recipe recipe1 = new Recipe("Pancakes", ingredients1, instructions1);
        recipes.add(recipe1);

        List<String> ingredients2 = new ArrayList<>();
        ingredients2.add("2 cups pasta");
        ingredients2.add("1/2 cup tomato sauce");
        ingredients2.add("1/4 cup cheese");
        String instructions2 = "1. Boil pasta until tender.\n2. Mix with tomato sauce and cheese.";
        Recipe recipe2 = new Recipe("Pasta with Tomato Sauce", ingredients2, instructions2);
        recipes.add(recipe2);

        List<String> ingredients3 = new ArrayList<>();
        ingredients3.add("2 chicken breasts");
        ingredients3.add("1/2 cup olive oil");
        ingredients3.add("1 lemon");
        ingredients3.add("Salt and pepper to taste");
        String instructions3 = "1. Season chicken breasts with salt, pepper, and lemon juice.\n2. Grill until cooked through.";
        Recipe recipe3 = new Recipe("Grilled Lemon Chicken", ingredients3, instructions3);
        recipes.add(recipe3);

        List<String> ingredients4 = new ArrayList<>();
        ingredients4.add("1 pound ground beef");
        ingredients4.add("1 onion");
        ingredients4.add("1 can tomato soup");
        ingredients4.add("1 cup cheese");
        String instructions4 = "1. Brown ground beef and onion in a skillet.\n2. Mix in tomato soup and simmer.\n3. Top with cheese.";
        Recipe recipe4 = new Recipe("Cheesy Beef Casserole", ingredients4, instructions4);
        recipes.add(recipe4);

        List<String> ingredients5 = new ArrayList<>();
        ingredients5.add("2 cups rice");
        ingredients5.add("1/2 cup peas");
        ingredients5.add("1/2 cup carrots");
        ingredients5.add("2 eggs");
        String instructions5 = "1. Cook rice and set aside.\n2. Scramble eggs in a pan, add peas and carrots, then mix with rice.";
        Recipe recipe5 = new Recipe("Fried Rice", ingredients5, instructions5);
        recipes.add(recipe5);

        List<String> ingredients6 = new ArrayList<>();
        ingredients6.add("4 salmon fillets");
        ingredients6.add("2 tablespoons soy sauce");
        ingredients6.add("1 tablespoon honey");
        ingredients6.add("1 teaspoon ginger");
        String instructions6 = "1. Mix soy sauce, honey, and ginger.\n2. Marinate salmon and grill or bake.";
        Recipe recipe6 = new Recipe("Honey Soy Glazed Salmon", ingredients6, instructions6);
        recipes.add(recipe6);

        List<String> ingredients7 = new ArrayList<>();
        ingredients7.add("1 cup oats");
        ingredients7.add("1/2 cup yogurt");
        ingredients7.add("1/4 cup honey");
        ingredients7.add("1/4 cup berries");
        String instructions7 = "1. Mix oats, yogurt, and honey.\n2. Top with berries.";
        Recipe recipe7 = new Recipe("Yogurt and Berry Parfait", ingredients7, instructions7);
        recipes.add(recipe7);

        List<String> ingredients8 = new ArrayList<>();
        ingredients8.add("2 cups broccoli");
        ingredients8.add("1/4 cup olive oil");
        ingredients8.add("2 cloves garlic");
        ingredients8.add("Salt and pepper to taste");
        String instructions8 = "1. Roast broccoli with olive oil and garlic.\n2. Season with salt and pepper.";
        Recipe recipe8 = new Recipe("Roasted Garlic Broccoli", ingredients8, instructions8);
        recipes.add(recipe8);

        List<String> ingredients9 = new ArrayList<>();
        ingredients9.add("1 pound shrimp");
        ingredients9.add("1/4 cup butter");
        ingredients9.add("2 cloves garlic");
        ingredients9.add("1 lemon");
        String instructions9 = "1. Cook shrimp in butter and garlic.\n2. Squeeze lemon juice on top.";
        Recipe recipe9 = new Recipe("Garlic Butter Shrimp", ingredients9, instructions9);
        recipes.add(recipe9);

        List<String> ingredients10 = new ArrayList<>();
        ingredients10.add("3 cups flour");
        ingredients10.add("1 cup sugar");
        ingredients10.add("1/2 cup butter");
        ingredients10.add("2 eggs");
        String instructions10 = "1. Mix flour, sugar, and butter to form a dough.\n2. Roll out dough and cut into shapes.\n3. Bake until golden brown.";
        Recipe recipe10 = new Recipe("Sugar Cookies", ingredients10, instructions10);
        recipes.add(recipe10);

        return recipes;
    }
}
