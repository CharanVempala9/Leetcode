class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        int n=happiness.length;
        long ans=0;
        PriorityQueue<Integer>pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int h:happiness){
            pq.add(h);
        }
        int idx=0;
        while(k-->0){
            int v=pq.poll();
            if(v-idx>=0)
            ans+=v-idx;
            else break;
            idx++;
        }
        return ans;
    }
}