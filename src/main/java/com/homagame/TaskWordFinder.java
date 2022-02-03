package com.homagame;

import com.homagame.exception.WordFinderException;

import java.util.logging.Logger;

public class TaskWordFinder {

    public static final String LOGEST_WORD = "logest word : ";
    static Logger LOGGER = Logger.getLogger(TaskWordFinder.class.getName());

    public static void main(String[] args){
        if(args == null || args.length !=2){
            throw WordFinderException.create(WordFinderException.MISSING_ARGUMENTS);
        }
        String path = args[0];
        String word = args[1];

        WordFinder wf = new WordFinder(path);
        String longest = wf.longestWord(word);

        LOGGER.info(()-> LOGEST_WORD + longest);

    }
}
