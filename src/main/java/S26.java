import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 删除有序数组中的重复项
 */
public class S26 {

    public static void main(String[] args) {
        int[] nums = new int[]{0, 0, 1, 2, 3, 1, 1, 2, 1};
        System.out.println("removeDuplicates(nums) = " + removeDuplicates(nums));
        System.out.println("nums = " + Arrays.toString(nums));
    }

    public static int removeDuplicates(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int curr = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i])) {
                nums[curr] = nums[i];
                set.add(nums[i]);
                curr++;
            }
        }
        return set.size();
    }
}
