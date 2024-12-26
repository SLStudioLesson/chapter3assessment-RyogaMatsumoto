package com.recipeapp.model;

import java.util.ArrayList;

public class Recipe {
    private String name; // レシピの名前
    private ArrayList<Ingredient> ingredients; // レシピの材料リスト

    public Recipe(String name, ArrayList<Ingredient> ingredients) {
        this.name = name;
        this.ingredients = ingredients;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Ingredient> getIngredient() {
        return ingredients;
    }
}
