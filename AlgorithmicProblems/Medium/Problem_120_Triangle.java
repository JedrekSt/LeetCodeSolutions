class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        List <Integer> MinPaths = new ArrayList<>();
        List <Integer> ActualRow;
        MinPaths.add(triangle.get(0).get(0));
        int n;
        for(int i = 1; i < triangle.size(); i++){
            ActualRow = triangle.get(i);
            MinPaths.add(0,MinPaths.get(0) + ActualRow.get(0));
            for(int j = 1 ; j < MinPaths.size() - 1 ; j++){
                MinPaths.set(j,ActualRow.get(j) + Math.min(MinPaths.get(j),MinPaths.get(j+1)));
            }
            n = MinPaths.size()-1;
            MinPaths.set(n,MinPaths.get(n) + ActualRow.get(n));
        }
        return MinimalVal(MinPaths);
    }

    public int MinimalVal(List <Integer> arr){
        int min = arr.get(0);
        for(int i = 1; i < arr.size(); i++){
            if(arr.get(i) < min){
                min = arr.get(i);
            }
        }
        return min;
    }
}
