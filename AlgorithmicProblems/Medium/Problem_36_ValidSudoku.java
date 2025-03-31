class Solution {
    public boolean isValidSudoku(char[][] board) {
        int p,q;
        for(int i = 0; i < 9; i++){
            if(! checkRow(board,i)){
                return false;
            }
            if(! checkCol(board,i)){
                return false;
            }
            p = i / 3;
            q = i % 3;
            if(! checkSub(board,3*p,3*q)){
                return false;
            }
        }
        return true;
    }

    public boolean checkRow(char [][] board, int i){
        List <Character> present = new ArrayList<>(); 
        for(int j = 0 ; j < 9; j++){
            if(board[i][j] != ".".charAt(0)){
                if(checkList(present,board[i][j])){
                    present.add(board[i][j]);
                }
                else{
                    return false;
                }
            }
        }
        return true;
    }

    public boolean checkCol(char [][] board, int i){
        List <Character> present = new ArrayList<>(); 
        for(int j = 0 ; j < 9; j++){
            if(board[j][i] != ".".charAt(0)){
                if(checkList(present,board[j][i])){
                    present.add(board[j][i]);
                }
                else{
                    return false;
                }
            }
        }
        return true;
    }

    public boolean checkSub(char [][] board,int i , int j){
        List <Character> present = new ArrayList<>();
        for(int p = i; p < i + 3; p++){
            for(int q = j; q < j + 3 ; q++){
                if(board[p][q] != ".".charAt(0)){
                    if(checkList(present,board[p][q])){
                        present.add(board[p][q]);
                    }
                    else{
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean checkList(List<Character> present, char c){
        for(int k = 0; k < present.size(); k++){
            if(present.get(k) == c){
                return false;
            }
        }
        return true;
    }
}