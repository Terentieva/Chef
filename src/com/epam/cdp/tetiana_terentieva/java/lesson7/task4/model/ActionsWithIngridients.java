package com.epam.cdp.tetiana_terentieva.java.lesson7.task4.model;

import java.util.*;

/**
 * Created by Таня on 29.07.2014.
 */
public class ActionsWithIngridients {

    public static ArrayList fillListOfIngredients()
    {
        ArrayList<Ingredient> listOfIngredients = new ArrayList<Ingredient>();
        WorkWithXmlFiles workWithXmlFiles = new WorkWithXmlFiles();
        workWithXmlFiles.setFileName("./resources/ListOfIngredients.xml");
        listOfIngredients.addAll(workWithXmlFiles.readFromFile());
        return listOfIngredients;
    }

    private static ArrayList<Ingredient> findIngredientsByParam(ArrayList listOfIngredients, int paramNumber, Object paramValue)
    {
        Iterator<Ingredient> fvIt = listOfIngredients.iterator();
        ArrayList<Ingredient> newList = new ArrayList<Ingredient>();
        Ingredient value;
        boolean addNew = false;
        while (fvIt.hasNext())
        {
            value = fvIt.next();
            switch (paramNumber)
            {
                //type
                case 1:
                    if (value.ingredientType.equals(paramValue)) addNew = true;
                    break;
                //calories
                case 2:
                    if (value.calories == paramValue) addNew = true;
                    break;
                //proteins
                case 3:
                    if (value.proteins == paramValue) addNew = true;
                    break;
                //fats
                case 4:
                    if (value.fats == paramValue) addNew = true;
                    break;
                //carbohydrates
                case 5:
                    if (value.carbs == paramValue) addNew = true;
                    break;
                // name
                default:
                    break;
            }
            if (addNew)
              {
                  newList.add(value);
                  addNew = false;
              }
        }

        return newList;
    }

    public static Ingredient findIngredientByParam(Salad salad, HashMap<String, String > setOfTextParams, HashMap<String, Integer > setOfNumbParams)
    {
        boolean addNew = false;
        for (Map.Entry<Ingredient, Integer> component: salad.foodIngredients)
        {
            Ingredient value = component.getKey();
            try {
                String name = setOfTextParams.get("name");
                if (name != null & !name.isEmpty()) {
                    if (value.getIngredientName().equals(name)) addNew = true;
                    else addNew = false;
                }
            }catch (NullPointerException e)
            {}
            try {
                String type = setOfTextParams.get("type");
                if (type != null & !type.isEmpty()) {
                    if (value.getIngredientType().equals(type)) addNew = true;
                    else addNew = false;
                }
            }catch (NullPointerException e)
            {}
            try {
                int cal = setOfNumbParams.get("cal");
                if (value.getCalories() == cal) addNew = true;
                else addNew = false;
            } catch (NullPointerException e)
            {}
            try {
                int prot = setOfNumbParams.get("prot");
                if (value.getProteins() == prot) addNew = true;
                else addNew = false;
             }catch (NullPointerException e)
            {}
            try {
                int fats = setOfNumbParams.get("fats");
                if (value.getFats() == fats) addNew = true;
                else addNew = false;
            }catch (NullPointerException e)
            {}
            try{
                int carbs = setOfNumbParams.get("carbs");
                if (value.getCarbs() == carbs) addNew = true;
                else addNew = false;
            }
            catch (NullPointerException e)
            {}

            if (addNew)return value;
        }

        return null;
    }

    /*public ActionsWithIngridients()
    {
      fillListOfIngredients();
    }*/


