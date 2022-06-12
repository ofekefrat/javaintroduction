public class Recursion {

    private static void swap(int[] a, int x, int y) {
        int temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }

    public long factorial(int n) {
        if (n==1) return 1;
        return n * factorial(n-1);
    }


    public static int recMax(int[] a) {
        return recMax(a, 0);
    }

    //TODO check
    private static int recMax(int[] a, int i) {
        if (i == a.length-1) return a[i];
        return Math.max(a[i], recMax(a, i+1));
    }

    public static int recMin(int[] a) {
        return recMin(a, 0);
    }

    //TODO check
    private static int recMin(int[] a, int i) {
        if (i == a.length-1) return i;
        int currentMin = recMin(a, i+1);
        if (a[i] > currentMin) return currentMin;
        return i;
    }

    private static void recSelection(int[] a, int i) { //sort num array smallest to biggest (recursion)
        if (i == a.length-1) return;
        int smallest = recMin(a, i);
        if (smallest != i) {
            int temp = a[smallest];
            a[smallest] = a[i];
            a[i] = temp;
        }
        recSelection(a, i+1);
    }

    public static void quickSort(int[] a) {
        quickSort(a, 0, a.length-1);
    }

    private static void quickSort(int[] a, int lo, int hi) {
        if (lo < hi) {
            int m = partition(a, lo, hi);
            quickSort(a, lo, m-1);
            quickSort(a, m+1, hi);
        }
    }// O(n logn) in avg case

    private static int partition(int[] a, int lo, int hi) {
        int left = lo, right = hi;
        int pivot = a[lo];
        while (left < right) {
            while (left<right && a[left] <= pivot) {
                left++;
            }
            while (a[right] > pivot) {
                right--;
            }

            if (left<right) swap(a, left, right);
        }
        swap(a, lo, right);
        return right;
    }

    public static int sqArrayMax(int[][] a) {
        return sqArrayMax(a, 0, 0);
    }

    private static int sqArrayMax(int[][] a, int i, int j) {
        if (i == a.length - 1 && j == a[0].length - 1)
            return a[i][j];
        if (j == a[0].length - 1) return Math.max(a[i][j], sqArrayMax(a, i + 1, 0));
        return Math.max(a[i][j], sqArrayMax(a, i, j + 1));
    }

    public static int numberPaths(int x, int y) {
        if (x==0 && y==0) return 0;
        if (x==0 || y==0) return 1;
        return numberPaths(x-1,y) + numberPaths(x, y-1);
    }


    public static boolean sumNum(int[] a, int num) {
        return sumNum(a, 0, num);
    }

    private static boolean sumNum(int[] a, int i, int num) {
        if (i == a.length) return false;
        if (a[i] == num) return true;
        return (sumNum(a, i+1, num) || sumNum(a, i+1, num-a[i]));
    }

    public static boolean diffOfOne(String s1, String s2) { // or no diff
        if (s1.length() != s2.length()) return false;
        if (s1.length() == 0) return true;
        if (s1.charAt(0) == s1.charAt(0)) return diffOfOne(s1.substring(1), s2.substring(1));
        else return s1.substring(1).equals(s2.substring(1));
    }

    public static String zigZagString(String s1, String s2) {
        if (s1.length()==0 && s2.length()==0) return "";
        if (s1.length() != 0)
            if (s2.length() != 0)
                return s1.charAt(0) + "" + s2.charAt(0) + "" + zigZagString(s1.substring(1), s2.substring(1));
            else
                return s1.charAt(0) + "" + zigZagString(s1.substring(1), s2);
        else
            return s2.charAt(0) + "" + zigZagString(s1, s2.substring(1));
    }
}
