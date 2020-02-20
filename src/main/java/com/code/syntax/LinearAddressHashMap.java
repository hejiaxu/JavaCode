package com.code.syntax;


public class LinearAddressHashMap<K, V> {
    int capacity;
    int size;
    Node<K, V>[] nodes;

    class Node<K, V> {
        K key;
        V value;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    LinearAddressHashMap(int capacity) {
        this.capacity = capacity;
        this.nodes = new Node[capacity];
    }

    public V get(K key) {
        //线性地址法
        for (int i = 0; i < capacity; i++) {
            //int pos = (key.hashCode() + i) % capacity;
            int pos = key.hashCode() & (capacity - 1);
            if (nodes[pos] == null) {
                return null;
            } else if (nodes[pos].key == key) {
                return nodes[pos].value;
            }
        }

        return null;
    }

    public void put(K key, V value) {
        for (int i = 0; i < capacity; i++) {
            //int pos = (key.hashCode() + i) % capacity;
            int pos = key.hashCode() & (capacity - 1);
            if (nodes[pos] == null) {
                nodes[pos] = new Node(key, value);
                size++;
                return;
            }
            if (nodes[pos].key == key) {
                nodes[pos].value = value;
                return;
            }
        }
        resize();
        put(key, value);
    }

    public int size() {
        return size;
    }

    private void resize() {
        int oldCapacity = capacity;
        capacity *= 2;
        Node[] oldNodes = nodes;
        nodes = new Node[capacity];
        for (int i = 0; i < oldCapacity; i++) {
            put((K)oldNodes[i].key, (V)oldNodes[i].value);
        }
    }
}
