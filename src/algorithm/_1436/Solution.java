package algorithm._1436;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        List<String> la = new ArrayList<>();
        la.add("B");
        la.add("C");

        List<String> lb = new ArrayList<>();
        lb.add("D");
        lb.add("B");

        List<String> lc = new ArrayList<>();
        lc.add("C");
        lc.add("A");

        List<List<String>> paths = new ArrayList<>();
        paths.add(la);
        paths.add(lb);
        paths.add(lc);

        System.out.println(new Solution().destCity(paths));
    }

    public String destCity(List<List<String>> paths) {
        Set<String> sources = new HashSet<>();
        for (List<String> path : paths) {
            sources.add(path.get(0));
        }

        for (List<String> path : paths) {
            if (!sources.contains(path.get(1))) {
                return path.get(1);
            }
        }
        return "";
    }
}
