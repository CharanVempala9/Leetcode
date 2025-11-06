class Solution {
    public int findChampion(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>>ls=new ArrayList<>();
        for(int i=0; i<n; i++){
            ls.add(new ArrayList<>());
        }
        for(int[] e:edges){
            int u=e[0];
            int v=e[1];
            ls.get(u).add(v);
        }
        int[] vis=new int[n];
        for(int i=0; i<n; i++){
            for(int j=0; j<ls.get(i).size(); j++){
                if(vis[ls.get(i).get(j)]==0)
                vis[ls.get(i).get(j)]=1;
            }
        }
        int ans=1;
        int cnt=0;
        for(int i=0; i<n; i++){
            if(vis[i]==0){
                ans=i;
                cnt++;
            }
            //System.out.print(vis[i]+" ");
        }
        if(cnt==1)return ans;
        return -1;
    }
}