package simple;

/**
 * @author zcc
 * @ClassName: JZ9
 * @Date: 2021/1/29 11:38 上午
 * @Description: 变态跳台阶
 * <p>
 * 题目描述
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * <p>
 * 示例1
 * 输入
 * 3
 * <p>
 * 返回值
 * 4
 * <p>
 * 解题思路：
 * 若楼梯阶级 n = 3，有四种跳法，0-1-2-3,0-1-3,0-2-3,0-3
 * 若楼梯阶级 有n阶
 * dp[n] = dp[n-1] + dp[n-2] + ... + dp[1] = 2dp[n-1]
 */
public class JZ9 {
    public static void main(String[] args) {
        System.out.println(JumpFloorII(2));
    }

    public static int JumpFloorII(int target) {
        //递归
//        if (target == 0 || target == 1) {
//            return 1;
//        }
//        return 2 * JumpFloorII(target - 1);
        //公式
        return (int) Math.pow(2, target - 1);
    }
}
