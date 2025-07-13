class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);
        int pidx=players.length-1;
        int tidx=trainers.length-1;
        int cnt=0;
        while(pidx>=0 && tidx>=0){
            if(trainers[tidx]>=players[pidx]){
                tidx--;
                pidx--;
                cnt++;
            }
            else{
                pidx--;
            }
        }
        return cnt;
    }
}