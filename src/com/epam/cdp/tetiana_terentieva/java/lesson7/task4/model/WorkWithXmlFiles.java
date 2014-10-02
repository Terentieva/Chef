package com.epam.cdp.tetiana_terentieva.java.lesson7.task4.model;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;


/**
 * Created by Таня on 18.08.2014.
 */
public class WorkWithXmlFiles extends Files {

    private static int convertFromStringToInteger(String value)
    {
        return Integer.parseInt(value);
    }

    @Override
    public ArrayList<Ingredient> readFromFile()
    {
        ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();

        try
        {
            File fXmlFile = new File(fileName);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            fileExist = true;

            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("ingredient");
            for (int i = 0; i< nList.getLength(); i++)
            {
                Node nNode = nList.item(i);
                Ingredient ingredient = new Ingredient();
                if (nNode.getNodeType() == Node.ELEMENT_NODE)
                {
                    Element element = (Element) nNode;
                    ingredient.setIngredientName(element.getAttribute("name"));
                    ingredient.setIngredientType(element.getElementsByTagName("type").item(0).getTextContent());
                    ingredient.setCalories(convertFromStringToInteger(element.getElementsByTagName("calories").item(0).getTextContent()));
                    ingredient.setProteins(convertFromStringToInteger(element.getElementsByTagName("proteins").item(0).getTextContent()));
                    ingredient.setFats(convertFromStringToInteger(element.getElementsByTagName("fats").item(0).getTextContent()));
                    ingredient.setCarbs(convertFromStringToInteger(element.getElementsByTagName("carbs").item(0).getTextContent()));
                }
                ingredients.add(ingredient);
            }


        }catch (FileNotFoundException e)
        {
            System.out.println("File does not found");
            fileExist = false;
        }
        catch (NullPointerException e)
        {
            System.out.println("File does not found");
            fileExist = false;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            fileExist = false;
        }

        return ingredients;
    }

}
