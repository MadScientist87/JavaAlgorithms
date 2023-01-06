package Algorithms.LinkedLists;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;


public class LRUCache {
    int capacity = 0;
    HashMap<Integer,Node> set;
    Node head = new Node();
    Node tail = new Node();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.head.next = tail;
        this.tail.prev = head;
        this.set = new HashMap<>();
    }

    public int get(int key) {
        if(set.containsKey(key)) {
            Node nodeToRemove = set.get(key);
            remove(nodeToRemove);
            add(nodeToRemove);
            return nodeToRemove.value;
        }

        return -1;
    }

    public void put(int key, int value) {
        if(!set.containsKey(key)) {
            if(set.size() == capacity) {
                // need to remove the key here
                set.remove(tail.prev.key);
                remove(tail.prev);
            }
            Node nodeToAdd = new Node(value, key);
            add(nodeToAdd);
            set.put(key, nodeToAdd);
        }
        else {
            remove(set.get(key));
            Node nodeToAdd = new Node(value, key);
            add(nodeToAdd);
            set.put(key, nodeToAdd);
        }
    }

    public void add (Node node) {
        Node afterNode = head.next;
        head.next = node;
        node.next = afterNode;
        node.prev = head;
        afterNode.prev = node;
    }

    public void remove(Node node) {
        if(node != head && node != tail) {
            Node destination = node.next;
            Node source = node.prev;
            source.next = destination;
            destination.prev = source;
        }
    }
}

class Node {
    Integer value;
    Integer key;
    Node next = null;
    Node prev = null;

    Node(int value, int key) {
        this.key = key;
        this.value = value;
    }
    Node() {

    }

}
