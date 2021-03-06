package simple;

import java.util.Stack;

/**
 * @author zcc
 * @ClassName: JZ5
 * @Date: 2021/1/27 11:43 上午
 * @Description: 用两个栈实现队列
 * <p>
 * 题目描述
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 */
public class JZ5 {
    public static void main(String[] args) {

    }
    //存放入队
    Stack<Integer> stack1 = new Stack<Integer>();
    //存放出队
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (stack1.empty() && stack2.empty()) {
            return -1;
        }
        if (stack2.empty()) {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
