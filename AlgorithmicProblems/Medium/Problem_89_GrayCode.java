class Solution {
    public List<Integer> grayCode(int n) {
        List <Integer> output = new ArrayList<>();
        if(n == 0){
            return output;
        }
        output.add(0);
        output.add(1);
        if(n == 1){
            return output;
        }

        int num,size;
        int pow = 1;
        for(int i = 2; i <= n; i++){
            size = output.size();
            pow *= 2 ;
            for(int j = size - 1; j >= 0; j-- ){
                num = output.get(j);
                output.add(pow + num);
            }
            
        }
        return output;
    }
}
