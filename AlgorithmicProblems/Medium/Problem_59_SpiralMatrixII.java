class Solution {
    public int[][] generateMatrix(int n) {
        int [][] arr = new int [n][n];
        int k = 0;
        int iter = 1;
        while(k < n / 2){
            iter = goRound(arr,k,n,iter);
            k++;
        } 
        if(n % 2 == 1){
            if(n == 1){
                arr[0][0] = 1;
                return arr;
            }
            arr[n / 2 ][n / 2 ] = n * n;
        }
        return arr;
    }

    public int goRound(int [][] arr,int k, int n,int iter){
        int q;
        for(q = k; q < n - k; q++){
            arr[k][q] = iter;
            iter++;
        }
        for(q = k + 1; q < n - k; q++){
            arr[q][n - k - 1] = iter;
            iter++;
        }
        for(q = n - k - 2; q > k - 1; q--){
            arr[n - k - 1][q] = iter;
            iter++;
        }
        for(q = n - k - 2; q > k; q -- ){
            arr[q][k] = iter;
            iter++;
        }
        return iter;
    }
}