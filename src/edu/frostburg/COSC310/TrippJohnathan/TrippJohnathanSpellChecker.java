package edu.frostburg.COSC310.TrippJohnathan;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * Driver class for the Spell Checker program
 * @author Johnathan Tripp (╯°□°）╯︵ ┻━┻
 */
public class TrippJohnathanSpellChecker {

    private static final String fPath = "../lexicon.txt";
    private static final Dictionary correctWords = new Dictionary();
    private static ArrayList<String> results;
    /**
     * Main method for the Spell Checker program
     * @param args arguments for the main method
     */
    public static void main(String[] args) {
        Scanner userIn = new Scanner(System.in);
        boolean cont = true;
        String inputWord;
        try{
            //Generates a list containing the words from the input file
            List<String> words = DictionaryReader.readFile(fPath);
            for(String s : words){
                s = s.toLowerCase();
                correctWords.put(s, s); //puts each word from the input file into the dictionary (lowercase)
            }
            SpellChecker spellCheck = new SpellChecker(correctWords);
            while(cont){ //run while the user has not decided to exit
                System.out.println("Enter a word to check its spelling or type x to close the program.");
                inputWord = userIn.nextLine().trim();
                if(inputWord.toLowerCase().equals("x")){ //exit if the user presses 'x'
                    cont = false;
                    continue;
                }
                spellCheck.testAllCases(inputWord); //test the word against all spell-check cases
                results = spellCheck.getResults(); //obtain the results of the spell-checking process
                if(results.isEmpty()){ //if the word is already spelled correctly
                    System.out.println(inputWord + " is spelled correctly.");
                } else { //display the list of suggested alternative spellings for the word
                    System.out.println("\nSuggestions (" + results.size() + "):");
                    for(String s : results){
                        System.out.println(s);
                    }
                }
                results.clear(); //clear the list of results for the next word to be checked, if any
            }
        } catch (IOException e){ //handle exceptions where the input file cannot be read
            System.out.println("Could not find file. Please check to make sure the input file is in the parent directory.\n"
                    + "See the README file for more details.");
            System.exit(0);
        }
    }    
}
