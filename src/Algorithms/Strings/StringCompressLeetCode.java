package Algorithms.Strings;

public class StringCompressLeetCode {
    public static int compress(char[] chars) {
        int j = 0;
        int count = 1;
        for(int i = 0; i < chars.length; i++){
            chars[j] = chars[i];
            j++;
            while(i < chars.length -1 && chars[i] == chars[i+1]){
                count++;
                i++;
            }
            if(count!=1){
                if(count >9){
                    String str = String.valueOf(count);
                    for(char c: str.toCharArray()){
                        chars[j] = c;
                        j++;
                    }
                }
                else{
                    chars[j] =  String.valueOf(count).toCharArray()[0];
                    j++;
                }
            }

            count =1;
        }
        return j;
    }
}
