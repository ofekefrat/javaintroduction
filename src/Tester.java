import java.util.Arrays;
import java.util.stream.IntStream;
public class Tester {
    public static void main(String[] args) {
        int[] arr = new int[36];
        IntStream.rangeClosed(1, 36).forEach(i -> arr[i-1] = i);

        int[][] mat = new int[6][6];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length; j++) {
                mat[i][j] = arr[i*6 + j];
//                System.out.println(mat[i][j]);
            }
        }
        System.out.println(Ex14.findValWhat(mat, 13));
    }
}