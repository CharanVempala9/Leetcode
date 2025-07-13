class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        PriorityQueue<Integer>trainer=new PriorityQueue<>();
        PriorityQueue<Integer>player=new PriorityQueue<>();
        for(int p:players){
            player.add(p);
        }
        for(int t:trainers){
            trainer.add(t);
        }
        int cnt=0;
        while(!trainer.isEmpty() && !player.isEmpty()){
            if(trainer.peek()>=player.peek()){
                trainer.poll();
                player.poll();
                cnt++;
            }
            else{
                trainer.poll();
            }
        }
        return cnt;
    }
}