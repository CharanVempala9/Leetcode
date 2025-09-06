class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>>adj=new ArrayList<>();
        for(int i=0; i<numCourses; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] p:prerequisites){
            int u=p[0];
            int v=p[1];
            adj.get(v).add(u);
        }
        int[] indegree=new int[numCourses];
        for(int i=0; i<numCourses; i++){
            for(int it:adj.get(i)){
                indegree[it]++;
            }
        }
        Queue<Integer>q=new LinkedList<>();
        for(int i=0; i<numCourses; i++){
            if(indegree[i]==0){
                q.offer(i);
            }
        }
        int[] topo=new int[numCourses];
        int i=0;
        while(!q.isEmpty()){
            int node=q.poll();
            topo[i++]=node;
            for(int it:adj.get(node)){
                indegree[it]--;
                if(indegree[it]==0){
                    q.offer(it);
                }
            }
        }
        if(i==numCourses)
        return topo;
        return new int[]{};
    }
}