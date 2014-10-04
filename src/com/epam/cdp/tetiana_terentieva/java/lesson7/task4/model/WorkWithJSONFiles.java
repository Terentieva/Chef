package com.epam.cdp.tetiana_terentieva.java.lesson7.task4.model;

import java.util.ArrayList;

public class WorkWithJSONFiles extends Files {

    @Override
    public ArrayList<Ingredient> readFromFile()
    {
        ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();

        Ingredient ingredient = new Ingredient();
        ingredient.setIngredientName("Apple");
        ingredient.setIngredientType("Fruit");
        ingredient.setCalories(30);
        ingredient.setProteins(5);
        ingredient.setFats(3);
        ingredient.setCarbs(0);
        ingredients.add(ingredient);

        return ingredients;
    }

    @Override
    public void setFileName(String fileName)
    {
        this.fileName = fileName + ".json";
    }

}
