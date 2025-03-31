class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int iter = 0;

        while (numbers[iter] <= target / 2 && iter < numbers.length - 1){
            int ans = binSearch(iter,numbers,target);
            if(ans != -1){
                return new int[] {iter + 1,ans + 1};
            }
            iter ++;
        }

        return new int [] {-1,-1};
    }

    public int binSearch(int start,int []numbers, int target){
        int i = start + 1;
        int j = numbers.length - 1;
        int k;
        while(i < j){
            k = (i+j)/2;
            if(numbers[k] + numbers[start] >= target){
                j = k;
            }else{
                i = k + 1;
            }
        }
        if(numbers[i] + numbers[start] == target){
            return i;
        }else{
            return -1;
        }
    }
}
