package com.homagame;

import java.util.logging.Logger;

public class TaskWordFinder {
    public static final String MISSING_ARGUMENTS = "missing arguments";
    public static final String LOGEST_WORD = "logest word : ";
    static Logger LOGGER = Logger.getLogger(TaskWordFinder.class.getName());

    public static void main(String[] args){
        if(args == null || args.length !=2){
            throw new RuntimeException(MISSING_ARGUMENTS);
        }
        String path = args[0];
        String word = args[1];

        WordFinder wf = new WordFinder(path);
        String longest = wf.longestWord(word);

        LOGGER.info(()-> LOGEST_WORD + longest);

    }
}
