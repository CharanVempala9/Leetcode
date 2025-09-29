class Pair{
    int n;
    int time;
    public Pair(int n,int time){
        this.n=n;
        this.time=time;
    }
}
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Pair>>adj=new ArrayList<>();
        for(int i=0; i<=n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] t:times){
            int u=t[0];
            int v=t[1];
            int wt=t[2];
            adj.get(u).add(new Pair(v,wt));
        }
        Queue<Pair>q=new LinkedList<>();
        q.add(new Pair(k,0));
        int[] dist=new int[n+1];
        Arrays.fill(dist,(int)1e9);
        dist[k]=0;
        while(!q.isEmpty()){
            Pair p=q.poll();
            int node=p.n;
            int time=p.time;
            for(Pair it:adj.get(node)){
                int adjn=it.n;
                int tm=it.time;
                if(time+tm<dist[adjn]){
                    dist[adjn]=time+tm;
                    q.add(new Pair(adjn,time+tm));
                }
            }
        }
        int max=0;
        for(int i=1; i<=n; i++){
            if(dist[i]==(int)1e9){
                return -1;
            }
            max=Math.max(max,dist[i]);
        }
        return max;
    }
}