package Alogorithms.dynamic.programming;


/**
 * 背包问题
 */
public class Bag {

    static int n;
    static int[] w;
    static int[] v;

    static {
        n = 4;
        w = new int[]{2, 1, 3, 2};
        v = new int[]{3, 2, 4, 2};
    }

    static int[][] dp;

    static void initializeDp(int w) {
        dp = new int[n + 1][w + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < w + 1; j++) {
                dp[i][j] = 0;
            }
        }
    }

    public static void main(String[] args) {
        initializeDp(5);
        System.out.println(recLoop(5));
    }

    static int recLoop(int W) {
        // 从第i个物品开始挑选中价值小于j时， 总价值的最大值
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= W; j++) {
                if (j < w[i]) {
                    dp[i][j] = dp[i + 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i + 1][j - w[i]] + v[i]);
                }
            }
        }
        return dp[0][W];
    }

    static int recMemory(int i, int j) {
        System.out.println(i + "-----" + j);
        if (dp[i][j] > 0) {
            return dp[i][j];
        }
        int res;
        if (i == n) {
            res = 0;
        } else if (j < w[i]) { // 无法挑选这个物品
            res = recMemory(i + 1, j);
        } else {
            // 挑选这个物品 和 不挑选这个物品
            res = Math.max(recMemory(i + 1, j), recMemory(i + 1, j - w[i]) + v[i]);
        }
        dp[i][j] = res;
        return res;
    }


    static int rec(int i, int j) {
        System.out.println(i + "-----" + j);
        int res;
        if (i == n) {
            res = 0;
        } else if (j < w[i]) { // 无法挑选这个物品
            res = rec(i + 1, j);
        } else {
            // 挑选这个物品 和 不挑选这个物品
            res = Math.max(rec(i + 1, j), rec(i + 1, j - w[i]) + v[i]);
        }
        return res;
    }

}
