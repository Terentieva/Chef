package com.epam.cdp.tetiana_terentieva.java.lesson7.task4.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Created by Таня on 29.07.2014.
 */
public abstract class Food{
    public String foodName;
    public ArrayList<Map.Entry<Ingredient, Integer>> foodIngredients;
    protected abstract String getFoodName();
    protected abstract void  setFoodName(String foodName);
    public abstract ArrayList<Map.Entry<Ingredient, Integer>> getFoodIngredients();
    public abstract void setFoodIngredients(ArrayList<Map.Entry<Ingredient, Integer>> foodIngredients);
}
