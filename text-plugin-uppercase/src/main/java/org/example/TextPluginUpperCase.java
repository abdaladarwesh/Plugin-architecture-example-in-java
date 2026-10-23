package org.example;

public class TextPluginUpperCase implements TextPlugin{
    @Override
    public String processText(String text) {
        return text.toUpperCase();
    }
}
