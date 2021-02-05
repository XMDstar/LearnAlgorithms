package simple;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zcc
 * @ClassName: JZ28
 * @Date: 2021/2/5 11:29 上午
 * @Description: 数组出现过一半的数字
 * <p>
 * 题目描述
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 * 示例1
 * 输入
 * [1,2,3,2,2,2,5,4,2]
 * 返回值
 * 2
 */
public class JZ28 {
    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,2,2,2,5,2,4};
        System.out.println(MoreThanHalfNum_Solution(array));
    }

    public static int MoreThanHalfNum_Solution(int[] nums) {
        //摩尔投票
        int x = 0, votes = 0, count = 0;
        for(int num : nums){
            if(votes == 0) x = num;
            votes += num == x ? 1 : -1;
        }
        // 验证 x 是否为众数
        for(int num : nums)
            if(num == x) count++;
        return count > nums.length / 2 ? x : 0;
        //哈希暴力方式 时空O(n)
//        if (array == null || array.length == 0) {
//            return 0;
//        }
//        if (array.length == 1) {
//            return array[0];
//        }
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < array.length; i++) {
//            int key = array[i];
//            if (map.get(key) != null) {
//                if (1 + map.get(key) >= array.length >> 1) {
//                    return array[i];
//                }
//                map.put(key, 1 + map.get(key));
//            } else {
//                map.put(key, 1);
//            }
//        }
//        return 0;
    }
}
