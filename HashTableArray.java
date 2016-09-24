import java.util.*;
public class HashTableArray {
    public static void main(String[] args) {
        HTArray<Integer, String> ht = new HTArray<Integer, String>();
        ht.put(1, "Savannah");
        ht.put(2, "William");
        ht.put(3, "Hello");
        System.out.println(ht);
    }

    // builds the array of entries
    public static class HTArray<K, V> {
        //creates an Entry class in the HashTableArray with the type
        // K and V, corresponding to key and value;
        public class Entry {
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
        // keeps track of the size of the HashTableArray
        private int size;
        //Notes that the capacity is 16 to start with for
        // the HashTableArray
        private int defaultCap = 16;
        //Creates an array of Entry called values with size of defaultCap
        private Entry[] values =  (Entry[]) new Object [defaultCap];

        //create get method
        public V get (K key) {
            int location = hashFunction(key);
            for (int i = 0; i < values.length; i++) {
                int index = (location + i) % values.length;
                if (values[index] == null) {
                    return null;
                } else {
                    if (key.equals(values[index].getKey())) {
                        return values[index].getValue();
                    }
                }
            }
            return null;
        }

        //create put method
        public void put(K key, V value) {
            int location = hashFunction(key);
            for (int i = 0; i < values.length; i++) {
                int index = (location + i) % values.length;
                if (values[index] != null) {
                    if (values[index].equals(key)) {
                        values[index].setValue(value);
                        return;
                    }
                } else {
                    values[index] = new Entry(key, value);
                    size++;
                    ensureCapacity();
                }
            }
        }

        public int size() {
            return size;
        }

        //ensure there is space left in the HTArray
        private void ensureCapacity() {
            if (size == values.length) {
                int newSize = values.length * 2;
                resize(newSize);
            }
        }

        private void resize(int cap) {
            Entry oldArray[] = values;
            values = (Entry[]) new Object[cap];

            for (int i = 0; i < oldArray.length; i++) {
                put(oldArray[i].getKey(), oldArray[i].getValue());
            }
        }

        private int hashFunction(K key) {
            //any key converted to HTArray index
            return key.hashCode() % values.length;
        }

    }
}