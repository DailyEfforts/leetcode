package _0028;

/**
 * Implement strStr().
 * Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 */
public class Solution {
    public int strStr(String haystack, String needle) {
        final int hayStackLen = haystack.length();
        final int needleLen = needle.length();
        if (hayStackLen < needleLen) {
            return -1;
        }
        if (hayStackLen == 0 && needleLen == 0) {
            return 0;
        }
        for (int i = 0; i < hayStackLen; i++) {
            if (hayStackLen - i < needleLen) {
                break;
            }
            int j = 0;
            int k = i;
            while (j < needleLen && k < hayStackLen && haystack.charAt(k) == needle.charAt(j)) {
                k++;
                j++;
            }
            if (j == needleLen) {
                return k - needleLen;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.strStr("", ""));
        System.out.println(solution.strStr("mississippi", "issip"));
    }
}

