package medium;

import java.math.BigDecimal;
import java.math.BigInteger;

public class KnightProbability {
    public static void main(String[] args) {
        KnightProbability kp = new KnightProbability();
        System.out.println(kp.knightProbability(25, 100, 0, 0));
    }

    public double knightProbability(int n, int k, int r, int c) {

        double[][][] dp = new double[n][n][k + 1];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                for(int m = 0; m < k + 1; m++) {
                    dp[i][j][m] = -1;
                }
            }
        }

        double outVal = move(r, c, k, n - 1, 0, false, dp);

        double den = Math.pow(8, k);
        return outVal/den;
    }

    public static double move(int r, int c, int k, int xMax, int yLow, boolean out, double[][][] dp) {

        if(r > xMax || r < yLow || c > xMax || c < yLow || out) {
            out = true;
            return 0;
        }

        if(dp[r][c][k] != -1)
            return dp[r][c][k];

        if(k == 0 && !out) {
            dp[r][c][k] = 1;
            return 1;
        }

        if(k == 0)
            return 0;

        double val = 0;
        dp[r][c][k] = 0;
        //right 2, top 1
        val += move(r + 2, c - 1, k - 1, xMax, yLow, out, dp);

        //right 2, down 1
        val += move(r + 2, c + 1, k - 1, xMax, yLow, out, dp);

        //down 2, right 1
        val += move(r + 1, c + 2, k - 1, xMax, yLow, out, dp);

        //down 2, left 1
        val += move(r - 1, c + 2, k - 1, xMax, yLow, out, dp);

        //left 2, down 1
        val += move(r - 2, c + 1, k - 1, xMax, yLow, out, dp);

        //left 2, top 1
        val += move(r - 2, c - 1, k - 1, xMax, yLow, out, dp);

        //top 2, left 1
        val += move(r - 1, c - 2, k - 1, xMax, yLow, out, dp);

        //top 2, right 1
        val += move(r + 1, c - 2, k - 1, xMax, yLow, out, dp);

        dp[r][c][k] = val;

        return dp[r][c][k];
    }
}
