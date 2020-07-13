package Algorithms.Strings;

public class URLify {
    public static String HTMLEncodeSpaces(String url, int finalURLLength){
        char[] originalString = url.toCharArray();
        char[] finalURL = new char[originalString.length];
        int finalURlPointer = 0;

        for(int i = 0; i < finalURLLength;i++){
            if(originalString[i] != ' '){
                finalURL[finalURlPointer] = originalString[i];
                finalURlPointer++;
            }
            else {
                finalURL[finalURlPointer] = '%';
                finalURL[finalURlPointer +1] = '2';
                finalURL[finalURlPointer +2] = '0';
                finalURlPointer+=3;
            }
        }
        return new String(finalURL);
    }
}
