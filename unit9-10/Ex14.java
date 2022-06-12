/**
 * Question 1A: only sentences 3,5 are correct.
 * @author Ofek Efrat
 * @version 19/05/22
 */
public class Ex14 {

    // Question 1

    // B1
    /**
     * Returns whether a given value exists inside a given matrix.
     *
     * This algorithm has a time complexity of O(n) because the maximum number of iterations is n*2:
     * The search begins from the top right corner of the matrix, and can only go left or down.
     * it can go left n-1 times at most, otherwise it would go out of bounds, and down n-1 times, for the same reason.
     * therefore, the maximum number of iterations is n-1 + n-1 = 2n-2 = O(n)
     *
     * The space complexity is O(1), because the amount of space being used during the process is constant, and not dependant upon any input.
     * @param m the array to be searched
     * @param val the value to search for
     * @return True if the value was found
     */
    public static boolean findValWhat(int[][] m, int val) {
        if (m.length == 0) return false;
        int i = 0, j = m[0].length-1;

        while (i < m.length && j >= 0) {
            if (m[i][j] == val) return true;
            if (m[i][j] > val) j--;
            else i++;
        }
        return false;
    }

    //B2
    /**
     * Returns whether a given value exists inside a given matrix.
     *
     * Time: This algorithm has a time complexity of O(n) because it iterates over an array of n items a known number of times, twice at most:
     * the first for loop will happen (unless the array is empty),
     * the second for loop will happen only if a condition is met, and then returns a final answer, ending the process.
     * the third loop will happen only if the second was never called, and then returns a final answer, ending the process.
     *
     * Space: The space complexity is O(1), because the amount of space being used during the process is constant, and not dependant upon any input.
     * @param m the array to be searched.
     * @param val the value to search for
     * @return True if the value was found
     */
    public static boolean findValTest(int[][] m, int val) {
        if (m.length == 0) return false;
        final int FIRST = 0, LAST = m[0].length-1;
        for (int i = 1; i < m.length; i++) { // O(n)
            if (m[i][FIRST] > val) {
                for (int j = 0; j < m[0].length; j++) { // this is O(n), but it will happen once at most
                    if (m[i-1][j] == val) return true;
                    if (m[i][j] == val) return true;
                }
                return false;
            }
        }
        for (int i = 0; i < m[0].length; i++) { // check the last row to make sure it's not there (also happens once at most)
            if (m[LAST][i] == val) return true;
        }
        return false;
    }

    // Question 2
    /**
     * Returns the number of sub-arrays in the given array which are strictly increasing in value.
     *
     * Time: This algorithm has a time complexity of O(n), because it iterates over the array a constant number of times (once).
     * Space: The space complexity is O(1), because the amount of space being used during the process is constant, and not dependant upon any input.
     * @param a the array to be checked
     * @return The number of increasing sequences
     */
    public static int strictlyIncreasing(int[] a) { // time = O(n); space = O(1);
        int counter=0;
        int streak=0;
        for (int i = 1; i < a.length; i++) {
            if (a[i] > a[i-1]) {
                counter += 1+streak;
                streak++;
            }
            else
                streak = 0;
        }
        return counter;
    }

    // Question 3
    /**
     * Returns the length of the longest flat sequence in the given array.
     * @param arr The array to be processed
     * @return The length of the longest flat sequence
     */
    public static int longestFlatSequence(int[] arr) {
        return longestFlatSequence(arr, 0);
   }

    private static int longestFlatSequence(int[] arr, int i) {
        if (i == arr.length-1) return 1;

        int currentMax = flatSubArrayFrom(arr, i);
        int nextMax = longestFlatSequence(arr, i+1);
        return Math.max(currentMax, nextMax);
    }

    private static int flatSubArrayFrom(int[] arr, int i) {
        return flatSubArrayFrom(arr, i, -199, -199);
    }

    // Return the next flat sub array
    private static int flatSubArrayFrom(int[] arr, int i, int first, int second) {
        final int NONE = -199;
        if (i == arr.length-1) return 1;
        if (Math.abs(arr[i] - arr[i+1]) > 1) return 1;
        if (first == NONE) first = arr[i];

        if (first != arr[i] && second == NONE) second = arr[i];
        if (arr[i] != first && arr[i] != second) return 0;

        return 1 + flatSubArrayFrom(arr, i+1, first, second);
    }


    // Question 4
    /**
     * Given a matrix exclusively filled with the values -1, 0 and 1, begins from the top left corner (mat[0][0]), and
     * finds the path that covers the highest amount of 1's, without ever stepping over -1's.
     * the algorithm can go right on an even line index, left on an odd line index, and down in both cases.
     * if the value in the first cell is -1, returns -1.
     * @param mat The matrix to be processed.
     * @return The maximum amount of 1's within the rules. -1 if the value in the very first cell is -1.
     */
    public static int findMaximum(int[][] mat) {
        if (mat.length == 0) return 0;
        if (mat[0][0] == -1) return -1;
        return findMaximum(mat, 0, 0);
    }

    // i = row index, j = column index
    private static int findMaximum(int[][] mat, int i, int j) {
        final int BEEN_HERE = -1;
        if (isDeadEnd(mat, i, j)) return mat[i][j];

        int temp = mat[i][j];
        mat[i][j] = BEEN_HERE; // prevent cell repetition

        int right=0, left=0, down=0;

        if(canGo(mat, i, j, 'r')) right = findMaximum(mat, i, j+1);
        if(canGo(mat, i, j, 'l')) left = findMaximum(mat, i, j-1);
        if(canGo(mat, i, j, 'd')) down = findMaximum(mat, i+1, j);

        mat[i][j] = temp; // return the cell to its original value

        int max;
        max = left;
        if (right > max) max = right;
        if (down > max) max = down;
        return max + mat[i][j];
    }

    // Check whether the path is at a dead end
    private static boolean isDeadEnd(int[][] m, int i, int j) {
        return !(canGo(m, i, j, 'r') || canGo(m, i, j, 'l') || canGo(m, i, j, 'd')); // can't go left/right/down
    }

    // Check if the path can go a certain direction
    private static boolean canGo(int[][] m, int i, int j, char direction) {
        if (direction == 'r' && i%2 == 0) return (j+1 < m[0].length && m[i][j+1] > -1); // right
        if (direction == 'l' && i%2 == 1) return (j-1 >= 0 && m[i][j-1] > -1); // left
        if (direction == 'd') return (i+1 < m.length && m[i+1][j] > -1); // down
        return false;
    }
}
