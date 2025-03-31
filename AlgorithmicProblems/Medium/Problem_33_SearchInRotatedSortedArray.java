class Solution {
    public int search(int[] arr, int target) {
        int n = arr.length;
        int shift = findShift(arr);
        int i = 0;
        int j = n - 1;
        int k,idx;

        while( i < j ){
            k = (i + j) / 2;
            idx = (k + shift) % n;
            if(arr[idx] > target) {
                j = k;
            }else if(arr[idx] < target){
                i = k+1;
            }else{
                return idx;
            }
        }
        idx = (j + shift) % n;
        if(arr[idx] == target){
            return idx;
        }
        else{
            return -1;
        }
    }

    public int findShift(int [] arr){
        int i = 0;
        int j = arr.length - 1;
        int k;

        while(i < j){
            k = (i + j) / 2;
            if(arr[j] > arr[k]){
                j = k;
            }
            else if(arr[j] < arr[k]){
                i = k + 1;
            }
            else{
                return k + 1;
            }
        }
        return i;
    }
}