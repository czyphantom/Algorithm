/**
 * KMP算法用于解决字符串匹配问题，其精髓在于求解模式串的next数组
 * next数组代表模式串在匹配到位置i时失配，下一步匹配时应该从哪个位置开始匹配
 * 假设模式串0-k位置和j-k到k位置的子串相同，那么如果j+1失配时，就可以从k+1处开始匹配，如果k+1处字符不等于j+1处时，应当在0-k中继续找相同的子串
 */

public class Kmp {
    public int match(String str, String pattern) {
        int i = 0, j = 0;
        int len1 = str.length(),len2 = pattern.length();
        int[] next = new int[len2];
        getNext(pattern, next);
        while (i < len1 && j < len2) {
            if (str.charAt(i) == str.charAt(j)) {
                i++;
                j++;
            } else {
                if (next[j] == -1) {
                    j = 0;
                    i++;
                } else {
                    j = next[j];
                }
            }
            if (j = len2) {
                return i - j;
            }
        }
        return -1;
    }

    private void getNext(String pattern, int[] next) {
        int len = pattern.length();
        int i = 0;
        int j = -1;
        next[0] = -1;
        int k = -1;
        while (i < len-1) {
            if (k==-1 || pattern.charAt(i)==pattern.charAt(j)) {
                j++;
                k++;
                next[j] = k;
            } else {
                k = next[k];
            }
        }
    }
}