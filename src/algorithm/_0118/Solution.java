package algorithm._0118;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> list = solution.generate(5);
        System.out.println(list);
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        for (int row = 1; row <= numRows; row++) {
            List<Integer> subList = new ArrayList<Integer>();
            if (row == 1) {
                subList.add(1);
            } else if (row == 2) {
                subList.add(1);
                subList.add(1);
            } else {
                subList.add(1);
                List<Integer> preList = list.get(row - 2);
                for (int col = 1; col < row - 1; col++) {
                    subList.add(preList.get(col - 1) + preList.get(col));
                }
                subList.add(1);
            }
            list.add(subList);
        }
        return list;
    }
}
