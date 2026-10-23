package org.example;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class CustomClassLoader {

    private URL pluginFileUrl;
    private URLClassLoader pluginClassLoader;

    public CustomClassLoader(String pluginFilePath) throws MalformedURLException {
        pluginFileUrl = getPluginFileUrl(pluginFilePath);
        pluginClassLoader = loadPlugin();

    }

    private URL getPluginFileUrl(String path) throws MalformedURLException {
        return new File(path).toURI().toURL();
    }

    private URLClassLoader loadPlugin(){
        return new URLClassLoader(
                new URL[]{pluginFileUrl},
                this.getClass().getClassLoader()
        );
    }

    public TextPlugin getPlugin(String classPath) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> aClass = pluginClassLoader.loadClass(classPath);
        return (TextPlugin) aClass.getDeclaredConstructor().newInstance();
    }



}
