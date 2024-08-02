/**
 * 122. 买卖股票的最佳时机 II
 * 在每一天，你可以决定是否购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。
 */
public class S122 {


    public static void main(String[] args) {
        int[] nums = new int[]{7, 1, 5, 3, 6, 4};
        int maxProfit = maxProfit(nums);
        System.out.println("nums = " + maxProfit);
    }

    /**
     * 计算最大利润
     * <p>
     * 根据给定的股票价格数组，计算出可能的最大利润
     * 该函数假设允许进行多次买卖，但必须先买后卖
     *
     * @param prices 股票价格数组，表示每天的股票价格
     * @return 返回可能的最大利润
     */
    public static int maxProfit(int[] prices) {
        // 初始化最大利润为0
        int ans = 0;
        // 获取价格数组的长度
        int n = prices.length;
        // 从第二天开始遍历，计算每天的利润并累加到最大利润中
        for (int i = 1; i < n; ++i) {
            // 如果当天价格高于前一天价格，则计算差值并累加到最大利润中，否则累加0
            ans += Math.max(0, prices[i] - prices[i - 1]);
        }
        // 返回计算出的最大利润
        return ans;
    }

    /**
     * 计算给定价格数组下的最大利润
     * 该方法使用动态规划策略，考虑了每天买入、卖出股票的情况
     *
     * @param prices 股票每天的价格数组
     * @return 最大利润
     */
    public int maxProfit2(int[] prices) {
        // 天数
        int n = prices.length;
        // dp数组，dp[i][0]表示第i天持有股票的最大利润，dp[i][1]表示第i天不持有股票的最大利润
        int[][] dp = new int[n][2];
        // 初始化第一天不持有股票的利润为0
        dp[0][0] = 0;
        // 初始化第一天持有股票的利润为买入股票的负价值
        dp[0][1] = -prices[0];
        // 遍历每一天，更新dp数组
        for (int i = 1; i < n; ++i) {
            // 更新第i天不持有股票的利润，考虑两种情况：1.前一天就不持有；2.前一天持有，今天卖出
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            // 更新第i天持有股票的利润，考虑两种情况：1.前一天就持有；2.前一天不持有，今天买入
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        // 返回最后一天不持有股票的最大利润
        return dp[n - 1][0];
    }

}
