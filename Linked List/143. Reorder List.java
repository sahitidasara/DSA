/*
# Reverse the second half
# merge 2 lls
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
    public void reorderList(ListNode head) {
        // reverse second half of list
        ListNode firsthalf = head;
        // find the middle element in the list
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // reverse the list from 'slow'
        ListNode prev = null;
        ListNode pres = slow;
        ListNode pt3 = slow.next;
        while (pres != null) {
            pres.next = prev;
            prev = pres;
            pres = pt3;
            if (pt3 != null)
                pt3 = pt3.next;
        }

        // reversed second half is in prev
        while(firsthalf!=null && prev!=null){
        ListNode nextfirsthalf = firsthalf.next;
        firsthalf.next = prev;
        firsthalf = nextfirsthalf;

         ListNode nextprev = prev.next;
        prev.next = firsthalf;
        prev = nextprev;
       }
    }
}
