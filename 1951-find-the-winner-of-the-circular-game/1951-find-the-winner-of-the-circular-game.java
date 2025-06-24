class Solution {
    public int findTheWinner(int n, int k) {
        Queue<Integer>q=new LinkedList<>();
        for(int i=1; i<=n; i++){
            q.offer(i);
        }
        while(q.size()!=1){
            int cnt=1;
            while(cnt<k){
                int temp=q.peek();
                q.offer(temp);
                q.remove();
                cnt++;
            }
            q.remove();
        }
        return q.peek();
    }
}