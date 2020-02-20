package com.code.syntax;


public class OpenAddressHashMap<K, V> {
    int capacity = 16;
    int size = 0;
    Node<K, V>[] nodes;

    class Node<K, V> {
        K key;
        V value;
        Node pre;
        Node next;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    OpenAddressHashMap(int capacity) {
        this.capacity = capacity;
        this.nodes = new Node[capacity];
    }

    OpenAddressHashMap() {
        this.nodes = new Node[capacity];
    }

    public V get(K key) {
        int hashCode = key.hashCode();
        //int pos = hashCode % capacity;
        int pos = hashCode & (capacity - 1);
        Node tmpNode = nodes[pos];
        while (tmpNode != null) {
            if (tmpNode.key.equals(key)) {
                return (V)tmpNode.value;
            }
            tmpNode = tmpNode.next;
        }
        return null;
    }

    public void put(K key, V value) {
        int hashCode = key.hashCode();
        int pos = hashCode % capacity;
        Node tmpNode = nodes[pos];
        if (tmpNode == null) {
            nodes[pos] = new Node<>(key, value);
            size++;
        } else {
            Node preNode = null;
            while (tmpNode != null) {
                if (tmpNode.key.equals(key)) {
                    tmpNode.value = value;
                    return;
                }
                preNode = tmpNode;
                tmpNode = tmpNode.next;
            }
            preNode.next = new Node<>(key, value);
            size++;
            preNode.next.pre = preNode;
        }
        if (size > capacity) {
            resize();
        }
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
            Node tmpNode = oldNodes[i];
            while (tmpNode != null) {
                put((K)tmpNode.key, (V)tmpNode.value);
                tmpNode = tmpNode.next;
            }
        }
    }
}
