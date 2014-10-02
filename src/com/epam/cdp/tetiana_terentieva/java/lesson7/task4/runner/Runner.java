package com.epam.cdp.tetiana_terentieva.java.lesson7.task4.runner;

import com.epam.cdp.tetiana_terentieva.java.lesson7.task4.model.ActionsWithIngridients;
import com.epam.cdp.tetiana_terentieva.java.lesson7.task4.model.Ingredient;
import com.epam.cdp.tetiana_terentieva.java.lesson7.task4.model.Salad;

import java.util.*;

/**
 * Created by Tetiana Terentieva on 01.08.2014.
 * Variant #4
 */
public class Runner {

    public  static void main(String[] args)
    {
        ArrayList<Ingredient> listOfIngredients = ActionsWithIngridients.fillListOfIngredients();
        if (listOfIngredients.size()>0)
        {
            ArrayList<Salad> listOfSalads = ActionsWithIngridients.getSalads(listOfIngredients);
            boolean toBeContinue = true;
            while (toBeContinue) {
                System.out.println("Select menu item");
                System.out.println("1 - Print; 2 - Sort; 3 - Search; 4 - Comparative Analysis; 0 - Exit");
                int item = new Scanner(System.in).nextInt();
                switch (item) {
                    case 0: toBeContinue = false; break;
                    case 1: ActionsWithIngridients.printSalads(listOfSalads, true); break;
                    case 2: {
                        System.out.println("Select field for sorting.");
                        System.out.println("1 - Name; 2 - Type; 3 - Calories; 4 - Proteins; 5 - Fats; 6 - Carbs.");
                        ActionsWithIngridients.sortSalads(listOfSalads, new Scanner(System.in).nextInt());
                        ActionsWithIngridients.printSalads(listOfSalads, true);
                        break;
                    }
                    case 3: ActionsWithIngridients.ingredientSearch(listOfSalads); break;
                    case 4: ActionsWithIngridients.comparativeAnalysis(); break;
                }

                if (item >0) {
                    System.out.println("Do you want to continue? (y/n)");
                    String answer = new Scanner(System.in).nextLine();
                    if (answer.equals("y") || answer.equals("yes")) toBeContinue = true;
                    else toBeContinue = false;
                }
            }
       }
    }
}
