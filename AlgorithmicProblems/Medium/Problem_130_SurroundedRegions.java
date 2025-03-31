class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        boolean [][] visited = new boolean[m][n];

        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                visited[i][j] = false;
            }
        }

        for(int i = 0; i < m ; i++){
            if(board[i][0] == 'O' && ! visited[i][0]){
                visit(visited,board,i,0,m,n);
            }
            if(board[i][n-1] == 'O' && ! visited[i][n-1]){
                visit(visited,board,i,n-1,m,n);
            }
            visited[i][0] = true;
            visited[i][n-1] = true;
        }

        for(int i = 0; i < n ; i++){
            if(board[0][i] == 'O' && ! visited[0][i]){
                visit(visited,board,0,i,m,n);
            }
            if(board[m-1][i] == 'O' && ! visited[m-1][i]){
                visit(visited,board,m-1,i,m,n);
            }
            visited[0][i] = true;
            visited[m-1][i] = true;
        }

        visit_all(visited,board,m,n);

    }

    public void visit(boolean [][] visited, char [][] board, int i, int j, int m, int n){
        visited[i][j] = true;

        int left = j > 0 ? j - 1 : -1;
        int right = j < n-1 ? j + 1: -1; 
        int up = i < m - 1 ? i + 1 : -1;
        int down = i > 0 ? i - 1 : -1;

        if(left != -1){
            if(! visited[i][left] && board[i][left] == 'O'){
                visit(visited,board,i,left,m,n);
            }
        } 
        if(right != -1){
            if(! visited[i][right] && board[i][right] == 'O'){
                visit(visited,board,i,right,m,n);
            }
        } 
        if(up != -1){
            if(! visited[up][j] && board[up][j] == 'O'){
                visit(visited,board,up,j,m,n);
            }
        } 
        if(down != -1){
            if(! visited[down][j] && board[down][j] == 'O'){
                visit(visited,board,down,j,m,n);
            }
        } 
    }

    public void visit_all(boolean [][] visited, char [][] board, int m, int n){
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(! visited[i][j] && board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
    }
}
