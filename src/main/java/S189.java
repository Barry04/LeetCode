import java.util.Arrays;

/**
 * 189. 轮转数组
 * 给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 */
public class S189 {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2};
        rotate(nums, 3);
        System.out.println("nums = " + Arrays.toString(nums));
    }

    /**
     * 将给定的整数数组向右旋转k个位置
     *
     * @param nums 待旋转的整数数组
     * @param k    旋转的位置数
     */
    public static void rotate(int[] nums, int k) {
        // 检查数组是否为空
        if (nums == null || nums.length == 0) {
            return;
        }

        // 获取数组的实际长度
        int n = nums.length;
        // 对k进行规范化，确保k为非负数且小于数组长度
        k = k % n;

        // 如果k为0，不需要旋转
        if (k == 0) {
            return;
        }

        // 反转整个数组
        reverse(nums, 0, n - 1);
        // 反转前k个元素
        reverse(nums, 0, k - 1);
        // 反转剩余的元素
        reverse(nums, k, n - 1);
    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

}
