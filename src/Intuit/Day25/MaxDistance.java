//Problem Link: https://leetcode.com/problems/as-far-from-land-as-possible/

package Intuit.Day25;

import java.util.Scanner;

public class MaxDistance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        int ans = maxDistance(grid);
        System.out.println(ans);
        sc.close();
    }

    private static int maxDistance(int[][] grid) {
        int n = grid.length, m = grid[0].length, res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) continue;
                grid[i][j] = 201;
                if (i > 0) grid[i][j] = Math.min(grid[i][j], grid[i-1][j] + 1);
                if (j > 0) grid[i][j] = Math.min(grid[i][j], grid[i][j-1] + 1);
            }
        }

        for (int i = n-1; i > -1; i--) {
            for (int j = m-1; j > -1; j--) {
                if (grid[i][j] == 1) continue;
                if (i < n-1) grid[i][j] = Math.min(grid[i][j], grid[i+1][j] + 1);
                if (j < m-1) grid[i][j] = Math.min(grid[i][j], grid[i][j+1] + 1);
                res = Math.max(res, grid[i][j]);
            }
        }

        return res == 201 ? -1 : res - 1;
    }
}