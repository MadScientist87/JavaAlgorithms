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
        var isPermutation = IsPermutation.IsWordAPermutation("beta","beat");
        Assert.assertTrue(isPermutation);
    }

    @Test
    public void HTMLEncodeURL() {
        var encodedURL = URLify.HTMLEncodeSpaces("Mr John Smith    ",13);
        Assert.assertEquals(encodedURL, "Mr%20John%20Smith");
    }
}