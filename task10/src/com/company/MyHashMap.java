package com.company;

import java.util.HashSet;

public class MyHashMap<K, V> {
    private Entry<K, V> hmap[];
    private double loadFactor;
    private int capacity;
    private int size = 0;
    private int maxLength;

    public MyHashMap() {
        this(10, 0.7);
    }

    public MyHashMap(int capacity, double loadFactor) {
        this.capacity = capacity;
        this.loadFactor = loadFactor;
        this.maxLength = (int) (1.0 / (1.0 - loadFactor));
        hmap = new Entry[capacity];
    }

    public void put(K key, V value) {
        int index = Math.abs(key.hashCode() % capacity);
        put(key, value, index);
    }

    public void put(K key, V value, int index) {
        Entry<K, V> entry = new Entry<>(key, value);
        Entry<K, V> curr = hmap[index];
        int i = 0;
        if (hmap[index] == null) {
            hmap[index] = entry;
        } else if (hmap[index].getNext() != null) {
            while (curr.getNext() != null) {
                curr = curr.getNext();
                i++;
            }
            if (maxLength <= i) {
                doubleHashing(key, value, index);
            } else {
                curr.setNext(entry);
            }
        } else {
            hmap[index].setNext(entry);
        }
        size++;
        if (!isEmpty()) {
            reHashing();
        }
    }

    public void doubleHashing(K key, V value, int index) {
        int i = 0;
        i += (index + 5) % capacity;
        if (i > capacity) {
            i = i - capacity;
        }
        put(key, value, i);
    }

    public void reHashing() {
        capacity = capacity * 2;
        Entry<K, V>[] temp = hmap;
        Entry<K, V> cur;
        hmap = null;
        hmap = new Entry[capacity];
        //System.out.println(capacity);
        for (int j = 0; j < capacity / 2; j++) {
            if (temp[j] == null)
                continue;
            int index = Math.abs(temp[j].getKey().hashCode() % capacity);
            System.out.println("--------" + temp[j].getKey() + "---" + temp[j].getValue() + "--" + index);
            put(temp[j].getKey(), temp[j].getValue(), index);
            if (temp[j].getNext() != null) {
                cur = temp[j].getNext();
                while (cur != null) {
                    int ind = Math.abs(cur.hashCode() % capacity);
                    System.out.println("--------" + cur.getKey() + "---" + cur.getValue() + "--" + ind);
                    put(cur.getKey(), cur.getValue(), ind);
                    cur = cur.getNext();
                }
            }
        }
    }

    public V find(K key, int index) {
        boolean find = false;
        Entry<K, V> curr = hmap[index];
        if (hmap[index].getKey().equals(key)) {
            find = true;
            return hmap[index].getValue();
        } else if (hmap[index].getNext() != null) {
            while (curr.getNext() != null) {
                if (curr.getNext().getKey().equals(key)) {
                    find = true;
                    return curr.getNext().getValue();
                }
                curr = curr.getNext();
            }
        }
        if (!find) {
            int i = 0;
            while (find) {
                i += (index + 5) % capacity;
                if (i > capacity) {
                    i = i - capacity;
                }
                find(key, i);
            }
        }
        return hmap[index].getValue();
    }

    public V get(K key) {
        int index = Math.abs(key.hashCode() % capacity);
        return find(key, index);
    }

    public void clear() {
        hmap = null;
        hmap = new Entry[capacity];
    }

    public boolean isEmpty() {
        if (size > capacity * 0.75) {
            return false;
        } else return true;
    }

    public void remove(K key, int index) {
        boolean is = false;
        Entry<K, V> curr;
        if (hmap[index].getKey().equals(key)) {
            if (hmap[index].getNext() != null) {
                hmap[index] = hmap[index].getNext();
                is = true;
            } else {
                is = true;
                hmap[index] = null;
            }
        }else {
            curr = hmap[index];
            while (curr.getNext() != null) {
                //System.out.println(curr.getKey());
                if (curr.getNext().getKey().equals(key)) {
                    is = true;
                    curr.setNext(curr.getNext().getNext());
                    break;
                }
                curr = curr.getNext();
            }
            if (!is) {
                int i = 0;
                while (is) {
                    i += (index + 5) % capacity;
                    remove(key, i);
                    if (i > capacity) {
                        i = i - capacity;
                    }
                }
            }
        }
    }

    public void remove(K key) {
        int index = Math.abs(key.hashCode() % capacity);
        remove(key, index);
    }

    void print() {
        for (int i = 0; i < capacity; i++) {
            if (hmap[i] == null)
                System.out.println(i + ") -------");
            else {
                System.out.println(i + ") " + hmap[i].getValue() + " " + hmap[i].getKey());
                if (hmap[i].getNext() != null) {
                    Entry<K, V> curr = hmap[i].getNext();
                    while (curr != null) {
                        System.out.println(i + "--->> NEXT " + curr.getValue() + " " + curr.getKey());
                        curr = curr.getNext();

                    }
                }
            }
        }
    }

    public HashSet<V> setValues() {
        HashSet<V> hashSet = new HashSet<V>();
        Entry<K, V> cur;
        for (int i = 0; i < capacity; i++) {
            if (hmap[i] == null)
                continue;
            hashSet.add(hmap[i].getValue());
            if (hmap[i].getNext() != null) {
                cur = hmap[i];
                while (cur .getNext()!= null) {
                    hashSet.add(cur.getNext().getValue());
                    cur = cur.getNext();
                }
            }
        }
        return hashSet;
    }

    public HashSet<K> setKeys() {
        HashSet<K> hashSet = new HashSet<K>();
        Entry<K, V> cur;
        for (int i = 0; i < capacity; i++) {
            if (hmap[i] == null)
                continue;
            hashSet.add(hmap[i].getKey());
            if (hmap[i].getNext() != null) {
                cur = hmap[i];
                while (cur .getNext()!= null) {
                    hashSet.add(cur.getNext().getKey());
                    cur = cur.getNext();
                }
            }
        }
        return hashSet;
    }
}




