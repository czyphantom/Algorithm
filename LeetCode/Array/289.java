/**
* 题目大意：生命游戏，具体规则略
* 难度：Medium
* 思路：因为需要原地算法，所以可以考虑采取+10操作，最后复原即可
*/

public void gameOfLife(int[][] board) {
    if(board == null || board.length == 0)
        return;
    for(int i = 0;i < board.length;i++) {
        for(int j = 0;j < board[0].length;j++) {
            int count = getCount(board,i,j);
            if(count == 3 || (count==2 && board[i][j] == 1)) {
                board[i][j] += 10;
            }
        }
    }

    for(int i = 0;i < board.length;i++) {
        for(int j = 0;j < board[0].length;j++) {
            board[i][j] /= 10;
        }
    }

}

private int getCount(int[][] board,int x,int y) {
    int count = 0;
    for(int i = Math.max(0,x-1);i <= Math.min(x+1,board.length-1);i++) {
        for(int j = Math.max(0,y-1);j <= Math.min(y+1,board[0].length-1);j++) {
            if(i==x && j== y) {
                continue;
            }
            if(board[i][j]%10 == 1) {
                count++;
            }
        }
    }

    return count;
}
