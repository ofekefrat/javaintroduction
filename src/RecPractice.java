public class RecPractice {

    private int _private;
    int _default;
    public int _public;
    protected int _protected;

    public RecPractice() {
        _private = 0;
        _default = 0;
        _public = 0;
        _protected = 0;
    }

    //2018a a6 87
    public static int howManySorted(int n, int max) {
        if (n == 1) return max;
        if (max == 1) return 1;
        return howManySorted(n, max-1) + howManySorted(n-1, max);
    }

    //2018a 91
    public static int cheapestRoute(int[] stations) {
        return cheapestRoute(stations, 0);
    }

    private static int cheapestRoute(int[] stations, int i) {
        if (i == stations.length-1) return stations[i];
        if (i == stations.length-2) return stations[i] + cheapestRoute(stations, i+1);
        int val = stations[i];

        return Math.min(val + cheapestRoute(stations, i+1), val + cheapestRoute(stations, i+2));
    }

    //2019b 85
    public static int howManyPaths(int[][] mat) {
        return howManyPaths(mat, 0, 0);
    }

    private static int howManyPaths(int[][] mat, int i, int j) {
        if (i >= mat.length || j >= mat[0].length ||
            i < 0 || j < 0) return 0;
        if (mat[i][j] == 0) return 0;
        if (i == mat.length-1 && j == mat[0].length-1) return 1;
        int val = mat[i][j];

        mat[i][j] = 0;

        int right = howManyPaths(mat, i, j+val); // mat[i].length-1 - val + j;
        int left = howManyPaths(mat, i, j-val); // i-1 - val;
        int down = howManyPaths(mat, i+val, j); // mat.length-1 - val + i;
        int up = howManyPaths(mat, i-val, j); // i-1 - val;

        mat[i][j] = val;

        return right+left+down+up;
    }


    //2019b b3 93
    public static boolean isSum(int[] a, int num) {
        return isSum(a, num, 0,0);
    }

    private static boolean isSum(int[] a, int num, int i, int streak) {
        if (num == 0) return true;
        if (num < 0) return false;
        if (i == a.length) return false;

        if (streak < 2) return isSum(a, num-a[i], i+1,streak+1) || isSum(a, num, i+1, 0);
        return isSum(a, num, i+1, 0);
    }


    //2019a a4 85
    public static int longestPalindrome(int[] a) {
        return longestPalindrome(a, 0, a.length-1);
    }

    public static int longestPalindrome(int[] a, int i, int j) {
        if (i==j) return 1;
        if (i > j) return 0;

        int count;
        if (a[i] == a[j])
            count = 2 + longestPalindrome(a, i+1, j-1);
        else
            count = Math.max(longestPalindrome(a, i+1, j), longestPalindrome(a, i, j-1));

        return count;
    }


    //2021a 85
    public static int minPrice(int[][] mat) {
        return minPrice(mat, 0, 1);
    }

    private static int minPrice(int[][] mat, int i, int j) {
        if (i == mat.length-1) return 0;

        int total1 = mat[i][mat[0].length-1];
        int total2 = mat[i][j] + minPrice(mat, i+1, j+1);

        return Math.min(total1, total2);
    }

    //not sure
    public static boolean covers(int[][] mat, int[] a, int k) {
        return covers(mat, a, k, 0, 0, 0);
    }

    private static boolean covers(int[][] mat, int[] a, int k, int i, int j, int ai) {
        if (i == mat.length || i > k-1) return false;
        if (ai == a.length) return true;

        if (j == mat[0].length) return covers(mat, a, k, i+1, 0, ai);
        if (a[ai] == mat[i][j]) return covers(mat, a, k, 0, 0, ai+1);
        return covers(mat, a, k, i, j+1, ai);
    }
}
