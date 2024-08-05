import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 30. 串联所有单词的子串
 */
public class S30 {

    public static void main(String[] args) {
        String[] words = new String[]{"fooo", "barr", "wing", "ding", "wing"};
        String s = "lingmindraboofooowingdingbarrwingmonkeypoundcake";
        System.out.println("findSubstring(s, words) = " + findSubstring(s, words));
    }

    public static List<Integer> findSubstring(String s, String[] words) {
        //  参数校验
        if (s == null || words == null || words.length == 0) {
            return new ArrayList<>();
        }
        //将每个单词以及出现的频率记录到map中
        Map<String, Integer> wordsMap = new HashMap<>();
        for (String str : words) {
            if (wordsMap.containsKey(str)) {
                wordsMap.put(str, wordsMap.get(str) + 1);
            } else {
                wordsMap.put(str, 1);
            }
        }
        int wordLength = words[0].length();
        int length = words.length * wordLength;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < s.length() - length + 1; i++) {
            Map<String, Integer> hasWord = new HashMap<>();
            int num = 0;
            while (num < words.length) {
                String substring = s.substring(i + num * wordLength, i + (num + 1) * wordLength);
                if (wordsMap.containsKey(substring)) {
                    int v = hasWord.getOrDefault(substring, 0);
                    hasWord.put(substring, v + 1);
                    if (hasWord.get(substring) > wordsMap.get(substring)) {
                        break;
                    }
                } else {
                    break;
                }
                num++;
            }
            if (num == words.length) {
                result.add(i);
            }
        }
        return result;
    }
}
