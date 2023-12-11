package pl.edu.pw.ee.aisd2023zlab6.lcs;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LongestCommonSubsequenceTest {



    @Test
    public void should_correctlyReturnLCS_whenLabExampleCaseFirst() {
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        String leftText = "MIKOŁAJ";
        String topText = "NIKOLA";
        String result = lcs.findLcs(topText, leftText);

        String expected = "IKOA";
        assertEquals(expected, result);
    }


    @Test
    public void should_correctlyReturnLCS_whenLabExampleCaseSecond() {
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        String leftText = "MIKOAŁAJ";
        String topText = "NIKOLA";

        String result = lcs.findLcs( topText, leftText);

        String expected = "IKOA";
        assertEquals(expected, result);
    }


    @Test
    public void should_correctlyReturnLCS_whenLabExampleCaseThird() {
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        String leftText = "DYNAMICPROGRAMMING";
        String topText = "COMMONSUBSEQUENCE";

        String result = lcs.findLcs( topText, leftText);

        String expected = "COMMN";
        assertEquals(expected, result);
    }


    @Test
    public void should_correctlyReturnLCS_whenLabExampleCaseFourth() {
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        String leftText = "ALAMAKOTA";
        String topText = "KOTMAALE";

        String result = lcs.findLcs( topText, leftText);

        String expected = "KOTA";
        assertEquals(expected, result);
    }


    @Test
    public void should_correctlyReturnLCS_whenLabExampleCaseFifth() {
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        String leftText = "WARSZAWA";
        String topText = "WARSZAWSKI";

        String result = lcs.findLcs( topText, leftText);

        String expected = "WARSZAW";
        assertEquals(expected, result);
    }

    @Test
    public void should_correctlyReturnLCS_whenLabExampleCaseSixth() {
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        String leftText = "POCIAG";
        String topText = "PODCIAG";

        String result = lcs.findLcs( topText, leftText);

        String expected = "POCIAG";
        assertEquals(expected, result);
    }

}
