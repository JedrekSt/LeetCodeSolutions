/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1,ListNode l2){
        int len1 = getLength(l1);
        int len2 = getLength(l2);
        int len_max,len_min;
        ListNode list_max,list_min;
        if(len2 > len1){
            len_max = len2;
            len_min = len1;
            list_max = l2;
            list_min = l1;
        }
        else{
            len_max = len1;
            len_min = len2;
            list_max = l1;
            list_min = l2;
        }

        ListNode head = new ListNode();
        ListNode iter = head;
        ListNode lmax_iter = list_max;
        ListNode lmin_iter = list_min;

        int i = 0;
        while(i < (len_max - len_min)){
            iter.next = new ListNode(lmax_iter.val);
            iter = iter.next;
            lmax_iter = lmax_iter.next;
            i += 1;
        }
        while(lmax_iter != null){
            iter.next = new ListNode(lmax_iter.val + lmin_iter.val);
            iter = iter.next;
            lmax_iter = lmax_iter.next;
            lmin_iter = lmin_iter.next;
        }

        int ans = addTwoRecursive(head.next);
        if(ans != 0){
            head.val = ans;
        }
        else{
            head = head.next;
        }
        return head;
    }

    public int addTwoRecursive(ListNode head){
        if(head != null){
            int ans = addTwoRecursive(head.next);
            int quotient = (head.val + ans) / 10;
            int remider = (head.val + ans) % 10;
            head.val = remider;
            return quotient;
        }
        else{
            return 0;
        }
    }

    public int getLength(ListNode ln){
        int len = 0;
        while(ln != null){
            ln = ln.next;
            len += 1;
        }
        return len;
    }
        
}
