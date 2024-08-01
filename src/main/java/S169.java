import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * 169. 多数元素
 * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 */
public class S169 {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 2, 1, 1, 1, 2, 2, 3, 4};
        System.out.println("majorityElement(nums) = " + majorityElement(nums));
        System.out.println("nums = " + Arrays.toString(nums));
    }

    /**
     * 寻找数组中的多数元素
     * 多数元素定义为在数组中出现次数大于 n/2 的元素
     *
     * @param nums 一个整数数组，假设数组中存在多数元素
     * @return 数组中的多数元素
     */
    public static int majorityElement(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            if (countMap.containsKey(num)) {
                countMap.put(num, countMap.get(num) + 1);
            } else {
                countMap.put(num, 1);
            }
        }
        Map.Entry<Integer, Integer> integerIntegerEntry = countMap
                .entrySet().parallelStream().max(Comparator.comparingInt(Map.Entry::getValue)).get();
        return integerIntegerEntry.getKey();
    }
}
