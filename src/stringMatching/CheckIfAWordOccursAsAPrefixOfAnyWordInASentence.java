package stringMatching;

import java.util.Arrays;

public class CheckIfAWordOccursAsAPrefixOfAnyWordInASentence {

    public int isPrefixOfWord(String sentence, String searchWord) {

        for (int i = 0; i < sentence.split(" ").length; i++) {
            if (sentence.split(" ")[i].startsWith(searchWord)) {
                return i + 1;
            }
        }
        return -1;
    }
}
