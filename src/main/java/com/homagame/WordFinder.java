package com.homagame;

import com.homagame.exception.WordFinderException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class WordFinder {

    Logger LOGGER = Logger.getLogger(WordFinder.class.getName());
    private List<String> ListOfWords;

    public WordFinder(String dictionaryFileName) {
        ListOfWords = readFileContent(dictionaryFileName);
    }

    private List<String> readFileContent(String dictionaryFileName) {
        try {
            return Files.readAllLines(Paths.get(dictionaryFileName));
        } catch (IOException e) {
            LOGGER.log(Level.WARNING, e.getMessage(), e);
            return Collections.emptyList();
        }
    }

    public String longestWord(String word) {
        validate(word);
        StringHelper wordHelper = new StringHelper(word);
        List<String> possibleWords = ListOfWords.stream().filter(charExistAndHasMinimumOccurrence(wordHelper)).collect(Collectors.toList());
        return possibleWords.stream().max(Comparator.comparingInt(String::length)).orElse("");
    }

    private void validate(String word) {
        if(word == null || word.length() > 12 || !word.matches("[a-z]+")){
            throw WordFinderException.create(String.format(WordFinderException.THE_INJECTED_WORD_IS_NOT_CORRECT, word));
        }
    }

    private Predicate<String> charExistAndHasMinimumOccurrence(StringHelper wordHelper) {
        return text -> {
            StringHelper textHelper = new StringHelper(text);
            return text.chars().mapToObj(i -> (char) i).allMatch(character ->
                    wordHelper.containChar(character) && textHelper.numberOfOccurrence(character) <= wordHelper.numberOfOccurrence(character)
            );
        };
    }
}
