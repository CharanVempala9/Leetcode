class Solution {
    public boolean bfs(int node,ArrayList<ArrayList<Integer>>ls,int[] vis){
        Queue<Integer>q=new LinkedList<>();
        q.add(node);
        vis[node]=0;
        while(!q.isEmpty()){
            int newnode = q.remove();
            for(int it:ls.get(newnode)){
                if(vis[it]==-1){
                   vis[it]= 1-vis[newnode];
                   q.add(it); 
                }
                else if(vis[it]==vis[newnode]){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        int m=graph[0].length;
        ArrayList<ArrayList<Integer>>ls=new ArrayList<>();
        for(int i=0; i<n; i++){
            ls.add(new ArrayList<>());
        }
        for(int i=0; i<n; i++){
            for(int val:graph[i]){
                ls.get(i).add(val);
            }
        }
        int[] vis=new int[n];
        for(int i=0; i<n; i++){
            vis[i]=-1;
        }
        for(int i=0; i<n; i++){
            if(vis[i]==-1){
                if(bfs(i,ls,vis)==false)
                return false;
            }
        }
        return true;
    }
}