package com.code.diy;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class DIY_HashMap {

    transient Node[] table;
    transient int size;
    int initCapacity = 64;
    transient int capacity = initCapacity;
    class Node {

        int hash;
        String key;
        String value;
        Node next;

        public Node(String key, String value) {
            this.key = key;
            this.value = value;
            this.hash = hash(key);
        }
    }

    class TreeiNode extends Node {

        String key;
        String value;

        TreeiNode left;
        TreeiNode right;

        public TreeiNode(String key, String value) {
            super(key, value);
        }
    }

    void put(String key, String value) {
        putVal(key, value, table, capacity);

        if (size / capacity > 0.75) {
            resize();
        }
    }

    private void putVal(String key, String value, Node[] table, int capacity) {
        int position = hash(key) % capacity;
        if (table == null) {
            table = new Node[initCapacity];
            table[position] = new Node(key, value);
        } else if (table[position] == null) {
            table[position] = new Node(key, value);
        } else if (table[position] instanceof TreeiNode) {
            TreeiNode root = (TreeiNode) table[position];
            insertTreeiNode(root, key, value);
        } else {
            Node node = table[position];
            int height = 0;
            while (node != null) {
                if (Objects.equals(node.key, key)) {
                    node.value = value;
                    return;
                } else if (node.next == null) {
                    node.next = new Node(key, value);
                    break;
                }
                node = node.next;
                height++;
            }
            if (height > 8) {
                TreeiNode root = treeify(node);
                table[position] = root;
            }
        }
        size++;
    }

    private TreeiNode treeify(Node node) {
        if (node == null) {
            return null;
        }
        TreeiNode root = new TreeiNode(node.key, node.value);
        node = node.next;
        while (node != null) {
            insertTreeiNode(root, node.key, node.value);
        }
        return root;
    }

    private void insertTreeiNode(TreeiNode root, String key, String value) {
        int hash = hash(key);
        while (root != null) {
            if (Objects.equals(root.key, key)) {
                root.value = value;
                break;
            } else if (root.hash > hash) {
                if (root.left == null) {
                    root.left = new TreeiNode(key, value);
                } else {
                    root = root.left;
                }
            } else {
                if (root.right == null) {
                    root.right = new TreeiNode(key, value);
                } else {
                    root = root.right;
                }
            }
        }
    }

    private void resize() {
        int nextCapacity = capacity * 2;
        Node[] nextTable = new Node[nextCapacity];
        for (int i = 0; i < table.length; i++) {
            putVal(table[i].key, table[i].value, nextTable, nextCapacity);
        }
    }


    String get(String key) {
        int position = hash(key) % capacity;
        Node node = table[position];
        if (node == null) {
            return null;
        }

        if (node instanceof TreeiNode) {
            return findTreeNode((TreeiNode) node, key);
        } else {
            while (node != null) {
                if (Objects.equals(key, node.key)) {
                    return node.value;
                }
                node = node.next;
            }
            return null;
        }
    }

    private String findTreeNode(TreeiNode root, String key) {
        int hash = hash(key);
        while (root != null) {
            if (Objects.equals(root.key, key)) {
                return root.value;
            } else if (root.hash > hash) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return null;
    }

    int hash(String key) {
        return key.hashCode();
    }
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
    }
}
