import java.util.*;
public class HashTableArray {
    public static void main(String[] void) {

    }
    //creates an Entry class in the HashTableArray with the type
    // K and V, corresponding to key and value;
    public class Entry<K, V> {
        K key;
        V value;

        //creates a constructor of type Entry with key and value
        public Entry (K key, V value) {
            this.key = key;
            this.value = value;
        }
        // returns the key in the Entry
        public K getKey() {
            return key;
        }
        //returns the value in the Entry
        public V getValue() {
            return value;
        }
        //Sets the value in the Entry
        public void setValue(V value) {
            this.value = value;
        }
    }
    // builds the array of entries
    public class HTArray<Entry> {
        // keeps track of the size of the HashTableArray
        private int size;
        //Notes that the capacity is 16 to start with for
        // the HashTableArray
        private int defaultCap = 16;
        //Creates an array of Entry called values with size of defaultCap
        private Entry<K, V>[] values = new Entry[defaultCap];

    }

    //create get method
    public V get (K key) {
        for (int i = 0; i < size; i++) {
            if (values[i] != null) {
                if (values[i].getKey().equals(key)) {
                    return values.[i].getValue();
                }
            }
        }
        return null;
    }
    //create put method
    public void put(K key, V value) {
        boolean insert = true;
        for (int i = 0; i < size; i++) {
            // checks to see if the key is already in the HTArray
            if(values[i].getKey().equals(key)) {
                //if it is, we reset the value to the new value
                values[i].setValue(value);
                //mark insertion as false
                insert = false;
            }
        }
        //if the insert remained true, that means it does not already exist
        if(insert) {
            //check that we have the capacity to add more elements
            ensureCapacity();
            //increase the number of values' elements, add key, value pair
            values[size++] = new Entry<K, V>(key, value);
        }
    }

    public int size() {
        return size;
    }

    //ensure there is space left in the HTArray
    private void ensureCapacity() {
        if (size == values.length) {
            int newSize = values.length * 2;
            // copies the elements from values with the newSize into values
            values = Arrays.copyOf(values, newSize);
        }
    }

}