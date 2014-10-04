package com.epam.cdp.tetiana_terentieva.java.lesson7.task4.model;

import java.util.ArrayList;

/**
 * Created by Таня on 19.08.2014.
 */
public abstract class Files {

    public String fileName;
    public boolean fileExist;
    public abstract ArrayList readFromFile();
    public abstract void setFileName(String fileName);

}
