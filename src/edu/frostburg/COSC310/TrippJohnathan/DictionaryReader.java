package edu.frostburg.COSC310.TrippJohnathan;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * File reader method to read the project input file as a list for placement into
 * a hash map.
 * @author Johnathan Tripp (╯°□°）╯︵ ┻━┻
 */
public class DictionaryReader {
    
    /**
     * Returns a list of string values containing the lines of the specified file
     * @param fpath the path of the input file
     * @return a list containing the lines of the input file
     * @throws IOException exception thrown when file cannot be read
     */
    public static List<String> readFile(String fpath) throws IOException{
        
        return Files.readAllLines(Paths.get(fpath).toAbsolutePath());
    }
}
