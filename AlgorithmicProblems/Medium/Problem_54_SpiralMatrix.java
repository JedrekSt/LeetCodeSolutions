class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List <Integer> output = new ArrayList <Integer> ();
        int m = matrix.length;
        int n = matrix[0].length;

        int min = Math.min(m,n);
        int k = 0;

        while(k < min / 2){
            goRound(output,matrix ,k , m, n);
            k += 1;
        }
        if(min % 2 == 1){
            if(m == min){
                goFlatv(output,matrix,k,n);
            }else{
                goFlath(output,matrix,k,m);
            }
            
        }
        return output;    
    }

    public void goRound(List<Integer> output,int [][] matrix, int k,int m, int n){
        int q;
        for(q = k; q < n - k; q++){
            output.add(matrix[k][q]);
        }
        for(q = k + 1; q < m - k; q++){
            output.add(matrix[q][n - k - 1]);
        }
        for(q = n - k - 2; q > k - 1; q--){
            output.add(matrix[m - k - 1][q]);
        }
        for(q = m - k - 2; q > k; q -- ){
            output.add(matrix[q][k]);
        }
    }

    public void goFlatv(List<Integer> output,int [][] matrix, int k, int n){
        for(int q = k; q < n - k; q++){
            output.add(matrix[k][q]);
        }
    }

    public void goFlath(List<Integer> output,int [][] matrix, int k, int m){
        for(int q = k; q < m - k; q++){
            output.add(matrix[q][k]);
        }
    }
}
