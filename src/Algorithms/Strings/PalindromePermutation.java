package Algorithms.Strings;
import java.util.ArrayList;
import java.util.HashSet;
public class PalindromePermutation {

    public static HashSet<String> h = new HashSet<>();
    public static ArrayList<String> GetListOfPalindromes(String phrase, int l, int r)
    {
        phrase = phrase.toLowerCase();
        ArrayList<String> list = new ArrayList<>();
        GeneratePermutation(phrase, l,r);
        for (String permutation:
             h) {
            if(IsPalindrome(permutation.replaceAll("\\s","")))
                list.add(permutation);
        }
        return list;
    }

    public static void GeneratePermutation(String phrase, int l, int r) {
        if (l == r)
            h.add(phrase);

        for (int i = l; i <= r; i++)
        {
            phrase = Swap(phrase, l,i);
            GeneratePermutation(phrase, l+1,r);
            phrase = Swap(phrase, l,i);
        }
    }

    public static boolean IsPalindrome(String phrase){
        int tail = phrase.length() - 1;
        char [] array = phrase.toCharArray();

        for(int i =0; i <= phrase.length()/2; i++)
        {
            if (array[i] != array[tail])
                return false;
            tail--;
        }
        return true;
    }

    public static String Swap(String phrase,int indexOne, int indexTwo )
    {
        char[] array = phrase.toCharArray();
        char temp = array[indexTwo];
        array[indexTwo] = array[indexOne];
        array[indexOne] = temp;

        return new String(array);

    }
}
