class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int dp [] = new int [m];
        boolean res;
        for(int i = 0 ; i < m ; i++){
            res = true;
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == 0){
                    res = false;
                }
                
            }
            dp[i] = res ? 1 : 0;
        }

        for(int i = 0 ; i < m; i++){
            for(int j = 0; j < n ; j++){
                if(matrix[i][j] == 0){
                    for(int k = 0 ; k < m ;k++){
                        matrix[k][j] = 0;
                    }
                }
            }
        }

        for(int i = 0; i < m ; i++){
            if(dp[i] == 0){
                for(int j = 0 ; j < n; j++){
                    matrix[i][j] = 0;
                }
            }
        }

    }
}
