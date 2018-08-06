/**
 * 题目：判断一个9x9的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的3x3宫内只能出现一次。
 * 数独部分空格内已填入了数字，空白格用 '.' 表示。
 * 难度：Medium
 * 思路：水题
 */

class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            if (!isParticallyValid(board, i, 0, i, 8)) {
                return false;
            }
            if (!isParticallyValid(board, 0, i, 8, i)) {
                return false;
            }
        }
        for (int i = 0;i < 3;i++) {
            for (int j = 0;j < 3;j++){
                if (!isParticallyValid(board, i*3, j*3, i*3+2, j*3+2)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isParticallyValid(char[][] board, int x1, int y1,int x2,int y2){
        Set<Character> singleSet = new HashSet<>();
        for (int i= x1; i <= x2; i++){
            for (int j = y1;j <= y2; j++){
                if (board[i][j] != '.') {
                    if (!singleSet.add(board[i][j])) {
                        return false;
                    }
                }   
            }
        }
        return true;
    }
 }