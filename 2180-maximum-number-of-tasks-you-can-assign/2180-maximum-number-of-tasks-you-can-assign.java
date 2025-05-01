class Solution {
    public boolean isposs(int[] tasks, int[] workers, int pills, int strength, int taskCount){
        Deque<Integer> boosted = new ArrayDeque<>();
        int w = workers.length - 1;
        int freePills = pills;

        for (int t = taskCount - 1; t >= 0; t--) {
            int task = tasks[t];

            if (!boosted.isEmpty() && boosted.peekFirst() >= task) {
                boosted.pollFirst();
            } else if (w >= 0 && workers[w] >= task) {
                w--;
            } else {
                while (w >= 0 && workers[w] + strength >= task) {
                    boosted.addLast(workers[w--]);
                }
                if (boosted.isEmpty() || freePills == 0) {
                    return false;
                }
                boosted.pollLast();
                freePills--;
            }
        }

        return true;
    } 
    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        Arrays.sort(tasks);
        Arrays.sort(workers);
        int l=1;
        int h=tasks.length;
        int ans=0;
        while(l<=h){
            int mid=l+(h-l)/2;
            if(isposs(tasks,workers,pills,strength,mid)){
                ans=mid;
                l=mid+1;
            }
            else{
                h=mid-1;
            }
        }
        return ans;
    }
}