    private static Salad createSalad(ArrayList listOfIngredients, String saladName, boolean itsDessert)
    {
        Salad newSalad = new Salad(saladName);
        ArrayList<Map.Entry<Ingredient, Integer>> ingredients = new ArrayList<Map.Entry<Ingredient, Integer>>();
        Random amount = new Random();
        int newAmount;
        if (itsDessert)
        {
            for(Ingredient saladIngredient: findIngredientsByParam(listOfIngredients, 1, "Fruit"))
            {
                newAmount = amount.nextInt(50);
                ingredients.add(new AbstractMap.SimpleEntry<Ingredient, Integer>(saladIngredient, (newAmount != 0)? newAmount: amount.nextInt(50)));
            }

            for(Ingredient saladIngredient: findIngredientsByParam(listOfIngredients, 1, "Milk"))
            {
                newAmount = amount.nextInt(50);
                ingredients.add(new AbstractMap.SimpleEntry<Ingredient, Integer>(saladIngredient, (newAmount != 0) ? newAmount : amount.nextInt(50)));
            }
        }
        else {
            for(Ingredient saladIngredient: findIngredientsByParam(listOfIngredients, 1, "Diet Meat"))
            {
                newAmount = amount.nextInt(50);
                ingredients.add(new AbstractMap.SimpleEntry<Ingredient, Integer>(saladIngredient, (newAmount != 0) ? newAmount : amount.nextInt(50)));
            }

            for(Ingredient saladIngredient: findIngredientsByParam(listOfIngredients, 1, "Sauce"))
            {
                newAmount = amount.nextInt(50);
                ingredients.add(new AbstractMap.SimpleEntry<Ingredient, Integer>(saladIngredient, (newAmount != 0) ? newAmount : amount.nextInt(50)));
            }

            for(Ingredient saladIngredient: findIngredientsByParam(listOfIngredients, 1, "Vegetable"))
            {
                newAmount = amount.nextInt(50);
                ingredients.add(new AbstractMap.SimpleEntry<Ingredient, Integer>(saladIngredient, (newAmount != 0) ? newAmount : amount.nextInt(50)));
            }

        }
        if (ingredients.size()!=0) newSalad.setFoodIngredients(ingredients);
        return newSalad;
    }

    public static ArrayList<Salad> getSalads(ArrayList listOfIngredients)
    {
        ArrayList<Salad> listOfSalads = new ArrayList<Salad>();
        listOfSalads.add(createSalad(listOfIngredients, "Caprice", false));
        listOfSalads.add(createSalad(listOfIngredients, "Fruits salad", true));
        return listOfSalads;
    }

    public static void printSalads(ArrayList<Salad> listOfSalads, boolean withAllFields)
    {
        for(Salad salad : listOfSalads)
        {
            salad.printSalad(withAllFields);
            System.out.println("--------------------------------------------------------------------------------------");
        }
    }

    public static void sortSalads(ArrayList<Salad> listOfSalads, int paramNumber)
    {
        for (Salad salad : listOfSalads) {
            switch (paramNumber) {
                case 1:
                default:{
                    salad.sortIngredientsByName();
                    break;
                }
                case 2: {
                    salad.sortIngredientsByType();
                    break;
                }
                case 3: {
                    salad.sortIngredientsByCalories();
                    break;
                }
                case 4: {
                    salad.sortIngredientsByProteins();
                    break;
                }
                case 5: {
                    salad.sortIngredientsByFats();
                    break;
                }
                case 6: {
                    salad.sortIngredientsByCarbs();
                    break;
                }

            }
        }
    }

