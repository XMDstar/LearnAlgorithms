package primer;

/**
 * @author zcc
 * @ClassName: J27
 * @Date: 2021/1/26 5:25 下午
 * @Description: 斐波那契数列
 * 题目描述
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0，第1项是1）。
 * n\leq 39n≤39
 * <p>
 * 示例1
 * 输入
 * 4
 * 返回值
 * 3
 */
public class JZ7 {
    public static void main(String[] args) {
        System.out.println(Fibonacci(2));
    }

    public static int Fibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        //循环 O(n)
        int first = 0;
        int second = 1;
        int nValue = 0;
        for (int i = 2; i < n + 1; i++) {
            nValue = first + second;
            first = second;
            second = nValue;
        }
        return nValue;
        //递归 O(n^2)
//        return Fibonacci(n - 1) + Fibonacci(n - 2);
    }
}
