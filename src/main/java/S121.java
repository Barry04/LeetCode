/**
 * 121. 买卖股票的最佳时机
 */
public class S121 {

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
        // 处理 null 和空数组的情况
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int profit = 0;

        // 遍历价格数组，计算每次价格上涨的差值并累加
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }

        return profit;
    }

}
