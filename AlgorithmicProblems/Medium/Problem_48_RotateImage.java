class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int len = n / 2;
        for(int k = 0; k < len ; k++ ){
            rotate_frame(matrix,n,k);
        }
    }

    public void rotate_frame(int [][] matrix,int n,int k){
        int temp,temp2;
        for(int i = k; i < n - 1 - k ; i++){
            temp = matrix[i][n - 1 - k];
            matrix[i][n - 1 - k] = matrix[k][i];
            temp2 = matrix[n - 1 - k][n - 1 - i];
            matrix[n - 1 - k][n - 1 - i] = temp;
            temp = matrix[n - 1 - i][k];
            matrix[n - 1 - i][k] = temp2;
            matrix[k][i] = temp;
        }
    }
}