package Algorithms.Strings;


    public class KMP {

        /**
         * Slow method of pattern matching
         */
        public boolean hasSubstring(char[] text, char[] pattern) {
            int i = 0;
            int j = 0;
            int k = 0;
            while (i < text.length && j < pattern.length) {
                if (text[i] == pattern[j]) {
                    i++;
                    j++;
                } else {
                    j = 0;
                    k++;
                    i = k;
                }
            }
            if (j == pattern.length) {
                return true;
            }
            return false;
        }

        /**
         * Compute temporary array to maintain size of suffix which is same as prefix
         * Time/space complexity is O(size of pattern)
         */
        private int[] computeTemporaryArray(char pattern[]) {
            int j = 0;
            int[] lps = new int[pattern.length];
            for(int i = 1; i < pattern.length;){
                if(pattern[i] == pattern[j]){
                    lps[i] = j + 1;
                    i++;
                    j++;
                }
                else{
                    if(j!=0)
                        j = lps[j-1];
                    else {
                        j=0;
                        i++;
                    }

                }
            }
            return lps;
        }

        /**
         * KMP algorithm of pattern matching.
         */
        public boolean KMP(char[] text, char[] pattern) {
            int i = 0;
            int j = 0;
            int[] lps = computeTemporaryArray(pattern);
            while (i < text.length && j < pattern.length){
                if(text[i] == pattern[j]){
                    i++;
                    j++;
                }
                else {
                    if(j!=0)
                        j = lps[j-1];
                    else {
                        j = 0;
                        i++;
                    }
                }
            }
            if(j == pattern.length)
                return true;
            else
                return false;
        }
    }

