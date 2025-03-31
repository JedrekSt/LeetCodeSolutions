class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = 0;
        if(n != 0 ){
            m = matrix[0].length;
        }
        else{
            return false;
        }

        int length = m * n;
        int i = 0;
        int j = length - 1;
        int k,ptr1,ptr2;

        while(i < j){
            k = (i + j) / 2;
            ptr1 = k / m ;
            ptr2 = k % m;
            if( matrix[ptr1][ptr2] < target ){
                i = k + 1;
            }
            else if(matrix[ptr1][ptr2] > target ){
                j = k;
            }
            else{
                return true;
            }
            
        }
        ptr1 = j / m;
        ptr2 = j % m;
        if(matrix[ptr1][ptr2] == target){
            return true;
        }
        return false;
    }
}