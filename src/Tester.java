public class Tester {
    public static void main(String[] args) {
        int[] a = {7, 2, 3};
        int[][] mat = {{1, 5, 7},
                      {4, 2, 9},
                      {1, 2, 3}};

//        EffPractice.minimumSubK(b, 4);
        boolean res = RecPractice.covers(mat, a, 2);
        System.out.println(res);

    }
}