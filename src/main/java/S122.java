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
        int cost = Integer.MAX_VALUE, profit = 0;
        for (int price : prices) {
            cost = Math.min(cost, price);
            profit = Math.max(profit, price - cost);
        }
        return profit;
    }
}
