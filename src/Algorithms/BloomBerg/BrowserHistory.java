package Algorithms.BloomBerg;

import java.util.ArrayList;
import java.util.List;

public class BrowserHistory {
    int pointer;
    List<String> list;

    public BrowserHistory(String homepage) {
        pointer = 0;
        list = new ArrayList<>();
        list.add(homepage);
    }

    public void visit(String url) {
        // get rid of all elements in front of the pointer
        if(pointer < list.size()-1) {
            list = list.subList(pointer, list.size());
        }

        list.add(url);
        pointer +=1;
    }

    public String back(int steps) {
        if(pointer - steps < 0) {
            pointer = 0;
            return list.get(0);
        }

        pointer -= steps;
        return list.get(pointer);
    }

    public String forward(int steps) {
        if(pointer + steps > list.size()-1) {
            pointer = list.size() -1;
            return list.get(list.size()-1);
        }

        pointer += steps;
        return list.get(pointer);
    }
}
