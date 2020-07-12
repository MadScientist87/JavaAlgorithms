package Strings;

import Algorithms.Strings.IsPermutation;
import org.junit.Assert;
import org.junit.Test;
import Algorithms.Strings.IsUnique;

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
}