    public static void ingredientSearch(ArrayList<Salad> listOfSalads)
    {
        HashMap<String, String> textParams = new HashMap<String, String>();
        HashMap<String, Integer> numbParams = new HashMap<String, Integer>();
        System.out.println("Input parametrs for search.");
        System.out.print("name: ");
        String name = new Scanner(System.in).nextLine();
        if (!name.isEmpty()) textParams.put("name", name);
        System.out.print("type of product: ");
        String type = new Scanner(System.in).nextLine();
        if (!type.isEmpty()) textParams.put("type", type);
        System.out.println("Do you want to enter some of the next params? Select which one:");
        System.out.println("1 - calories; 2 - proteins; 3 - fats; 4 - carbs; 0 - no one");
        switch (new Scanner(System.in).nextInt()) {
            case 0:
                break;
            case 1: {
                System.out.print("calories: ");
                int cal;
                try {
                    cal = new Scanner(System.in).nextInt();
                    numbParams.put("cal", cal);
                } catch (InputMismatchException e) {
                    System.out.print("Calories could not be string. Enter new value:");
                    Scanner sc = new Scanner(System.in);
                    if (sc.hasNextFloat()) numbParams.put("cal", sc.nextInt());
                }
                break;
            }
            case 2: {
                System.out.print("proteins: ");
                int prot;
                try {
                    prot = new Scanner(System.in).nextInt();
                    numbParams.put("prot", prot);
                } catch (InputMismatchException e) {
                    System.out.print("Amount of Proteins could not be string. Enter new value: ");
                    Scanner sc = new Scanner(System.in);
                    if (sc.hasNextFloat()) numbParams.put("prot", sc.nextInt());
                }
                break;
            }
            case 3: {
                System.out.print("fats: ");
                int fats;
                try {
                    fats = new Scanner(System.in).nextInt();
                    numbParams.put("fats", fats);
                } catch (InputMismatchException e) {
                    System.out.print("Amount of Fats could not be string. Enter new value: ");
                    Scanner sc = new Scanner(System.in);
                    if (sc.hasNextFloat()) numbParams.put("fats", sc.nextInt());
                }
                break;
            }
            case 4: {
                System.out.print("carbs: ");
                int carbs;
                try {
                    carbs = new Scanner(System.in).nextInt();
                    numbParams.put("carbs", carbs);
                } catch (InputMismatchException e) {
                    System.out.print("Amount of Carbs could not be string. Enter new value: ");
                    Scanner sc = new Scanner(System.in);
                    if (sc.hasNextFloat()) numbParams.put("carbs", sc.nextInt());
                }
                break;
            }
        }
        Iterator<Salad> salads = listOfSalads.iterator();
        while (salads.hasNext()) {
            Salad salad = salads.next();
            Ingredient searchedIngr = findIngredientByParam(salad, textParams, numbParams);
            if (searchedIngr == null) {
                System.out.print("Such ingredient is not found in  <<" + salad.getSaladName() + ">> salad");
                System.out.println();
            } else {
                System.out.println("Ingredient was found in <<" + salad.getSaladName() + ">> salad");
                searchedIngr.printIngerdient(true);
                System.out.println();
            }
        }
    }

    private static void compareAdditionToDiffCollections()
    {
        System.out.println("Addition:");
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        long start = System.nanoTime();
        for(int i = 10; i<1000; i += 10)
        {
            arrayList.add(i);
        }
        long finish = System.nanoTime();
        System.out.println("   -  to <ArrayList> collection takes " + (finish - start) + " milisec");

        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        start = System.nanoTime();
        for(int i = 10; i<1000; i += 10)
        {
            linkedList.add(i);
        }
        finish = System.nanoTime();
        System.out.println("   -  to <LinkedList> collection takes " + (finish - start) + " milisec");

        HashSet<Integer> hashSet = new HashSet<Integer>();
        start = System.nanoTime();
        for(int i = 10; i<1000; i += 10)
        {
            hashSet.add(i);
        }
        finish = System.nanoTime();
        System.out.println("   -  to <HashSet> collection takes " + (finish - start) + " milisec");

        TreeSet<Integer> treeSet = new TreeSet<Integer>();
        start = System.nanoTime();
        for(int i = 10; i<1000; i += 10)
        {
            treeSet.add(i);
        }
        finish = System.nanoTime();
        System.out.println("   -  to <TreeSet> collection takes " + (finish - start) + " milisec");

        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
        start = System.nanoTime();
        for(int i = 10; i<1000; i += 10)
        {
            hashMap.put("value "+i, i);
        }
        finish = System.nanoTime();
        System.out.println("   -  to <HashMap> collection takes " + (finish - start) + " milisec");

        TreeMap<String, Integer> treeMap = new TreeMap<String, Integer>();
        start = System.nanoTime();
        for(int i = 10; i<1000; i += 10)
        {
            treeMap.put("value "+i, i);
        }
        finish = System.nanoTime();
        System.out.println("   -  to <HashMap> collection takes " + (finish - start) + " milisec");
    }

