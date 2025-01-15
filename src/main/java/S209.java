/**
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 * <p>
 * 找出该数组中满足其总和大于等于 target 的长度最小的
 * 子数组
 * [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 */
public class S209 {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 4, 4};
        System.out.println("minSubArrayLen(nums) = " + minSubArrayLen(4, nums));
    }

    public static int minSubArrayLen(final int target, int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int minLen = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        int temSum = 0;
        while (right < nums.length) {
            temSum += nums[right];

            while (temSum >= target) {
                minLen = Math.min(minLen, right - left + 1);
                temSum -= nums[left];
                left++;
            }
            right++;
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
