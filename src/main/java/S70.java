import java.util.HashMap;

/**
 * 70. 爬楼梯
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 */
public class S70 {

    private static final HashMap<Integer, Integer> memo = new HashMap<>();

    public static int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        if (!memo.containsKey(n)) {
            memo.put(n, climbStairs(n - 1) + climbStairs(n - 2));
        }
        return memo.get(n);
    }

    public static void main(String[] args) {
        System.out.println("climbStairs(30) = " + climbStairs(30));
    }
}
