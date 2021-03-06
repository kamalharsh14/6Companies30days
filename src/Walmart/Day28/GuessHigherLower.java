//Problem Link: https://leetcode.com/problems/guess-number-higher-or-lower-ii

package Walmart.Day28;
import java.util.Scanner;

public class GuessHigherLower {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = getMoneyAmount(n);
        System.out.println(ans);
        sc.close();
    }

    private static int getMoneyAmount(int n) {
        int[][] table = new int[n + 1][n + 1];
        return DP(table, 1, n);
    }

    static int DP(int[][] t, int s, int e) {
        if (s >= e) return 0;
        if (t[s][e] != 0) return t[s][e];
        int res = Integer.MAX_VALUE;
        for (int x = s; x <= e; x++) {
            int tmp = x + Math.max(DP(t, s, x - 1), DP(t, x + 1, e));
            res = Math.min(res, tmp);
        }
        t[s][e] = res;
        return res;
    }
}
