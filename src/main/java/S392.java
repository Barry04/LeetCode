public class S392 {
    public static void main(String[] args) {
        String s = "";
        String t = "ahbgdc";
        System.out.println("isSubsequence(s) = " + isSubsequence(s, t));
    }

    public static boolean isSubsequence(String s, String t) {
        if (s.isEmpty()) {
            return true;
        }
        int ps = 0;
        for (int i = 0; i < t.length(); i++) {
            char tChar = t.charAt(i);
            if (s.charAt(ps) == tChar) {
                ps++;
            }
            if (ps == s.length()) {
                return true;
            }
        }
        return false;
    }
}
