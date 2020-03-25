package com.mariiapasichna;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Task3 {

    /*
    3*) Написать метод:
    public int uniqueMorseRepresentations(String[] words) {...}
Unique Morse Code Words
International Morse Code defines a standard encoding where each letter is mapped to a series of dots and dashes, as follows:
 "a" maps to ".-", "b" maps to "-...", "c" maps to "-.-.", and so on.
For convenience, the full table for the 26 letters of the English alphabet is given below:
[".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.",
"...","-","..-","...-",".--","-..-","-.--","--.."]
Now, given a list of words, each word can be written as a concatenation of the Morse code of each letter. For example,
"cba" can be written as "-.-..--...", (which is the concatenation "-.-." + "-..." + ".-"). We'll call such a concatenation,
the transformation of a word.
Return the number of different transformations among all words we have.
Example:
Input: words = ["gin", "zen", "gig", "msg"]
Output: 2
Explanation:
The transformation of each word is:
"gin" -> "--...-."
"zen" -> "--...-."
"gig" -> "--...--."
"msg" -> "--...--."
There are 2 different transformations, "--...-." and "--...--.".
*/

    public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    public static final String[] MORSE = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
    public static final Map<Character, String> MORSE_CODE = new TreeMap<>();
    static {
        for (int i = 0; i < ALPHABET.length(); i++) {
            MORSE_CODE.put(ALPHABET.charAt(i), MORSE[i]);
        }
    }
    public static void main(String[] args) {
        String[] words = {"gin", "zen", "gig", "msg"};
        System.out.println(uniqueMorseRepresentations(words));
    }

    private static int uniqueMorseRepresentations(String[] words) {
        if (words == null) {
            return 0;
        }
        Set<String> set = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            char[] word = words[i].toCharArray();
            StringBuilder stringBuilder = new StringBuilder(word.length);
            for (char ch : word) {
                stringBuilder.append(MORSE_CODE.get(ch));
            }
            set.add(stringBuilder.toString());
        }
        return set.size();
    }
}