package Algorithms.HashMaps;

import java.util.LinkedHashSet;

public class FirstUnique {

    LinkedHashSet<Integer> set;

    public FirstUnique(int[] nums) {
        set = new LinkedHashSet<>();
        for(int num: nums) {
            this.add(num);
        }
    }

    public int showFirstUnique() {
        return set.iterator().next();
    }

    public void add(int value) {
        if(set.contains(value)) {
            set.remove(value);
        }
        else {
            set.add(value);
        }
    }
}
