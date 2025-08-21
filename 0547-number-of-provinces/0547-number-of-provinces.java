class Solution {
    public void dfs(int node, boolean[] vis, List<List<Integer>>adj){
        vis[node]=true;
        for(int it:adj.get(node)){
            if(vis[it]==false){
                dfs(it,vis,adj);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        List<List<Integer>>adj=new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<Integer>());
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(isConnected[i][j]==1 && i!=j){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                } 
            }
        }
        int cnt=0;
        boolean[] vis=new boolean[n];
        for(int i=0; i<vis.length; i++){
            if(vis[i]==false){
                cnt++;
                dfs(i,vis,adj);
            }
        }
        return cnt;
    }
}