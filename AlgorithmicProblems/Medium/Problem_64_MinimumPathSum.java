class Solution {
    public int minPathSum(int[][] grid) {
        int inf = 2147483647;
        int n = grid.length;
        int m = 0;
        int min,ptr1,ptr2,num1,num2;
        if(n != 0){
            m = grid[0].length;
        }
        if(n == 0 && m == 0){
            return 0;
        }

        for(int i = 1; i < m; i++) {
            min = Math.min(i+1,n);
            for (int j = 0; j < min; j++) {
                ptr1 = j;
                ptr2 = i - j;
                num1 = ptr1 == 0 ? inf : grid[ptr1 - 1][ptr2];
                num2 = ptr2 == 0 ? inf : grid[ptr1][ptr2 - 1];
                grid[ptr1][ptr2] += Math.min(num1,num2);
            }
        }

        for(int i = 1 ; i < n; i++){
            min = Math.min(n-i,m);
            for(int j = 0 ; j < min; j++){
                ptr1 = i + j;
                ptr2 = m - 1 - j;
                num1 = grid[ptr1 - 1][ptr2];
                num2 = ptr2 == 0 ? inf : grid[ptr1][ptr2 - 1];
                grid[ptr1][ptr2] += Math.min(num1,num2);
            }
        }
        return grid[n - 1][m - 1];
    }
}
