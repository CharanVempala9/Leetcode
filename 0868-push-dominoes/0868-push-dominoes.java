class Solution {
    public String pushDominoes(String dominoes) {
        dominoes="L"+dominoes+"R";
        StringBuilder res=new StringBuilder();
        int p1=0;
        for(int i=0; i<dominoes.length(); i++){
            if(dominoes.charAt(i)=='.') continue;
            int temp=i-p1-1;
            if(p1>0){
                res.append(dominoes.charAt(p1));
            }
            if(dominoes.charAt(i)==dominoes.charAt(p1)){
                for (int j = 0; j < temp; ++j)
                    res.append(dominoes.charAt(p1));
            }
            else if (dominoes.charAt(p1) == 'L' && dominoes.charAt(i) == 'R') {
                for (int j = 0; j < temp; ++j)
                    res.append('.');
            } else {
                for (int j = 0; j < temp / 2; ++j)
                    res.append('R');
                if (temp % 2 == 1)
                    res.append('.');
                for (int j = 0; j < temp / 2; ++j)
                    res.append('L');
            }
            p1=i;
        }
        return res.toString();
    }
}