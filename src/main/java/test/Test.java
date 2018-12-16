package test;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {//注意while处理多个case
            String queueLine = in.nextLine();
            String[] strQueue = queueLine.split(", ");
            int[] queue = new int[strQueue.length];
            int[] priority = new int[10];
            boolean[] isOut = new boolean[strQueue.length];
            for (int i = 0; i < strQueue.length; i++) {
                queue[i] = Integer.valueOf(strQueue[i]);
                isOut[i] = false;
                priority[queue[i]]++;
            }
            int outCount = 0, currentPriority = 9, index = 0;
            StringBuffer result = new StringBuffer();
            while (outCount != strQueue.length) {
                if (priority[currentPriority] == 0) {
                    currentPriority--;
                    continue;
                }
                if (queue[index] == currentPriority) {
                    isOut[index] = true;
                    priority[currentPriority]--;
                    result.append(index + ", ");
                    outCount++;
                }
                do {
                    index = (index + 1) % queue.length;
                }while (isOut[index] && outCount != strQueue.length);
            }
            System.out.println(result.substring(0, result.length() - 2));
        }
//        Scanner in = new Scanner(System.in);
//        int [] a = new int[in.nextInt()];
//        for (int i = 0; i < a.length; i++) {
//            a[i] = in.nextInt();
//        }
//        quickSort(a, 0, a.length);
//        for(int i = 0; i < a.length; i++) {
//            System.out.print(a[i] + " ");
//        }
    }

    public static void quickSort(int[] a, int low, int high) {
        if (low == high) return;
        int pivot = low, i = low + 1, j = high - 1;
        boolean forward = false;
        while (i <= j) {
            if (forward) {
                if (a[pivot] > a[i]) {
                    i++;
                } else {
                    swap(a, pivot, i);
                    pivot = i;
                    forward = false;
                }
            } else {
                if (a[pivot] <= a[j]) {
                    j--;
                } else {
                    swap(a, pivot, j);
                    pivot = j;
                    forward = true;
                }
            }
        }
        quickSort(a, low, pivot);
        quickSort(a, pivot + 1, high);
//        System.out.println(pivot);
    }

    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void mergeSort(int[] a, int low, int high) {
        if ((high - low) == 1) return;
        int mid = (low + high) >>> 1;
        mergeSort(a, low, mid);
        mergeSort(a, mid, high);

        while ((low + mid) < high - low) {
            if (a[low] < a[mid]) {

            }
        }
    }
}


