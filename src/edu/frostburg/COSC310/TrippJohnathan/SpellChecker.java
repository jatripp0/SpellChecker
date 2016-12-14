package edu.frostburg.COSC310.TrippJohnathan;

import java.util.ArrayList;

/**
 * A class containing methods to accomplish the spell-checking component of the
 * program. Several special cases are tested and combined in an overall test to
 * check for possible misspellings of a given word. Results are stored in an
 * ArrayList.
 * @author Johnathan Tripp (╯°□°）╯︵ ┻━┻
 */
public class SpellChecker {
    
    private final ArrayList<String> resultsList = new ArrayList<>();
    private final char[] letters = new char[]{'a','b','c','d','e','f','g','h','i','j',
                'k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    private final Dictionary dict;
    
    /**
     * Gets the list containing the results of the test cases
     * @return an ArrayList of Strings
     */
    public ArrayList<String> getResults(){return resultsList;}
    /**
     * Runs all the specialized test cases for the given word, including misplaced
     * and swapped letters, as well as if the word is already correct
     * @param word the word to be tested
     */
    public void testAllCases(String word) {
        if(!isCorrect(word)){
            lettersSwapped(word);
            lettersInserted(word);
            lettersMissing(word);
            incorrectLetter(word);
        }
    }
    /**
     * Public constructor for the SpellChecker class
     * @param dict a Dictionary object for use by the test methods
     */
    public SpellChecker(Dictionary dict) {
        this.dict = dict;
    }
    /**
     * Determines if the given word is spelled correctly
     * @param word the word to be checked
     * @return whether or not the word is spelled correctly
     */
    public boolean isCorrect(String word) {
        return (dict.get(word) != null && dict.get(word).contains(word));
    }
    /**
     * Evaluates all cases where adjacent letters in a word may have been swapped
     * @param word the word to be checked
     */
    private void lettersSwapped(String word) {
        String swapped;
        if(word.length() > 1){
            String swapAtStart = word.substring(1, 2) + word.substring(0, 1) + word.substring(2);
            if(dict.get(swapAtStart) != null)
                if(dict.get(swapAtStart).contains(swapAtStart) && !resultsList.contains(swapAtStart)) resultsList.add(swapAtStart);
            int end = word.length()-1;
            String swapAtEnd = word.substring(0, end-1) + word.substring(end) + word.substring(end-1, end);
            if(dict.get(swapAtEnd) != null)
                if(dict.get(swapAtEnd).contains(swapAtEnd) && !resultsList.contains(swapAtEnd)) resultsList.add(swapAtEnd);
            for(int i=2; i<word.length()-2; i++){
                //swapped = word;
                String first = word.substring(0, i);
                String fSub = word.substring(i, i+1);
                String lSub = word.substring(i+1, i+2);
                String last = word.substring(i+2);
                swapped = first + lSub + fSub + last;
                if(dict.get(swapped) != null)
                    if(dict.get(swapped).contains(swapped) && !resultsList.contains(swapped)) resultsList.add(swapped);
            }
        }
    }
    /**
     * Evaluates whether unnecessary letters have been inserted into a word
     * @param word the word to be checked
     */
    private void lettersInserted(String word) {
        if(word.length() > 1){
            String atStart = word.substring(1);
            String atEnd = word.substring(0, word.length()-1);
            if(dict.get(atStart) != null)
                if(dict.get(atStart).contains(atStart)) resultsList.add(atStart);
            if(dict.get(atEnd) != null)
                if(dict.get(atEnd).contains(atEnd)) resultsList.add(atEnd);
            for(int i=1; i<word.length(); i++){
                String newWord = word.substring(0,i) + word.substring(i+1);
                if(dict.get(newWord) != null)
                    if(dict.get(newWord).contains(newWord) && !resultsList.contains(newWord)) resultsList.add(newWord);
            }
        }
    }
    /**
     * Evaluates whether a word is missing letters
     * @param word the word to be checked
     */
    private void lettersMissing(String word) {
        if(word.length() == 1){
            for(int i=0; i<letters.length; i++){
                String Str1 = letters[i] + word;
                String Str2 = word + letters[i];
                if(dict.get(Str1) != null)
                    if(dict.get(Str1).contains(Str1)) resultsList.add(Str1);
                if(dict.get(Str2) != null)
                    if(dict.get(Str2).contains(Str2)) resultsList.add(Str2);
            }
        } else {
            for(int i=0; i<letters.length; i++){
                char letter = letters[i];
                String atStart = letter + word;
                String atEnd = word + letter;
                if(dict.get(atStart) != null)
                    if(dict.get(atStart).contains(atStart)) resultsList.add(atStart);
                if(dict.get(atEnd) != null)
                    if(dict.get(atEnd).contains(atEnd)) resultsList.add(atEnd);
                for(int j=1; j < word.length(); j++){
                    String midWord = word.substring(0, j) + letter + word.substring(j);
                    if(dict.get(midWord) != null)
                        if(dict.get(midWord).contains(midWord) && !resultsList.contains(midWord)) resultsList.add(midWord);
                }
            }
        } 
    }
    
    /**
     * Evaluates whether an incorrect letter was used in a word
     * @param word the word to be checked
     */
    private void incorrectLetter(String word){
        if(word.length() > 1){
            for(int i=0; i<letters.length; i++){
                char letter = letters[i];
                String atStart = letter + word.substring(1);
                if(dict.get(atStart) != null)
                        if(dict.get(atStart).contains(atStart) && !resultsList.contains(atStart)) resultsList.add(atStart);
                String atEnd = word.substring(0, word.length()-1) + letter;
                if(dict.get(atEnd) != null)
                    if(dict.get(atEnd).contains(atEnd) && !resultsList.contains(atEnd)) resultsList.add(atEnd);
                for(int j=1; j<word.length()-1; j++){
                    String start = word.substring(0, j);
                    String end = word.substring(j+1);
                    String switchedLetter = start + letter + end;
                    if(dict.get(switchedLetter) != null)
                        if(dict.get(switchedLetter).contains(switchedLetter) && !resultsList.contains(switchedLetter)) resultsList.add(switchedLetter);
                }
            }
        }
    }
}
