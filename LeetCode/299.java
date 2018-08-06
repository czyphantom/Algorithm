/**
 * 题目：你正在和你的朋友玩猜数字（Bulls and Cows）游戏：你写下一个数字让你的朋友猜。
 * 每次他猜测后，你给他一个提示，告诉他有多少位数字和确切位置都猜对了（称为“Bulls”, 公牛），有多少位数字猜对了但是位置不对（称为“Cows”, 奶牛）。
 * 你的朋友将会根据提示继续猜，直到猜出秘密数字。
 * 请写出一个根据秘密数字和朋友的猜测数返回提示的函数，用A表示公牛，用B表示奶牛。
 * 请注意秘密数字和朋友的猜测数都可能含有重复数字。
 * 难度：Medium
 * 思路：用数组存储10个数字的个数。
*/

class Solution {
    public String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        int[] numbers = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bulls++;
            }
            else {
                if (numbers[secret.charAt(i)-'0']++ < 0) {
                    cows++;
                }
                if (numbers[guess.charAt(i)-'0']-- > 0) {
                    cows++;
                }
            }
        }
        return bulls + "A" + cows + "B";
    }
}