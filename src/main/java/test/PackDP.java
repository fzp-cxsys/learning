package test;

import java.util.Scanner;

public class PackDP {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String s = in.next();
            int[] count = new int[26];
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < s.length(); i++) {
                count[s.charAt(i) - 'a']++;
            }
            for (int i = 0; i < count.length; i++) {
                if (count[i] < min && count[i] != 0) min = count[i];
            }
            for (int i = 0; i < s.length(); i++) {
                int charIndex = s.charAt(i) - 'a';
                if (count[charIndex] != min) {
                    System.out.print(s.charAt(i));
                }
            }
            System.out.println();
        }
//        Scanner in = new Scanner(System.in);
//        int capacity = in.nextInt();
//        int[] weight = new int[in.nextInt()];
//        int[] value = new int[weight.length];
//
//        for (int i = 0; i < weight.length; i++) {
//            weight[i] = in.nextInt();
//        }
//        for (int i = 0; i < value.length; i++) {
//            value[i] = in.nextInt();
//        }
//        System.out.println(dynamicProgramming(capacity, weight, value)[weight.length][capacity]);
    }

    public static int[][] dynamicProgramming(int capacity, int[] weight, int[] value) {
        int[][] result = new int[weight.length + 1][capacity + 1];
        for (int i = 1; i < result.length; i++) {
            for (int j = 1; j < result[i].length; j++) {
                if (weight[i - 1] > j) {
                    result[i][j] = result[i - 1][j];
                } else {
                    int addition = result[i - 1][j - weight[i - 1]] + value[i - 1];
                    if (addition > result[i - 1][j]) {
                        result[i][j] = addition;
                    } else {
                        result[i][j] = result[i - 1][j];
                    }
                }
            }
        }
        return result;
    }
}
