package test;

import java.util.*;

public class Exam {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String input = in.next();
            List<Integer> nums = new ArrayList<>();
            for (int i = 0; i < input.length(); i++) {
                nums.add(Integer.valueOf(input.substring(i, i + 1)));
            }
            for (int i = 0; i < nums.size(); i++) {
                if (i == nums.size() - 1) {
                    System.out.println("NO");
                    break;
                }
                if (nums.get(i) == nums.get(i + 1)) {
                    List<Integer> numsCopy = new LinkedList<>();
                    for (int j = 0; j < nums.size(); j++) {
                        if (j != i && j != i + 1) {
                            numsCopy.add(nums.get(j));
                        }
                    }
                    if (hu(numsCopy)) {
                        System.out.println("YES");
                        break;
                    }
                }
            }
        }
    }

    public static boolean hu(List<Integer> a) {
        if (a.size() == 0) return true;
        if (a.size() < 3) return false;
        if (a.get(0) == a.get(1) && a.get(0) == a.get(2)) {
            a.remove(0);
            a.remove(0);
            a.remove(0);
            return hu(a);
        } else if (a.contains(a.get(0) + 1) && a.contains(a.get(0) + 2)) {
            int n = a.get(0);
            a.remove(0);
            a.remove(a.indexOf(n + 1));
            a.remove(a.indexOf(n + 2));
            return hu(a);
        }
        return false;
    }
}
