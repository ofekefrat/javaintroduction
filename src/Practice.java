import java.util.SplittableRandom;

public class Practice {

    //2019b b3 93
    // Q1
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

    //Q2

}
