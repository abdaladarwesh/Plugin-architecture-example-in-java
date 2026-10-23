package org.example;

import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;

public class Main {

    public static void main(String[] args) throws MalformedURLException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        CustomClassLoader customClassLoader = new CustomClassLoader("plugins/text-plugin-uppercase-1.0-SNAPSHOT.jar");
        TextPlugin upperCasePlugin = customClassLoader.getPlugin("org.example.TextPluginUpperCase");
        System.out.println(upperCasePlugin.processText("Abdullah"));
    }
}