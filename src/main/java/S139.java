import java.util.*;

/**
 * 139. 单词拆分
 * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。如果可以利用字典中出现的一个或多个单词拼接出 s 则返回 true。
 */
public class S139 {

    public static void main(String[] args) {
        String s = "catsandog";
        String[] dict = new String[]{"cats", "dog", "sand", "and", "cat"};
        List<String> wordDict = new ArrayList<>(Arrays.asList(dict));
        System.out.println("wordBreak(s, wordDict   ) = " + wordBreak(s, wordDict));
    }

    /**
     * 判断是否能将字符串s分割成一系列单词，这些单词在给定的单词字典中存在
     *
     * @param s 待分割的字符串
     * @param wordDict 单词字典，包含一组单词
     * @return 如果可以分割成单词字典中的单词，返回true；否则返回false
     */
    public static boolean wordBreak(String s, List<String> wordDict) {
        // 将单词字典转换为集合，以便能够快速检查单词是否存在
        Set<String> wordDictSet = new HashSet<>(wordDict);
        // dp数组用于动态规划，dp[i]表示前i个字符是否可以分割成字典中的单词
        boolean[] dp = new boolean[s.length() + 1];
        // 空字符串默认可以被分割
        dp[0] = true;
        // 遍历字符串的每个位置，判断是否可以分割
        for (int i = 1; i <= s.length(); i++) {
            // 从字符串的起始位置到当前位置，尝试找到一个可以分割的位置
            for (int j = 0; j < i; j++) {
                // 如果前j个字符可以被分割，并且从j到i的子字符串在字典中存在
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    // 说明当前位置可以分割
                    dp[i] = true;
                    // 不需要继续尝试其他分割位置
                    break;
                }
            }
        }
        // 返回整个字符串是否可以被分割
        return dp[s.length()];
    }


}
