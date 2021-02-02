package simple;

/**
 * @author zcc
 * @ClassName: JZ16
 * @Date: 2021/2/1 3:38 下午
 * @Description: 合并两个排序的链表
 * <p>
 * 题目描述
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 * 示例1
 * 输入
 * {1,3,5},{2,4,6}
 * 返回值
 * {1,2,3,4,5,6}
 *
 * 注意点：循环合成链表
 * 1.新的节点赋值中间节点的next
 * 2.新的节点赋值中间节点
 * 3.再次循环就得到上一次新节点的next
 */
public class JZ16 {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(3);
        list1.next.next = new ListNode(5);
        ListNode list2 = new ListNode(2);
        list2.next = new ListNode(4);
        list2.next.next = new ListNode(6);
        ListNode list = Merge(list1, list2);
        while (list != null) {
            System.out.println(list.val);
            list = list.next;
        }
    }

    public static ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        }
//        ListNode list = null;
//        ListNode listNext = null;
//        while (list1 != null || list2 != null) {
//            ListNode tmp = null;
//            if (list1 != null && list2 != null) {
//                if (list1.val > list2.val) {
//                    tmp = new ListNode(list2.val);
//                    list2 = list2.next;
//                } else if (list1.val < list2.val) {
//                    tmp = new ListNode(list1.val);
//                    list1 = list1.next;
//                } else {
//                    tmp = new ListNode(list1.val);
//                    list1 = list1.next;
//                }
//            } else {
//                if (list1 != null && list2 == null) {
//                    tmp = new ListNode(list1.val);
//                    list1 = list1.next;
//                } else if (list1 == null && list2 != null) {
//                    tmp = new ListNode(list2.val);
//                    list2 = list2.next;
//                }
//            }
//            if (list == null) {
//                list = tmp;
//                listNext = list;
//            } else {
//                listNext.next = tmp;
//                listNext = tmp;
//            }
//        }
        //精简代码之后
        ListNode list = new ListNode(-1);
        ListNode listNext = list;
        while (list1 != null && list2 != null) {
            ListNode tmp;
            if (list1.val <= list2.val) {
                tmp = new ListNode(list1.val);
                list1 = list1.next;
            } else {
                tmp = new ListNode(list2.val);
                list2 = list2.next;
            }
            listNext.next = tmp;
            listNext = tmp;
        }
        listNext.next = list1 == null ? list2 : list1;
        return list.next;
    }
}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}