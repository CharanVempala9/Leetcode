class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int max=0;
        int n=points.length;
        int m=points[0].length;
        for(int i=1; i<n; i++){
            int x1=points[i-1][0];
            int y1=points[i-1][1];
            int x2=points[i][0];
            int y2=points[i][1];
            int d1=Math.abs(x1-x2);
            int d2=Math.abs(y1-y2);
            max+=Math.max(d1,d2);
            //System.out.println(max);
        }
        return max;
    }
}