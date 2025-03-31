class Solution {
    public int numTrees(int n) {
        if(n == 0){
            return 1;
        }
        int [] Num = new int [n+1];
        int sum;

        Num[0] = 1;
        Num[1] = 1;

        for(int k = 2; k < n+1; k++ ){
            sum = 0;
            for(int i = 1; i < k+1; i++){
                sum += Num[i - 1] * Num[k - i];
            }
            Num[k] = sum;
        }
        return Num[n];
    }

}
