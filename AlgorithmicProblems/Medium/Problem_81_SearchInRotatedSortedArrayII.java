class Solution {
    public boolean search(int[] nums, int target) {
        int shift = find(nums);
        return search(nums,shift,target);
    }

    public static boolean search(int [] arr,int shift, int target){
        // if an array is shifted to right with shift
        // then the unshifted arr2[i] = arr[(i + shift) % n]
        
        int i = 0;
        int n = arr.length;
        int j = n - 1;
        int k,actual;
        
        while(i < j){
            k = (i + j) / 2;
            actual = (k + shift) % n;
            if(target <= arr[actual]){
                j = k;
            }else{
                i = k + 1;
            }
        }
        return arr[(j+shift) % n] == target;
    }

    public static int find(int [] arr){
        if(arr.length <= 1){
            return 0;
        }
        int j = 1;
        while(j < arr.length){
            if(arr[j - 1] > arr[j]){
                return j;
            }
            j++;
        }
        return j % arr.length;
    }

}
