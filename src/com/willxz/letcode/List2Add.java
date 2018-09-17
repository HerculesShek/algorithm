package com.willxz.letcode;

/**
 * String a = "73482347934239";
 * String b = "84529482365274";
 * a + b is  "158011830299513"
 */
public class List2Add {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int acc = 0;
        while (p != null || q != null) {
            int a = (p != null) ? p.val : 0;
            int b = (q != null) ? q.val : 0;
            int sum = acc + a + b;
            acc = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (acc > 0)
            curr.next = new ListNode(acc);
        return dummyHead.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            ListNode n = this;
            StringBuilder buffer = new StringBuilder();
            buffer.append(val);
            while (n.next != null) {
                buffer.append(n.next.val);
                n = n.next;
            }
            return buffer.toString();
        }

    }

    public String addBigInt(String int1, String int2) {
        String int1R = new StringBuilder(int1).reverse().toString();
        String int2R = new StringBuilder(int2).reverse().toString();

        ListNode h1 = constructList(int1R);
        ListNode h2 = constructList(int2R);

        ListNode r = addTwoNumbers(h1, h2);
        return new StringBuffer(r.toString()).reverse().toString();
    }

    private ListNode constructList(String str) {
        int len = str.length();
        if (len < 1) {
            return null;
        }
        if (len == 1) {
            return new ListNode(Integer.parseInt(str));
        }
        ListNode head = new ListNode(Character.getNumericValue(str.charAt(0)));
        ListNode curr = head;
        for (int i = 1; i < str.length(); i++) {
            ListNode node = new ListNode(Character.getNumericValue(str.charAt(i)));
            curr.next = node;
            curr = node;
        }
        return head;
    }

    public static void main(String[] args) {
        List2Add add = new List2Add();
        String a = "9";
        String b = "390";
        System.out.println(add.addBigInt(a, b));
    }
}
