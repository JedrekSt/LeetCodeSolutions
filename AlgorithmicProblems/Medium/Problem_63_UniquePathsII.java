class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int [][] arr = obstacleGrid;
        int n = arr.length;
        int m = 0;
        int ptr1,ptr2,ran,val1,val2;
        if(n != 0){
            m = arr[0].length;
        }
        changeVal(arr,n,m);
        if(arr[0][0] != -1){
            arr[0][0] = 1;
        }
        else{
            return 0;
        }
        

        for(int i = 1 ; i < m; i++){
            ran = Math.min(i+1,n);
            for(int j = 0; j < ran; j++){
                ptr1 = j;
                ptr2 = i-j;
                if(arr[ptr1][ptr2] != -1){
                    val1 = ptr1 == 0 ? 0 : arr[ptr1 - 1][ptr2];
                    val2 = ptr2 == 0 ? 0 : arr[ptr1][ptr2 - 1];
                    arr[ptr1][ptr2] += val1 + val2;
                }
                else{
                    arr[ptr1][ptr2] = 0;
                }
            }
        }
        for(int i = 1 ; i < n; i++){
            ran = Math.min(n - i,m);
            for(int j = 0; j < ran; j++){
                ptr1 = i+j;
                ptr2 = m-1-j;
                if(arr[ptr1][ptr2] != -1){
                    val1 = ptr1 == 0 ? 0 : arr[ptr1 - 1][ptr2];
                    val2 = ptr2 == 0 ? 0 : arr[ptr1][ptr2 - 1];
                    arr[ptr1][ptr2] += val1 + val2;
                }
                else{
                    arr[ptr1][ptr2] = 0;
                }
            }
        }
        return arr[n-1][m-1];
    }

    public void changeVal(int [][] arr,int n,int m){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m ; j++){
                if(arr[i][j] == 1){
                    arr[i][j] = -1;
                }
                
            }
        }
    }
}
