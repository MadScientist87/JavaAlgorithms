package Algorithms.Strings;

import java.util.Arrays;

public class ReOrganizeString {
    public static String reorganizeString(String S) {
        int[] count = new int[26];
        int N = S.length();

        for(int i = 0; i < S.length(); i++){
            int index = S.charAt(i) -'a';
            count[index] +=100;
        }

        for(int i =0; i < count.length; i++){
            count[i] +=i;
        }

        Arrays.sort(count);

        char[] answer = new char[N];

        for(int i = 0; i < count.length; i++){
            int t =1;
            int ct = count[i] / 100;
            char c = (char)((count[i] % 100) + 'a');
            if(ct > (N+1)/2) return "";
            for(int j = 0; j<ct; j++){
                if (t >= N) t = 0;
                answer[t] = c;
                t+=2;
            }
        }
        return new String(answer);
    }
}
