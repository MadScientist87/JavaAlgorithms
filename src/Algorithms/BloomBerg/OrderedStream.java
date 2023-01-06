package Algorithms.BloomBerg;

import java.util.ArrayList;
import java.util.List;

public class OrderedStream {
    String[] array;
    int ptr;
    public OrderedStream(int n) {
        array = new String[n +1];
        ptr =1;
    }

    public List<String> insert(int idKey, String value) {
        List<String> answer = new ArrayList<>();
        array[idKey] = value;
        while(ptr < array.length && array[ptr] != null){
            answer.add(array[ptr]);
            ptr++;
        }

        return answer;
    }

}
