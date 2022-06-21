public class Tester {
    public static void main(String[] args) {
        int[] a = {2,8,3,4,7,1,3,2};
        int[][] mat = {{1, 3, 1, 6},
                      {2, 8, 1, 2},
                      {6, 2, 7, 5},
                      {2, 4, 1, 3}};

//        EffPractice.minimumSubK(b, 4);
        int res = RecPractice.cheapestRoute(a);
        System.out.println(res);

    }
}