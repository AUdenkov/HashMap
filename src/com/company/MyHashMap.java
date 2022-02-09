package com.company;

import java.util.Arrays;
import java.util.LinkedList;

public class MyHashMap<K, V> {
    private LinkedList[] array;
    private int size;
    private int capacity = 16;
    private int maxLoad;

    public MyHashMap() {
        array = new LinkedList[capacity];
        maxLoad = (int) (capacity * 0.75);
    }

    public MyHashMap(int capacity) {
        this.capacity = capacity;
        array = new LinkedList[capacity];
        maxLoad = (int) (capacity * 0.75);
    }

    public V put(K key, V value) {
        if (size + 1 >= maxLoad) {
            doubleSize();
        }
        Node<K, V> node = new Node<>(key, value);
        int position = searchPosition(node.getHash());
        if (array[position] == null) {
            LinkedList linkedList = new LinkedList();
            array[position] = linkedList;
            array[position].add(node);
            size++;
        } else {
            int count = 0;
            Node<K, V> temp = (Node<K, V>) array[position].get(count);
            while (true) {
                if (temp.getHash() == node.getHash()) {
                    if (temp.getKey().equals(node.getKey())) {
                        temp.setValue(node.getValue());
                        break;
                    }
                }
                if (count + 1 == array[position].size()) {
                    array[position].add(node);
                    temp.setNextNode(node);
                    break;
                } else {
                    count++;
                    temp = (Node<K, V>) array[position].get(count);
                }
            }
        }
        return value;
    }

    public boolean remove(K key) {
        int position = searchPosition(key.hashCode());
        if (array[position]==null){
            return false;
        }
        else {
            int count = 0;
            Node<K, V> temp = (Node<K, V>) array[position].get(count);
            while (true) {
                if (temp.getKey().hashCode() == key.hashCode()) {
                    if (temp.getKey().equals(key)) {
                        array[position].remove(count);
                        if (array[position].isEmpty()){
                           array[position]=null;
                        }
                        return true;
                    }
                }
                if (count + 1 == array[position].size()) {
                    break;
                }
                count++;
                temp = (Node<K, V>) array[position].get(count);
            }
        }
        return false;
    }

    public Node<K, V> getNode(K key) {
        int position = searchPosition(key.hashCode());
        int count = 0;
        Node<K, V> temp = (Node<K, V>) array[position].get(count);
        while (true) {
            if (temp.getKey().hashCode() == key.hashCode()) {
                if (temp.getKey().equals(key)) {
                    return temp;
                }
            }
            if (count + 1 == array[position].size()) {
                break;
            }
            count++;
            temp = (Node<K, V>) array[position].get(count);
        }
        return null;
    }

    private int searchPosition(int hash) {
        return hash % capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getSize() {
        return size;
    }

    public void delete() {
    }

    public void doubleSize() {
        capacity = capacity * 2;
        maxLoad = (int) (capacity * 0.75);
        size = 0;
        LinkedList[] newArray = new LinkedList[capacity];
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                continue;
            } else {
                int count = 0;
                Node<K, V> temp = (Node<K, V>) array[i].get(count);
                while (true) {
                    int position = searchPosition(temp.getHash());
                    if (newArray[position] == null) {
                        LinkedList linkedList = new LinkedList();
                        newArray[position] = linkedList;
                        size++;
                    }
                    newArray[position].add(temp);
                    if (count + 1 == array[i].size()) {
                        break;
                    }
                    count++;
                    temp = (Node<K, V>) array[i].get(count);
                }
            }
        }
        array = newArray;

    }

    @Override
    public String toString() {
        return "MyHashMap{" +
                "array=" + Arrays.toString(array) +
                '}';
    }
}
