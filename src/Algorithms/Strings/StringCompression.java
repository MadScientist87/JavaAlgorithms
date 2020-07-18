package Algorithms.Strings;

public class StringCompression {
    public static String CompressString(String phrase)
    {
        var phraseArray = phrase.toCharArray();
        var previous = phraseArray[0];
        int duplicateCounter = 0;
        int MaxDuplicate = 0;
        String compressedResult = "";
        for(int i = 0; i< phraseArray.length;i++)
        {
            if(phraseArray[i] != previous)
            {
                compressedResult +=  Character.toString(previous)  +  Integer.toString(duplicateCounter);
                MaxDuplicate = Math.max(MaxDuplicate, duplicateCounter);
                duplicateCounter=1;
                previous = phraseArray[i];
            }
            else
            {
                duplicateCounter++;
            }

        }

        compressedResult +=  Character.toString(previous)  +  Integer.toString(duplicateCounter);
        MaxDuplicate = Math.max(MaxDuplicate, duplicateCounter);


        if (MaxDuplicate <= 2)
            return phrase;
        else
            return compressedResult;
    }
}
