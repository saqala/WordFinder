package com.homagame;

public class StringHelper {
    private String text;

    public StringHelper(String text) {
        this.text = text;
    }

    public long numberOfOccurrence(char c) {
        return text.chars().filter(ch -> ch == c).count();
    }

    public boolean containChar(char c){
        return text.contains(String.valueOf(c));
    }
}
