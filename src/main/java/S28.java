import java.util.Arrays;

/**
 * 删除排序数组中的重复项
 */
public class S28 {

    public static void main(String[] args) {
        int[] nums = new int[]{0, 0, 0, 1, 1, 1, 2, 2, 3,};
        System.out.println("removeDuplicates(nums) = " + removeDuplicates(nums));
        System.out.println("nums = " + Arrays.toString(nums));
    }

    public static int removeDuplicates(int[] nums) {
        int slow = 0;
        int slowVal = -1;
        int slowCount = 0;
        int fast = 0;
        while (fast < nums.length) {
            if (slowVal == nums[fast]) {
                slowCount++;
            } else {
                slowCount = 1;
            }
            if (slowCount > 2) {
                fast++;
                continue;
            }
            if (slowVal != nums[fast] || slowCount <= 2) {
                nums[slow] = nums[fast];
                slow++;
                slowVal = nums[fast];
            }
            fast++;
        }
        return slow;
    }
}
