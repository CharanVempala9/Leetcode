class Solution {
    class Edge{
        int src;  
        int dest;  
        int price;
        Edge(int src, int dest, int price){
            this.src=src;
            this.dest=dest;
            this.price=price;
        }
    }
    class Info{
        int dest;  
        int price;  
        int stops;  
        Info(int dest, int price, int stops){
            this.dest=dest;
            this.price=price;
            this.stops=stops;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        ArrayList<Edge>[] graph = new ArrayList[n];
        for(int i=0;i<n;i++){
            graph[i] = new ArrayList<>();
        }
        for(int i=0;i<flights.length;i++){
            int u = flights[i][0];
            int v = flights[i][1];
            int price = flights[i][2];
            graph[u].add(new Edge(u, v, price));
        }
        int[] dist = new int[n];  
        for(int i=0;i<n;i++){
            if(i!=src){
                dist[i] = Integer.MAX_VALUE;
            }
        }
        Queue<Info> q = new LinkedList<>();
        q.add(new Info(src, 0, 0));  
        while(!q.isEmpty()){
            Info curr = q.remove();
            if(curr.stops>k){
                continue;
            }
            for(Edge e : graph[curr.dest]){
                int u = e.src;
                int v = e.dest;
                int price = e.price;

                if(curr.price + price<dist[v] && curr.stops<=k){
                    dist[v] = curr.price + price;
                    q.add(new Info(v, dist[v], curr.stops+1));
                }
            }
        }
        if(dist[dst] == Integer.MAX_VALUE){
            return -1;  
        }
        return dist[dst];
    }
}