    private static void compareSearchInDiffCollections()
    {
        long start, finish;
        System.out.println("Search:");
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        for(int i = 10; i<1000; i += 10)
        {
            arrayList.add(i);
        }
        start = System.nanoTime();
        boolean value = arrayList.contains(580);
        finish = System.nanoTime();
        System.out.println("   -  to <ArrayList> collection takes " + (finish - start) + " milisec");

        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        for(int i = 10; i<1000; i += 10)
        {
            linkedList.add(i);
        }
        start = System.nanoTime();
        value = linkedList.contains(710);
        finish = System.nanoTime();
        System.out.println("   -  to <LinkedList> collection takes " + (finish - start) + " milisec");

        HashSet<Integer> hashSet = new HashSet<Integer>();
        for(int i = 10; i<1000; i += 10)
        {
            hashSet.add(i);
        }
        start = System.nanoTime();
        value = hashSet.contains(390);
        finish = System.nanoTime();
        System.out.println("   -  to <HashSet> collection takes " + (finish - start) + " milisec");

        TreeSet<Integer> treeSet = new TreeSet<Integer>();
        for(int i = 10; i<1000; i += 10)
        {
            treeSet.add(i);
        }
        start = System.nanoTime();
        value = treeSet.contains(740);
        finish = System.nanoTime();
        System.out.println("   -  to <TreeSet> collection takes " + (finish - start) + " milisec");

        int intValue;
        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
        for(int i = 10; i<1000; i += 10)
        {
            hashMap.put("value "+i, i);
        }
        start = System.nanoTime();
        intValue = hashMap.get("value 130");
        finish = System.nanoTime();
        System.out.println("   -  to <HashMap> collection takes " + (finish - start) + " milisec");

        TreeMap<String, Integer> treeMap = new TreeMap<String, Integer>();
        for(int i = 10; i<1000; i += 10)
        {
            treeMap.put("value "+i, i);
        }
        start = System.nanoTime();
        intValue = treeMap.get("value 590");
        finish = System.nanoTime();
        System.out.println("   -  to <HashMap> collection takes " + (finish - start) + " milisec");
    }

    private static void compareRemoveFromDiffCollections()
    {
        long start, finish;
        System.out.println("Removing:");
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        for(int i = 10; i<1000; i += 10)
        {
            arrayList.add(i);
        }
        start = System.nanoTime();
        arrayList.clear();
        finish = System.nanoTime();
        System.out.println("   -  to <ArrayList> collection takes " + (finish - start) + " milisec");

        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        for(int i = 10; i<1000; i += 10)
        {
            linkedList.add(i);
        }
        start = System.nanoTime();
        linkedList.clear();
        finish = System.nanoTime();
        System.out.println("   -  to <LinkedList> collection takes " + (finish - start) + " milisec");

        HashSet<Integer> hashSet = new HashSet<Integer>();
        for(int i = 10; i<1000; i += 10)
        {
            hashSet.add(i);
        }
        start = System.nanoTime();
        hashSet.clear();
        finish = System.nanoTime();
        System.out.println("   -  to <HashSet> collection takes " + (finish - start) + " milisec");

        TreeSet<Integer> treeSet = new TreeSet<Integer>();
        for(int i = 10; i<1000; i += 10)
        {
            treeSet.add(i);
        }
        start = System.nanoTime();
        treeSet.clear();
        finish = System.nanoTime();
        System.out.println("   -  to <TreeSet> collection takes " + (finish - start) + " milisec");

        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
        for(int i = 10; i<1000; i += 10)
        {
            hashMap.put("value "+i, i);
        }
        start = System.nanoTime();
        hashMap.clear();
        finish = System.nanoTime();
        System.out.println("   -  to <HashMap> collection takes " + (finish - start) + " milisec");

        TreeMap<String, Integer> treeMap = new TreeMap<String, Integer>();
        for(int i = 10; i<1000; i += 10)
        {
            treeMap.put("value "+i, i);
        }
        start = System.nanoTime();
        treeMap.clear();
        finish = System.nanoTime();
        System.out.println("   -  to <HashMap> collection takes " + (finish - start) + " milisec");
    }


    public static void comparativeAnalysis()
    {
        compareAdditionToDiffCollections();
        compareSearchInDiffCollections();
        compareRemoveFromDiffCollections();
    }
}

