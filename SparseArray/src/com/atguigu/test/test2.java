package com.atguigu.test;

public class test2 {
    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        ListNode l1 = new ListNode();
        l1.val=6;
        ListNode l2 = new ListNode();
        l2.val=5;
        ListNode listNode = solution.addTwoNumbers(l1, l2);
        System.out.println(listNode.val);

    }
}


class ListNode {
     int val;
     ListNode next = null;
 }
class Solution1 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // write code here
        ListNode list = new ListNode();
        ListNode head = list;
        int t = 0;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                head.val = l2.val;
                head = head.next;
                l2 = l2.next;
            } else if (l2 == null) {
                head.val = l1.val;
                head = head.next;
                l1 = l1.next;
            } else {
                head.val = l1.val + l2.val;
                if (t != 0) {
                    head.val = head.val + t;
                    t = 0;
                }
                if (head.val >= 10) {
                    head.val = head.val - 10;
                    t++;
                }
                head = head.next;
                l1 = l1.next;
                l2 = l2.next;
            }
        }
        if (t != 0) {
            head.val = t;
        }
        return list;
    }
}
