package pl.edu.pw.ee.aisd2023zlab6.lcs;

public class LongestCommonSubsequence {

    public String findLcs(String topText, String leftText) {

        String lcs = "";
        int topLength = topText.length();
        int leftLength = leftText.length();
        int[][] lcsMatrix = new int[topLength + 1][leftLength + 1];

        for (int i = 0; i <= topLength; i++) {
            for (int j = 0; j <= leftLength; j++) {
                if (i == 0 || j == 0) {
                    lcsMatrix[i][j] = 0;
                } else if (topText.charAt(i - 1) == leftText.charAt(j - 1)) {
                    lcsMatrix[i][j] = lcsMatrix[i - 1][j - 1] + 1;
                } else {
                    lcsMatrix[i][j] = Math.max(lcsMatrix[i - 1][j], lcsMatrix[i][j - 1]);
                }
            }
        }

        System.out.println("Przedstawienie Macierzy: ");
        for (int i = 0; i <= topLength; i++) {
            System.out.print("| ");
            for (int j = 0; j <= leftLength; j++) {
                System.out.print(lcsMatrix[i][j] + " |");
            }
            System.out.println();
        }

        int i = topLength;
        int j = leftLength;

        while (i > 0 && j > 0) {
            if (topText.charAt(i - 1) == leftText.charAt(j - 1)) {
                lcs = topText.charAt(i - 1) + lcs;
                i--;
                j--;
            } else if (lcsMatrix[i - 1][j] > lcsMatrix[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }

        if (lcs.length() > 0) {
            return lcs;
        }

        return null;
    }



}
