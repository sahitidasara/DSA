/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {

        int left = 1;
        int right = k;
        // find the linkedlist length
        ListNode temp = head;
        int length = 0;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        while (right <= length) {
            head = reverseBetween(head, left, right);
            left += k;
            right += k;
        }
        return head;
    }

    public ListNode reverseBetween(ListNode node, int left, int right) {
        if (right == left)
            return node;
        int leftCount = 1;
        ListNode temp = node;
        ListNode prev = null;
        while (leftCount < left) {
            prev = temp;
            temp = temp.next;
            leftCount++;
        }
        ListNode last = prev;
        ListNode pres = temp;
        ListNode pt3 = temp.next;
        while (left <= right && pres != null) {
            pres.next = prev;
            prev = pres;
            pres = pt3;
            if (pt3 != null)
                pt3 = pt3.next;
            left++;
        }

        if (last != null)
            last.next = prev;
        else
            node = prev;
        temp.next = pres;
        return node;

    }
}
