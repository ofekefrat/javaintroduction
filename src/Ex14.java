// 3,5

/**
 *
 */
public class Ex14 {

    public static boolean what(int [][] m) {
        int n=m.length;
        for(int x=0; x<n; x++)
            for (int y=0; y<(n-1); y++)
                if(m[x][y] > m[x][y+1]) return false;
        for(int x=0; x<n; x++)
            for (int y=0; y<(n-1); y++)
                if(m[y][x] > m[y+1][x]) return false;
        return true;
    }

    public static boolean findValWhat(int[][] m, int val) {
        if (m.length == 0) return false;
        int lowR = 0, highR = m.length - 1, midR;
        final int first = 0, last = m[0].length-1;
//        int lowC = 0, highC = m.length - 1, midC = m.length/2;
        while (lowR <= highR) {
            midR = (lowR + highR) / 2;

            if (m[midR][last] == val) return true;
            if (m[midR][first] == val) return true;

            if (m[midR][last] > val) {
                if (m[midR][first] < val)
                    return binarySearch(m[midR], val);
                else // for clarity (m[midR][first] > val)
                    highR = midR - 1;
            }
            else // (m[midR][last] < val)
                lowR = midR + 1;
        }
        return false;
    }// final?

    private static boolean binarySearch(int[] a, int target) {
        int low=0, high=a.length-1, mid;
        while (low <= high) {
            mid = (low + high)/2;

            if (a[mid] == target)
                return true;

            if (a[mid] < target)
                low = mid+1;
            else
                high = mid-1;
        }
        return false;
    } // this algorithm's time complexity is O(logn)



    public static boolean riddle(int [][] m, int val) {
        int n = m.length;
        for(int x=0; x<n; x++)
            for (int y=0; y<n; y++)
                if(m[x][y] == val) return true;
        return false;
    }



    public static boolean test(int [][] m) {
        int n=m.length;
        for(int r=0; r<(n-1); r++)
            for (int c=0; c<n; c++)
                for (int i=0; i<n; i++)
                    if(m[r][c] > m[r+1][i]) return false;
        return true;
    }

    public static void main(String[] args) {
        int[][] a = new int[4][4];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                a[i][j] = 9;
            }
        }


        System.out.println("what: " + what(a));
        System.out.println("test: " + test(a));
    }
}
