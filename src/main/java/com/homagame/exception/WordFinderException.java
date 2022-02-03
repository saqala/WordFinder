package com.homagame.exception;

public class WordFinderException extends RuntimeException{

    public static final String MISSING_ARGUMENTS = "missing arguments";
    public static final String THE_INJECTED_WORD_IS_NOT_CORRECT = "the injected word %s is not correct";

    public WordFinderException(String message) {
        super(message);
    }

    public static WordFinderException create(String message) {
        return new WordFinderException(message);
    }
}
