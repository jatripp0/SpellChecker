package edu.frostburg.COSC310.TrippJohnathan;

/**
 * A class which implements the Map ADT and represents the HashSet for the Spell
 * Checker program.
 * @author Johnathan Tripp (╯°□°）╯︵ ┻━┻
 */
public class Dictionary implements MapADT<String,String> {

    private final int capacity = 42709;
    private int size; //the number of entries in the map
    private SinglyLinkedList<String>[] entries = new SinglyLinkedList[capacity]; //array of separate chained values that represent map entries
    
    /**
     * Gets the size of the set
     * @return the sie of the set
     */
    @Override
    public int size() {return size;}
    /**
     * Determines whether or not the set is empty
     * @return whether or not the set is empty
     */
    @Override
    public boolean isEmpty() {return size==0;}
    /**
     * Gets the value, in this case a singly-linked list, from the HashSet at the
     * given key
     * @param key the key value for the HashSet entry
     * @return The value from the HashSet or null if none is present
     */
    @Override
    public SinglyLinkedList<String> get(String key) {
        int keyIndex = hashValue(key);
        if(entries[keyIndex] == null) return null;
        return entries[keyIndex];
    }
    /**
     * Puts the given value in the HashSet at the position specified by the key
     * @param key the key to specify the position in the HashSet
     * @param value the value to be placed in the HashSet
     */
    @Override
    public void put(String key, String value) {
        int keyIndex = hashValue(key);
        if(entries[keyIndex] == null){ //if there are no vallues in the current position, creates a new separate chain
            entries[keyIndex] = new SinglyLinkedList<>();
            entries[keyIndex].addLast(value);
            size++;
        } else {
            if(!entries[keyIndex].contains(value)){
                entries[keyIndex].addLast(value);
                size++;
            }
        }
    }
    /**
     * Method to remove the value from the HashSet at the position specified by
     * a key value
     * @param key the key specifying the position in the HashSet to remove from
     * @return the removed value
     */
    @Override
    public String remove(String key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    /**
     * Method to return an iterable collection containing the keys of the HashSet
     * @return an iterable collection of keys
     */
    @Override
    public Iterable<String> keySet() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    /**
     * Method to return an iterable collection containing the values of the HashSet
     * @return an iterable collection of values
     */
    @Override
    public Iterable<String> values() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    /**
     * Method to return an iterable collection containing the entries of the HashSet
     * @return an iterable collection of entries
     */
    @Override
    public Iterable<Entry<String, String>> entrySet() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    /**
     * Generates a hash value for the specified key to be placed into the HashSet
     * @param key the key to be hashed
     * @return the hashed value as an integer
     */
    @Override
    public int hashValue(String key) {
        return (int)Math.abs(key.hashCode()%capacity);
    }

}
