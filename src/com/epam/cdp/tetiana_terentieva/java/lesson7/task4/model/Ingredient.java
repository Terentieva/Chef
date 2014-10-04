package com.epam.cdp.tetiana_terentieva.java.lesson7.task4.model;

import java.util.Comparator;

/**
 * Created by Таня on 29.07.2014.
 */
public class Ingredient implements Comparable<Ingredient> {
    // Name of ingredient
    public String ingredientName;
    //Type of ingredient
    public String ingredientType;
    //The number of calories in 100g
    public Integer calories;
    //The number of proteins in 100g
    public Integer proteins;
    //The number of fats in 100g
    public Integer fats;
    //The number of carbohydrates in 100g
    public Integer carbs;

    // Метод повертає назву інгрідієнту
    public String getIngredientName()
    {
        return ingredientName;
    }

    // Метод встановлює назву інгрідієнту
    public void setIngredientName(String ingredientName)
    {
        this.ingredientName = ingredientName;
    }

    // Метод повертає назву інгрідієнту
    public String getIngredientType()
    {
        return ingredientType;
    }

    // Метод встановлює назву інгрідієнту
    public void setIngredientType(String ingredientType)
    {
        this.ingredientType = ingredientType;
    }

    // Метод повертає кількість калорій у 100гр.
    public int getCalories()
    {
        return calories;
    }

    // Метод встановлює кількість калорій у 100гр.
    public void setCalories(int calories)
    {
        this.calories = calories;
    }

    // Метод повертає кількість білків у 100гр.
    public int getProteins()
    {
        return proteins;
    }

    // Метод встановлює кількість білків у 100гр.
    public void setProteins(int proteins)
    {
        this.proteins = proteins;
    }

    // Метод повертає кількість жирів у 100гр.
    public int getFats()
    {
        return fats;
    }

    // Метод встановлює кількість жирів у 100гр.
    public void setFats(int fats)
    {
        this.fats = fats;
    }

    // Метод повертає кількість вуглеводів у 100гр.
    public int getCarbs()
    {
        return carbs;
    }

    // Метод встановлює кількість вуглеводів у 100гр.
    public void setCarbs(int carbs)
    {
        this.carbs = carbs;
    }

    //Контструктори класу
    public Ingredient(String ingredientName, String ingredientType, int calories, int proteins, int fats, int carbs)
    {
        this.ingredientName = ingredientName;
        this.ingredientType = ingredientType;
        this.calories = calories;
        this.proteins = proteins;
        this.fats = fats;
        this.carbs = carbs;
    }

    public Ingredient(String ingredientName, String ingredientType, int calories)
    {
        this.ingredientName = ingredientName;
        this.ingredientType = ingredientType;
        this.calories = calories;
    }

    public Ingredient()
    {}

    public int compareTo(Ingredient o) {
        return Comparators.NAME.compare(this, o);
    }

    public void printIngerdient(boolean withAllFields)
    {
        System.out.print(getIngredientName());
        if (withAllFields)
        {
            System.out.print(" -  " +getIngredientType());
            System.out.print("  100g contains: " + getCalories() + " calories; ");
            System.out.print(getProteins() + " proteins; ");
            System.out.print(getFats() + " fats; ");
            System.out.println(getCarbs() + " carbs.");
        }
    }

    public static class Comparators {

        public static Comparator<Ingredient> NAME = new Comparator<Ingredient>() {
            @Override
            public int compare(Ingredient i1, Ingredient i2) {
                return i1.ingredientName.compareTo(i2.ingredientName);
            }
        };
        public static Comparator<Ingredient> TYPE = new Comparator<Ingredient>() {
            @Override
            public int compare(Ingredient i1, Ingredient i2) {
                return i1.ingredientType.compareTo(i2.ingredientType);
            }
        };
        public static Comparator<Ingredient> CAL = new Comparator<Ingredient>() {
            @Override
            public int compare(Ingredient i1, Ingredient i2) {
                return (int) (i1.calories - i2.calories);
            }
        };
        public static Comparator<Ingredient> PROTEIN = new Comparator<Ingredient>() {
            @Override
            public int compare(Ingredient i1, Ingredient i2) {
                return (int) (i1.proteins - i2.proteins);
            }
        };
        public static Comparator<Ingredient> FAT = new Comparator<Ingredient>() {
            @Override
            public int compare(Ingredient i1, Ingredient i2) {
                return (int) (i1.fats - i2.fats);
            }
        };
        public static Comparator<Ingredient> CAR = new Comparator<Ingredient>() {
            @Override
            public int compare(Ingredient i1, Ingredient i2) {
                return (int) (i1.carbs - i2.carbs);
            }
        };
    }
}
