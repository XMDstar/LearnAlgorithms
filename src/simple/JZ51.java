package simple;

/**
 * @author zcc
 * @ClassName: JZ51
 * @Date: 2021/2/22 4:54 下午
 * @Description: 构建乘积数组
 * <p>
 * 题目描述
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
 * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 * （注意：规定B[0] = A[1] * A[2] * ... * A[n-1]，B[n-1] = A[0] * A[1] * ... * A[n-2];）
 * 对于A长度为1的情况，B无意义，故而无法构建，因此该情况不会存在。
 * 示例1
 * 输入
 * A[1,2,3,4,5]
 * 返回值
 * B[120,60,40,30,24]
 */
public class JZ51 {
    public static void main(String[] args) {
        int[] A = new int[]{1, 2, 3, 4, 5};
        int[] B = multiply1(A);
        for (int temp : B) {
            System.out.print(temp + "  ");
        }
    }

    /**
     * 暴力解决 使用循环算出每个位置的乘积
     *
     * @param A
     * @return
     */
    public static int[] multiply(int[] A) {
        if (A.length < 2) return null;
        int[] B = new int[A.length];
        B[0] = sum1(A, -1);
        B[A.length - 1] = sum1(A, A.length - 1);
        for (int i = 1; i < A.length - 1; i++) {
            B[i] = sum1(A, i);
        }
        return B;
    }

    private static int sum1(int[] A, int postion) {
        int sum = 1;
        for (int i = 0; i < A.length; i++) {
            if (i != postion) {
                sum = sum * A[i];
            }
        }
        return sum;
    }

    /**
     * B[i]的值可以看作下图的矩阵中每行的乘积。
     * <p>
     * 下三角用连乘可以很容求得，上三角，从下向上也是连乘。
     * <p>
     * 因此我们的思路就很清晰了，先算下三角中的连乘，即我们先算出B[i]中的一部分，然后倒过来按上三角中的分布规律，把另一部分也乘进去
     * <p>
     * b0      1   a1  a2   ...     a(n-2)  a(n-1)
     * b1      a0  1   a2   ...     a(n-2)  a(n-1)
     * b2      a0  a1  1    ...     a(n-2)  a(n-1)
     * ...     a0  a1  ...  1       a(n-2)  a(n-1)
     * b(n-2)  a0  a1  ...  a(n-3)  1       a(n-1)
     * b(n-1)  a0  a1  ...  a(n-3)  a(n-2)  1
     * <p>
     * 前半部分(从前往后)：ci=c0*c1...*c(i-1)
     * 后半部分(从后往前)：di=d(n-1)*d(n-2)*...d(i+1)
     * 可得：bi=ci*di
     * 简化之后 ci=c(i-1)*a(i-1)    di=d(i+1)*a(i+1)
     *
     * @param A
     * @return
     */
    public static int[] multiply1(int[] A) {
        if (A.length < 2) return null;
        int[] B = new int[A.length];
        B[0] = 1;
        //算ci 从前往后
        for (int i = 1; i < A.length; i++) {
            B[i] = B[i - 1] * A[i - 1];
        }
        //算di 从后往前 默认最后一位为1则范围向前一位
        int temp = 1;
        for (int j = A.length - 2; j >= 0; j--) {
            temp = temp * A[j + 1];
            B[j] = B[j] * temp;
        }
        return B;
    }
}