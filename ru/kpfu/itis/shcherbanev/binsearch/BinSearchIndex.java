package ru.kpfu.itis.shcherbanev.homework3;

public class BinSearchIndex {

    public static void main(String[] args) {
        int[] a = {2, 3, 4, 4, 5, 5, 5, 5, 13};
        System.out.println(findIndex(a, 0, a.length - 1));
    }
    public static int findIndex(int[] a, int l, int r) {
        if (l > r) return -1;
        int middle = (r + l) / 2;
        if (a[middle] == middle) return middle;
        if (f(a, l) * f(a, middle) <= 0) {
            return findIndex(a, l, middle - 1);
        } if (f(a, middle) * f(a, r) <= 0) {
            return findIndex(a, middle + 1, r);
        }

        int left = findIndex(a, l, middle - 1);
        if (left != -1) return left;
        int right = findIndex(a, middle + 1, r);

        return Math.max(left, right);
    }

    public static int f(int[] array, int i) {
        return array[i] - i;
    }

}
