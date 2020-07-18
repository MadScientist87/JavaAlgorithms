package Strings;

import org.junit.Assert;
import org.junit.Test;
import Algorithms.Strings.*;

public class StringTests {
    @Test
    public void IsUniqueTest() {
        var isunique = IsUnique.IsAllCharactersUnique("betz");
        Assert.assertTrue(isunique);
    }

    @Test
    public void IsWordAPermutationTest() {
        var isPermutation = IsPermutation.IsWordAPermutation("beta", "beat");
        Assert.assertTrue(isPermutation);
    }

    @Test
    public void HTMLEncodeURL() {
        var encodedURL = URLify.HTMLEncodeSpaces("Mr John Smith    ", 13);
        Assert.assertEquals(encodedURL, "Mr%20John%20Smith");
    }

    @Test
    public void PalindromePermutationTest() {

        var phrase = "MMO";
        var listOfPalindromes = PalindromePermutation.GetListOfPalindromes(phrase, 0, phrase.length() - 1);
        Assert.assertArrayEquals(listOfPalindromes.toArray(), new String[]{"mom"});
    }

    @Test
    public void OneAway() {

        var phraseOne = "ple";
        var phraseTwo = "pale";
        var answer = OneAway.IsOneAway(phraseOne, phraseTwo);
        Assert.assertTrue(answer);

        phraseOne = "pale";
        phraseTwo = "bale";
        answer = OneAway.IsOneAway(phraseOne, phraseTwo);
        Assert.assertTrue(answer);

        phraseOne = "pale";
        phraseTwo = "bake";
        answer = OneAway.IsOneAway(phraseOne, phraseTwo);
        Assert.assertFalse(answer);
    }

    @Test
    public void StringCompressor() {
        var phrase = "Aabccccca";
        var answer = StringCompression.CompressString(phrase);
        Assert.assertEquals(answer, "A1a1b1c5a1");

        phrase = "abbc";
        answer = StringCompression.CompressString(phrase);
        Assert.assertEquals(answer, "abbc");
    }

}