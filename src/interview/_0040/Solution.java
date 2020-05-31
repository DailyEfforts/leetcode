package interview._0040;

import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) {

    }

    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr == null || arr.length < k) {
            return arr;
        }
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int x : arr) {
            q.add(x);
        }
        int[] ret = new int[k];
        for (int i = 0; i < k; i++) {
            ret[i] = q.remove();
        }
        return ret;
    }
}
