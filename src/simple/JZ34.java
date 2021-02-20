package simple;

/**
 * @author zcc
 * @ClassName: JZ34
 * @Date: 2021/2/20 11:02 上午
 * @Description: 第一个只出现一次的字符位置
 * <p>
 * 题目描述
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回 -1（需要区分大小写）.（从0开始计数）
 * 示例1
 * 输入
 * "google"
 * 返回值
 * 4
 */
public class JZ34 {
    public static void main(String[] args) {
        System.out.println(FirstNotRepeatingChar2("google"));
    }

    /**
     * 拿出当前字符截取前后判断是否包含 都不包含则为第一个出现一次的位置
     * 相对hash主要耗时在substring与contains方法上
     *
     * @param str
     * @return
     */
    public static int FirstNotRepeatingChar(String str) {
        if (str == null || str.isEmpty()) {
            return -1;
        }
        for (int i = 0; i < str.length(); i++) {
            if (!((str.substring(i + 1)).contains(str.charAt(i) + "")) && !((str.substring(0, i)).contains(str.charAt(i) + ""))) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 说一下解题思路哈，其实主要还是hash，利用每个字母的ASCII码作hash来作为数组的index。首先用一个58长度的数组来存储每个字母出现的次数，
     * 为什么是58呢，主要是由于A-Z对应的ASCII码为65-90，a-z对应的ASCII码值为97-122，而每个字母的index=int(word)-65，
     * 比如g=103-65=38，而数组中具体记录的内容是该字母出现的次数，最终遍历一遍字符串，找出第一个数组内容为1的字母就可以了，时间复杂度为O(n)
     *
     * @param str
     * @return
     */
    public static int FirstNotRepeatingChar2(String str) {
        if (str == null || str.isEmpty()) {
            return -1;
        }
        //A-Z对应的ASCII码为65-90，a-z对应的ASCII码值为97-122
        int[] count = new int[58];
        for (int i = 0; i < str.length(); i++) {
            count[(str.charAt(i)) - 65] += 1;
        }
        for (int i = 0; i < str.length(); i++) {
            if (count[(str.charAt(i)) - 65] == 1) return i;
        }
        return -1;
    }
}
