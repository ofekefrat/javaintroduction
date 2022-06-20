public class RecPractice {

    //2018a a6 87
    public static int howManySorted(int n, int max) {
        if (n == 1) return max;
        if (max == 1) return 1;
        return howManySorted(n, max-1) + howManySorted(n-1, max);
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

        int count=0;
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
}
