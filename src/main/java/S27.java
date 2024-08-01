import java.util.Arrays;

/**
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素。元素的顺序可能发生改变。然后返回 nums 中与 val 不同的元素的数量。
 */
public class S27 {


    public static void main(String[] args) {
        int[] nums = new int[]{0, 0, 1, 2, 3, 1, 1, 2, 1};
        removeElement(nums, 1);
        System.out.println("nums = " + Arrays.toString(nums));
    }

    public static int removeElement(int[] nums, int val) {
        int curr = 0;
        for (int i = 0; i < nums.length; i++) {
            if (val != nums[i]) {
                nums[curr] = nums[i];
                if (curr != i) {
                    nums[i] = -1;
                }
                curr++;
            } else {
                nums[i] = -1;
            }
        }
        return curr;
    }

}
