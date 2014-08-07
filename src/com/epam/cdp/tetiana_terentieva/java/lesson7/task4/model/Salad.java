package com.epam.cdp.tetiana_terentieva.java.lesson7.task4.model;

import com.epam.cdp.tetiana_terentieva.java.lesson7.task4.model.Food;
import com.epam.cdp.tetiana_terentieva.java.lesson7.task4.model.Ingredient;

import java.text.DecimalFormat;
import java.util.*;

/**
 * Created by Таня on 29.07.2014.
 */

public class Salad extends Food {

    protected String getFoodName()
    {
        return this.foodName;
    }

    protected void setFoodName(String foodName)
    {
        this.foodName = foodName;
    }

    public ArrayList<Map.Entry<Ingredient, Integer>> getFoodIngredients()
    {
        return this.foodIngredients;
    }

    public void setFoodIngredients(ArrayList<Map.Entry<Ingredient, Integer>> foodIngredients)
    {
        this.foodIngredients = foodIngredients;
    }

    public String getSaladName()
    {
        return foodName;
    }

    public void setSaladName(String saladName)
    {
        this.foodName = saladName;
    }

    public Salad(String saladName, ArrayList<Map.Entry<Ingredient, Integer>> foodComponents)
    {
        this.foodName = saladName;
        this.foodIngredients = foodComponents;
    }

    public Salad(String saladName)
    {
        this.foodName = saladName;
    }

    protected double calculateCalories()
    {
        double sum = 0;
        for (Map.Entry<Ingredient, Integer> component: foodIngredients)
        {
            sum += component.getValue()*component.getKey().getCalories()/100;
        }
        return sum;
    }

    public void printSalad(boolean withAllFields)
    {
         System.out.println("Salad <<" + getSaladName() + ">>");
         System.out.println("Ingredients: ");
         for (Map.Entry<Ingredient, Integer> component: foodIngredients)
         {
             System.out.print(component.getValue() + "g ");
             component.getKey().printIngerdient(withAllFields);
         }
         System.out.println("Amount of calories: " + new DecimalFormat("00.00").format(calculateCalories()));

     }

    private void rewriteFoodIngredients(ArrayList<Ingredient> ingredientList)
    {
        ArrayList<Map.Entry<Ingredient, Integer>> newIngredientList = new ArrayList<Map.Entry<Ingredient, Integer>>();
        Iterator<Ingredient> list = ingredientList.iterator();
        HashMap<Ingredient, Integer> oldListOfInredients = new HashMap<Ingredient, Integer>(ingredientList.size());
        for(Map.Entry<Ingredient, Integer> c: foodIngredients)
        {
            oldListOfInredients.put(c.getKey(), c.getValue());
        }

        while (list.hasNext())
        {
            Ingredient ing = list.next();
            newIngredientList.add(new AbstractMap.SimpleEntry<Ingredient, Integer>(ing, oldListOfInredients.get(ing)));
        }
        foodIngredients.clear();
        setFoodIngredients(newIngredientList);
    }

    private ArrayList<Ingredient> getIngredientList()
    {
        ArrayList<Ingredient> ingredientList = new ArrayList<Ingredient>();
        for(Map.Entry<Ingredient, Integer>c : foodIngredients)
        {
            ingredientList.add(c.getKey());
        }
        return ingredientList;
    }

    public void sortIngredientsByName()
    {
        ArrayList<Ingredient> ingredientList = getIngredientList();
        Collections.sort(ingredientList, Ingredient.Comparators.NAME);
        rewriteFoodIngredients(ingredientList);
    }

    public void sortIngredientsByType()
    {
        ArrayList<Ingredient> ingredientList = getIngredientList();
        Collections.sort(ingredientList, Ingredient.Comparators.TYPE);
        rewriteFoodIngredients(ingredientList);
    }

    public void sortIngredientsByCalories()
    {
        ArrayList<Ingredient> ingredientList = getIngredientList();
        Collections.sort(ingredientList, Ingredient.Comparators.CAL);
        rewriteFoodIngredients(ingredientList);
    }

    public void sortIngredientsByProteins()
    {
        ArrayList<Ingredient> ingredientList = getIngredientList();
        Collections.sort(ingredientList, Ingredient.Comparators.PROTEIN);
        rewriteFoodIngredients(ingredientList);
    }

    public void sortIngredientsByFats()
    {
        ArrayList<Ingredient> ingredientList = getIngredientList();
        Collections.sort(ingredientList, Ingredient.Comparators.FAT);
        rewriteFoodIngredients(ingredientList);
    }

    public void sortIngredientsByCarbs()
    {
        ArrayList<Ingredient> ingredientList = getIngredientList();
        Collections.sort(ingredientList, Ingredient.Comparators.CAR);
        rewriteFoodIngredients(ingredientList);
    }

}
