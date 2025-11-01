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
    public ListNode modifiedList(int[] nums, ListNode head) {
        if(head==null){
            return null;
        }
        HashSet<Integer>hs=new HashSet<>();
        for(int a:nums){
            hs.add(a);
        }
        ListNode dmy=new ListNode(-1);
        ListNode temp=dmy;
        while(head!=null){
            int val=head.val;
            if(!hs.contains(val)){
                temp.next=new ListNode(val);
                temp=temp.next;
            }
            head=head.next;
        }
        return dmy.next;
    }
}