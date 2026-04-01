import java.util.*;
class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n=positions.length;
        Integer[] ind=new Integer[n];
        for(int i=0; i<n; i++){
            ind[i]=i;
        }
        Arrays.sort(ind, (i, j) -> Integer.compare(positions[i], positions[j]));
        Stack<Integer>st=new Stack<>();
        for(int i=0; i<n; i++){
            int Cidx=ind[i];
            if(directions.charAt(Cidx)=='R'){
                st.push(Cidx);
            }
            else{
                while(!st.isEmpty() && healths[Cidx]>0){
                    int Tidx=st.pop();
                    if(healths[Cidx]>healths[Tidx]){
                        healths[Cidx]-=1;
                        healths[Tidx]=0;
                    }
                    else if(healths[Tidx]>healths[Cidx]){
                        healths[Tidx]-=1;
                        healths[Cidx]=0;
                        st.push(Tidx);
                    }
                    else{
                        healths[Tidx]=0;
                        healths[Cidx]=0;
                    }
                }
            }
        }
        List<Integer>ls=new ArrayList<>();
        for(int i=0; i<n; i++){
            if(healths[i]>0)
            ls.add(healths[i]);
        }
        return ls;
    }
} 