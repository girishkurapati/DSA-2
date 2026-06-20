public class CO6 {

    static int editDistance(String s1, String s2) {

        int m = s1.length();
        int n = s2.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++)
            dp[i][0] = i;

        for (int j = 0; j <= n; j++)
            dp[0][j] = j;

        for (int i = 1; i <= m; i++) {

            for (int j = 1; j <= n; j++) {

                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];

                else {

                    dp[i][j] = 1 + Math.min(
                            dp[i - 1][j],
                            Math.min(
                                    dp[i][j - 1],
                                    dp[i - 1][j - 1]
                            )
                    );
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {

        String wrongWord = "algoritm";
        String correctWord = "algorithm";

        int distance = editDistance(wrongWord, correctWord);

        System.out.println("=========================================");
        System.out.println(" AI SPELL CORRECTION SYSTEM ");
        System.out.println("=========================================");

        System.out.println("\nMisspelled Word : " + wrongWord);
        System.out.println("Correct Word    : " + correctWord);

        System.out.println("\nMinimum Edit Distance = " + distance);

        System.out.println("\nSuggested Correction:");
        System.out.println(correctWord);

        System.out.println("\nComplexity Analysis:");
        System.out.println("Time Complexity  : O(m × n)");
        System.out.println("Space Complexity : O(m × n)");

        System.out.println("\nSpell Check Completed Successfully.");
    }
}