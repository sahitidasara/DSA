class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode temp1 = list1;
        ListNode temp2 = list2;

        ListNode dummy = new ListNode();
        ListNode res = dummy;
        while (temp1 != null && temp2!= null) {
            if (temp1.val < temp2.val) {
               res.next = temp1;
                temp1 = temp1.next;
                res = res.next;
            } else {
               res.next = temp2;
                temp2 = temp2.next;
                res = res.next;
            } 
            
        }
        while (temp1!= null) {
           res.next = temp1;
           res = res.next;
            temp1 = temp1.next;
        }
        while (temp2!= null) {
            res.next= temp2;
            res = res.next;
            temp2 = temp2.next;
        }

        return dummy.next;
    }
}
