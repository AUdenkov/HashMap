package com.company;

import java.util.Objects;

public class Node<K, V> {
    private int hash;
    private final K key;
    private V value;
    private Node<K, V> nextNode;

    public Node(K key, V value) {
        this.key = key;
        this.value = value;
        this.hash = Math.abs(key.hashCode());
    }

    public int getHash() {
        return hash;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public void setNextNode(Node<K, V> nextNode) {
        this.nextNode = nextNode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node<?, ?> node = (Node<?, ?>) o;
        return hash == node.hash && Objects.equals(key, node.key) && Objects.equals(value, node.value) && Objects.equals(nextNode, node.nextNode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hash, key, value, nextNode);
    }

    @Override
    public String toString() {
        return "Node{" +
                "key=" + key +
                ", value=" + value +
                ", nextNode=" + nextNode +
                '}';
    }
}
