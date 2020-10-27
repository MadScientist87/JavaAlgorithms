package Algorithms.LinkedLists;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

public class LRUCache {
    int capacity = 0;
    HashMap<Integer,Integer> set;
    Deque<Integer> ll;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.set = new HashMap<Integer,Integer>();
        this.ll = new LinkedList();
    }

    public int get(int key) {
        if(set.containsKey(key)){
            ll.remove(key);
            ll.add(key);
            return set.get(key);
        }
        else return -1;
    }

    public void put(int key, int value) {

        if(set.size() == capacity){
            int last= ll.removeLast();
            set.remove(last);
        }
        if(!set.containsKey(key)){

            ll.add(key);

            set.put(key,value);
        }
        else{
            ll.remove(key);
            ll.add(key);
        }
    }

}
