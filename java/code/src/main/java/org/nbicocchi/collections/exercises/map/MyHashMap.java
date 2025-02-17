package org.nbicocchi.collections.exercises.map;

/**
 * Implementation of a simplified HashMap
 *
 * @author Nicola Bicocchi
 */
class MyHashMap_HashEntry {
    private final Object key;
    private final Object value;

    MyHashMap_HashEntry(Object key, Object value) {
        this.key = key;
        this.value = value;
    }

    public Object getKey() {
        return key;
    }

    public Object getValue() {
        return value;
    }
}

public class MyHashMap implements MyMap {
    private final static int TABLE_SIZE = 8;
    MyHashMap_HashEntry[] table;

    public MyHashMap() {
        table = new MyHashMap_HashEntry[TABLE_SIZE];
        for (int i = 0; i < TABLE_SIZE; i++)
            table[i] = null;
    }

    public Object get(Object key) {
        int hash = (key.hashCode() % TABLE_SIZE);
        while (table[hash] != null && table[hash].getKey() != key)
            hash = (hash + 1) % TABLE_SIZE;
        if (table[hash] == null)
            return -1;
        else
            return table[hash].getValue();
    }

    public void put(Object key, Object value) {
        int hash = (key.hashCode() % TABLE_SIZE);
        while (table[hash] != null && table[hash].getKey() != key)
            hash = (hash + 1) % TABLE_SIZE;
        table[hash] = new MyHashMap_HashEntry(key, value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < TABLE_SIZE; i++) {
            try {
                Object key = table[i].getKey();
                Object value = table[i].getValue();
                sb.append("bucket ").append(i).append(" --> (").append(key).append(", ").append(value).append(")");
            } catch (NullPointerException e) {
                sb.append("bucket ").append(i).append(" --> null");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}