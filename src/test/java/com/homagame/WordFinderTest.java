package com.homagame;

import com.homagame.exception.WordFinderException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WordFinderTest {


    public static final String STATIC_DUMMY_ENGLISH_WORDS_FOR_TEST_TXT = "src/main/resources/static/dummy-english-words-for-test.txt";

    @Test
    void check_longest_string_with_atrvle() {
        String word = "atrvle";
        WordFinder wf = new WordFinder(STATIC_DUMMY_ENGLISH_WORDS_FOR_TEST_TXT);
        String longest = wf.longestWord(word);
        assertEquals("travel", longest);
    }

    @Test
    void check_longest_string_return_empty_when_no_word_found() {
        String word = "abcd";
        WordFinder wf = new WordFinder(STATIC_DUMMY_ENGLISH_WORDS_FOR_TEST_TXT);
        String longest = wf.longestWord(word);
        assertEquals("", longest);
    }

    @Test
    void throw_exception_when_word_length_more_than_twelve() {
        String word = "abcdefghijklm";
        WordFinder wf = new WordFinder(STATIC_DUMMY_ENGLISH_WORDS_FOR_TEST_TXT);
        WordFinderException thrown = assertThrows(WordFinderException.class, () -> wf.longestWord(word));
        assertEquals(String.format(WordFinderException.THE_INJECTED_WORD_IS_NOT_CORRECT, word), thrown.getMessage());
    }


}
