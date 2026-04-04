class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        int m=encodedText.length()/rows;
        int k=0;
        char[][] mat=new char[rows][m];
        for(int i=0; i<rows; i++){
            for(int j=0; j<m; j++){
                mat[i][j]=encodedText.charAt(k);
                k++;
            }
        }
        StringBuilder res=new StringBuilder();
        for(int i=0; i<m; i++){
            int r=0;
            int c=i;
            while(r<rows && c<m){
                res.append(mat[r][c]);
                r++;
                c++;
            }
        }
        return res.toString().stripTrailing();
    }
}