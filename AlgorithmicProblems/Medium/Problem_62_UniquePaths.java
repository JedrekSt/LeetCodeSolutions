class Solution {
    public int uniquePaths(int m, int n) {
        return binomial(m+n-2,n-1);
    }

    public int binomial(int n, int k){
        int [][] values = new int [n+1][k+1];

        for(int j = 0; j < k+1 ; j++){
            for(int i = j; i < n+1 ; i++){
                if(i == j || j == 0){
                    values[i][j] = 1;
                }
                else{
                    values[i][j] = values[i-1][j-1] + values[i-1][j];
                }
            }
        }
        return values[n][k];
    }
}
