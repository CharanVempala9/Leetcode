import java.util.Arrays;

class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long>pq=new PriorityQueue<>();
        for(int num:nums){
            pq.add((long)num);
        }
        int cnt=0;
        while(!pq.isEmpty() && pq.peek()<k){
            Long min=pq.remove();
            Long sec=pq.remove();
            long ans=min*2+sec;
            pq.add(ans);
            cnt++;
        }

        return cnt;
    }
}
