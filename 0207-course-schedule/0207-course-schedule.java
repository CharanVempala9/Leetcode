class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
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
        int cnt=0;
        Queue<Integer>q=new LinkedList<>();
        for(int i=0; i<numCourses; i++){
            if(indegree[i]==0){
                q.offer(i);
            }
        }
        while(!q.isEmpty()){
            int node=q.poll();
            cnt++;
            for(int it:adj.get(node)){
                indegree[it]--;
                if(indegree[it]==0){
                    q.offer(it);
                }
            }
        }
        return cnt==numCourses;
    }
}