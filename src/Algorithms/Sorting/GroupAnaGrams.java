package Algorithms.Sorting;

import java.util.*;
import java.util.stream.Collectors;

public class GroupAnaGrams   {

    public static List<String> sort(String[] strings){
        ArrayList<AnaGram> list = new ArrayList<>();
        ArrayList<String> answer = new ArrayList<>();
        for(String string : strings){
            list.add(new AnaGram(string));
        }

        Collections.sort(list,new AnagramComparator());
        for(AnaGram string : list){
            answer.add(string.val);
        }
        return answer;
    }




}

 class AnaGram {

    public String val;
    public AnaGram(String val){
        this.val = val;
    }
     String sortString(){
         List<Character> chars = val.chars() 				// IntStream
                 .mapToObj(e -> (char)e) 	// Stream<Character>
                 .collect(Collectors.toList());
         Collections.sort(chars);

         StringBuilder sb = new StringBuilder();

         // Appends characters one by one
         for (Character ch : chars) {
             sb.append(ch);
         }

         // convert in string
         return sb.toString();


     }

}

class AnagramComparator implements Comparator<AnaGram> {

    @Override
    public int compare(AnaGram o1, AnaGram o2) {
        return o1.sortString().compareTo(o2.sortString());
    }
}
