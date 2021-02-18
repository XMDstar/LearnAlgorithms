package simple;

/**
 * @author zcc
 * @ClassName: JZ30
 * @Date: 2021/2/7 10:29 上午
 * @Description: 连续子数组的最大和
 * <p>
 * 题目描述
 * 输入一个整型数组，数组里有正数也有负数。数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。要求时间复杂度为 O(n).
 * 示例1
 * 输入
 * [1,-2,3,10,-4,7,2,-5]
 * 返回值
 * 18
 * 说明
 * 输入的数组为{1,-2,3,10,—4,7,2,一5}，和最大的子数组为{3,10,一4,7,2}，因此输出为该子数组的和 18。
 */
public class JZ30 {
    public static void main(String[] args) {
        //[-2,-8,-1,-5,-9]
        int[] a = new int[]{-1, -2, 3, 10, -4, 7, 2, -5};
//        int max = FindGreatestSumOfSubArray(a, a.length);
        int max = FindGreatestSumOfSubArray(a);
        System.out.println("max=" + max);
    }

    /**
     * 对第j+1个元素有两种选择：要么放入前面找到的子数组，要么做为新子数组的第一个元素；
     * 如果currSum加上当前元素a[j]后不小于a[j]，则令currSum加上a[j]，否则currSum重新赋值，置为下一个元素，即currSum = a[j]。
     * 同时，当currSum > maxSum，则更新maxSum = currSum，否则保持原值，不更新。
     *
     * @param array
     * @return
     */
    public static int FindGreatestSumOfSubArray(int[] array) {
        int currSum = 0;
        int maxSum = array[0];
        for (int i = 0; i < array.length; i++) {
            currSum = (array[i] > currSum + array[i]) ? array[i] : currSum + array[i];
            maxSum = (currSum > maxSum) ? currSum : maxSum;
        }
        return maxSum;
    }

    /**
     * 暴力方式  O(n^3)
     * 循环求出每一个子数的大小
     *
     * @param a
     * @param n
     * @return
     */
    public static int FindGreatestSumOfSubArray(int[] a, int n) {
        int maxSum = a[0];  //全负情况，返回最大负数
        int currSum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                for (int k = i; k <= j; k++) {
                    currSum += a[k];
                }
                if (currSum > maxSum)
                    maxSum = currSum;

                currSum = 0; //这里要记得清零，否则的话sum最终存放的是所有子数组的和。
            }
        }
        return maxSum;
    }
}
