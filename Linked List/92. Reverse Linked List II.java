/*
# same as reversing the list
# Skip the elements until 'left'
# Set the element before 'left' to 'last' and the element at 'left' to 'temp'
*/


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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (right == left)
            return head;
        int leftCount = 1;
        ListNode temp = head;
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
            head = prev;
        temp.next = pres;
        return head;

    }
}
