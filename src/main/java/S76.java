import java.util.HashMap;
import java.util.Map;

public class S76 {
    public static void main(String[] args) {
        String s = "Avssv";
        String t = "vv";
        String s1 = minWindow(s, t);
        System.out.println(s1);  // 输出: "vssv"
    }

    /**
     * 查找字符串 s 中包含字符串 t 所有字符的最小子串。
     * 若不存在这样的子串，则返回空字符串。
     *
     * @param s 源字符串
     * @param t 目标字符串，包含需要匹配的所有字符
     * @return 包含 t 中所有字符的 s 的最小子串
     */
    public static String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }

        // 创建哈希表存储目标字符串 t 中每个字符出现的次数
        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // 初始化左指针、右指针、最小左边界、最小长度、计数器
        int left = 0, right = 0, minLeft = 0, minLen = Integer.MAX_VALUE, count = 0;

        // 移动右指针遍历源字符串 s
        while (right < s.length()) {
            char rChar = s.charAt(right);

            // 如果右指针指向的字符存在于目标字符串 t 中
            if (map.containsKey(rChar)) {
                map.put(rChar, map.get(rChar) - 1);
                // 如果该字符在当前窗口内数量未超过目标字符串 t 中的数量，则计数器加 1
                if (map.get(rChar) >= 0) {
                    count++;
                }
            }

            // 当窗口内的字符满足条件时
            while (count == t.length()) {
                // 更新最小窗口
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minLeft = left;
                }

                // 获取左指针指向的字符
                char lChar = s.charAt(left);
                // 如果左指针指向的字符存在于目标字符串 t 中
                if (map.containsKey(lChar)) {
                    map.put(lChar, map.get(lChar) + 1);
                    // 如果该字符在当前窗口内数量等于目标字符串 t 中的数量，则计数器减 1
                    if (map.get(lChar) > 0) {
                        count--;
                    }
                }
                // 左指针向右移动
                left++;
            }
            // 右指针向右移动
            right++;
        }

        // 返回最小窗口子串
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minLen);
    }

}
