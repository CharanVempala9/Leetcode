class Pair{
    int n;
    int t;
    public Pair(int n,int t){
        this.n=n;
        this.t=t;
    }
}
class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int[] m: meetings){
            int u=m[0], v=m[1], t=m[2];
            adj.get(u).add(new Pair(v,t));
            adj.get(v).add(new Pair(u,t));
        }
        int[] time = new int[n];
        Arrays.fill(time, Integer.MAX_VALUE);
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->a.t-b.t);
        time[0]=0;
        time[firstPerson]=0;
        pq.add(new Pair(0,0));
        pq.add(new Pair(firstPerson,0));
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int node = p.n;
            int currTime = p.t;
            if(currTime > time[node]) continue;
            for(Pair nei : adj.get(node)){
                if(nei.t >= currTime && nei.t < time[nei.n]){
                    time[nei.n] = nei.t;
                    pq.add(new Pair(nei.n, nei.t));
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(time[i] != Integer.MAX_VALUE) ans.add(i);
        }
        return ans;
    }
}
