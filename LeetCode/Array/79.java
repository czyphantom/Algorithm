/**
* 题目大意：给一个二维字符数组，判断是否存在给定词，上下左右连续即可。
* 思路：深度优先搜索
*/

private boolean[][] visited;
public boolean exist(char[][] board, String word) {
    visited = new boolean[board.length][board[0].length];
    if(board.length == 0 || board[0].length == 0)
        return false;
    int row = board.length;
    int column = board[0].length;
    for(int i = 0; i < row; i++){
        for(int j = 0; j < column; j++){
            if((word.charAt(0) == board[i][j]) && search(board, word, i, j, 0)){
                return true;
            }
        }
    }

    return false;
}

private boolean search(char[][]board, String word, int i, int j, int index){
    if(index == word.length()){
        return true;
    }

    if(i >= board.length || i < 0 || j >= board[i].length || j < 0 || board[i][j] != word.charAt(index) || visited[i][j]){
        return false;
    }

    visited[i][j] = true;
    if(search(board, word, i-1, j, index+1) || search(board, word, i+1, j, index+1) ||search(board, word, i, j-1, index+1) || search(board, word, i, j+1, index+1)){
        return true;
    }
    visited[i][j] = false;
    return false;
}
