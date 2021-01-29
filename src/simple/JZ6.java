package simple;

/**
 * @author zcc
 * @ClassName: JZ6
 * @Date: 2021/1/28 10:31 上午
 * @Description: 旋转数组的最小数字  注意点和high比较不要一心和low比较进入错误思维
 * <p>
 * 题目描述
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 * 示例1
 * 输入
 * 复制
 * [3,4,5,1,2]
 * 返回值
 * 复制
 * 1
 */
public class JZ6 {
    public static void main(String[] args) {
        System.out.println(minNumberInRotateArray(new int[]{3, 4, 5, 1, 2}));
    }

    public static int minNumberInRotateArray(int[] array) {
        if (array == null || array.length < 1) {
            return -1;
        }
        int value = array[0];
        //循环判断法 O(n)
//        for (int a : array) {
//            if (a < value) {
//                value = a;
//                break;
//            }
//        }
//        return value;

        //二分查找 O（log（n））
        //  1.数组只有一个数的情况  2.数组顺序排列未旋转
        if (array.length == 1 || array[0] < array[array.length - 1]) {
            return value;
        }
        int low = 0;
        int high = array.length - 1;
        while (low < high) {
            int mid = low + ((high - low) >> 1);
            if (array[high] < array[mid]) {
                //3.中间值大于最后一位 low向右移动
                low = mid + 1;
            } else if (array[high] > array[mid]) {
                //4.中间值小于最后一位 high赋值mid
                high = mid;
            } else {
                //mid等于high值  high左移
                --high;
            }
        }
        return array[low];
    }
}