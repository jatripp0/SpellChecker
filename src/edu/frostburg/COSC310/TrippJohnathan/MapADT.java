package edu.frostburg.COSC310.TrippJohnathan;

/**
 * Public interface for the Map abstract data type
 * @author Johnathan Tripp (╯°□°）╯︵ ┻━┻
 */
public interface MapADT<K,V> {
    /**
     * Nested interface for an entry in the map
     * @param <K> the key of the entry
     * @param <V> the value of the entry
     */
    public interface Entry<K,V>{
        K getKey();
        V getValue();
    }
    /**
     * Method to obtain a hash value for a key
     * @param key a key to be hashed
     * @return the hash value for the given key
     */
    int hashValue(K key);
    /**
     * Method to obtain the size of the map
     * @return the size of the map
     */
    int size();
    /**
     * Method to determine if a map is empty
     * @return whether or not the map is empty
     */
    boolean isEmpty();
    /**
     * Method to get a value from the map at the position specified by the given key
     * @param key the key to determine the position in the map
     * @return the value at the position specified by the key
     */
    Object get(K key);
    /**
     * Method to put the specified value in the map at the position specified by the given key
     * @param key the key to determine the position in the map
     * @param value the value to be put in the map
     */
    void put(K key, V value);
    /**
     * Method to remove a value from the map at the position specified by the key
     * @param key the key to determine the position in the map
     * @return the value removed from the map
     */
    V remove(K key);
    /**
     * Method to return an iterable collection of the keys of the map
     * @return an iterable collection of keys
     */
    Iterable<K> keySet();
    /**
     * Method to return an iterable collection of the values of the map
     * @return an iterable collection of values
     */
    Iterable<V> values();
    /**
     * Method to return an iterable collection of the entries of the map
     * @return an iterable collection of map entries
     */
    Iterable<Entry<K,V>> entrySet();
}
