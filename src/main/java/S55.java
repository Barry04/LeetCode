/**
 * 55. 跳跃游戏
 * 给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。
 */
public class S55 {

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1,};
        System.out.println("canJump(nums) = " + canJump(nums));
    }

    public boolean canJump2(int[] nums) {
        // 能到达的最远下标
        int can = nums[0];
        // 每到达一个格子， 刷新能跳到的最远距离
        // 将 i < nums.length 改为 can < nums.length - 1
        for (int i = 0; i <= can && can < nums.length - 1; i++) {
            can = Math.max(can, i + nums[i]);
        }
        // 返回最远距离can 能否到达最后一个下标
        return can >= nums.length - 1;
    }

    /**
     * 判断是否能跳到数组的最后一个位置
     *
     * @param nums 输入的数组，其中每个元素代表在当前位置可以跳跃的最大长度
     * @return boolean 返回是否能跳到数组的最后一个位置
     */
    public static boolean canJump(int[] nums) {
        // 慢指针，表示当前能到达的最远位置
        int slow = 0;
        // 快指针，用于探索更远的位置
        int fast = 0;
        // 遍历数组，尝试跳跃
        while (fast < nums.length - 1) {
            // 如果快指针当前位置为0，表示无法直接跳过，需要寻找其他方案
            if (nums[fast] == 0) {
                // 尝试移动慢指针，看是否能跳到fast+1的位置
                while (nums[slow] <= (fast - slow) && slow < fast) {
                    ++slow;
                }
                // 如果慢指针和快指针重合，说明无法跳到fast+1的位置，返回false
                if (slow == fast) {
                    return false;
                }
            }
            // 快指针向前移动，继续探索
            ++fast;
        }
        // 如果能遍历到这，说明找到了一条跳到数组最后的路径，返回true
        return true;
    }


}
