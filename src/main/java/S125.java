/**
 * 125. 验证回文串
 */
public class S125 {

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println("isPalindrome(s) = " + isPalindrome(s));
    }


    public static boolean isPalindrome(String s) {
        // 使用正则表达式替换掉字符串中的所有非字母数字字符
        s = s.replaceAll("[^a-zA-Z0-9]", "").replaceAll(" ", "");
        if (s.length() <= 1) {
            return true;
        }
        int start = 0;
        int end = s.length() - 1;
        do {
            char startStr = Character.toLowerCase(s.charAt(start));
            char endStr =  Character.toLowerCase(s.charAt(end));
            if (startStr != endStr) {
                return false;
            }
            start++;
            end--;
        } while (start <= end);
        return true;
    }
}
