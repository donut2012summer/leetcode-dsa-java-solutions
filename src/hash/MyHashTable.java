package hash;


public class MyHashTable<K, V> {

    private final int DEFAULT_CAPACITY = 16;
    private Node<K, V>[] hashTable;

    static class Node<K, V>{

        K key;
        V value;

        // use chaining to solve collision issue
        Node<K, V> next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public MyHashTable() {
        hashTable = new Node[DEFAULT_CAPACITY];
    }

    private int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % DEFAULT_CAPACITY;
    }

    public void put(K key, V value) {
        int index = hash(key);
        Node<K, V> currentNode = hashTable[index];
        Node<K, V> newNode = new Node(key, value);

        if (currentNode == null) {
            hashTable[index] = newNode;
        }

        while (currentNode != null) {
            if (currentNode.key.equals(key)) {
                currentNode.value = value;
                return;
            }

            if (currentNode.next == null) {
                break;
            }
            currentNode = currentNode.next;
        }

        currentNode.next = newNode;
    }

    public V get(K key) {

        int index = hash(key);
        Node<K, V> currentNode = hashTable[index];

        while (currentNode != null) {
            if (currentNode.key.equals(key)) {
                return currentNode.value;
            }
            currentNode = currentNode.next;
        }
        return null;
    }

    public void remove(K key) {
        int index = hash(key);
        Node<K, V> currentNode = hashTable[index];
        Node<K, V> previousNode = null;

        while (currentNode != null) {
            if (currentNode.key.equals(key)) {
                if (previousNode != null) {
                    previousNode.next = currentNode.next;
                }else{
                    hashTable[index] = currentNode.next;
                }
                return;
            }

            previousNode = currentNode;
            currentNode = currentNode.next;
        }
    }




}
