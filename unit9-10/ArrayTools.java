public class ArrayTools {

    private static void swap(int[] a, int x, int y) {
        int temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }


    // SEARCHING

    public static int binarySearch(int[] a, int target) { // for sorted arrays (low -> high)
        int low=0, high=a.length-1, mid;
        while (low <= high) {// will break when (low = mid+1) makes low greater than high.

            mid = (low + high)/2; // find middle index

            if (a[mid] == target)// number in middle index matches target?
                return mid;// return index of match

            if (a[mid] < target)// number in middle index less than target?
                low = mid+1; // next iteration will search top half of array

            else // number in middle index greater than target?
                high = mid-1; // next iteration will search bottom half of array
        }
        return -1; // target was never found in array.
    } // this algorithm requires O(log2(n)) comparisons

    public static boolean sumSearch(int[] a, int target) { // for sorted arrays (low -> high)
        int low=0, high = a.length-1;
        while (low < high) {
            if (a[low] + a[high] == target) return true;
            else if (a[low] + a[high] > target) high--;
            else low++;
        }
        return false;
    }


    //SORTING

    public static void twoColorFlag(int[] a) {
        int low=0, high = a.length-1;
        while (low < high) {
            if (a[low] == 0) low++;
            else if (a[high] == 1) high--;
            else {
                swap(a, low, high);
                low++;
                high--;
            }
        }
    } // O(n)

    public static void betterBubbleSort(int[] a) { // "bubbling" up the maximum
        boolean swap = true;
        for (int i = a.length - 1; i > 0 && swap; i--) { // adding whether a swap has been made to the condition
            swap = false;
            for (int j = 0; j < i; j++) {
                if (a[j] > a[j + 1]) { // if value at index j is greater than num in next index
                    swap = true; // a swap has been made
                    int temp = a[j];
                    a[j] = a[j + 1]; // demote lesser value to previous index
                    a[j + 1] = temp; // promote greater value to next index
                }
            }
        }
    } // O(n^2)

    public static void selectionSort(int[] a) { // "selecting" the minimum
        for (int i = 0; i < a.length - 1; i++) { // for each index in array
            int smallestInd = i; // make the first index which wasnt yet checked the smallest by default
            for (int j = i+1; j < a.length; j++) { // for each index after i
                if (a[j] < a[smallestInd]) smallestInd = j; // if value at j less than value at smallest index, make j smallest index.
            }
            if (smallestInd != i) { // if i (default smallest index) was not the smallest at the end, switch between their values.
                int temp = a[smallestInd];
                a[smallestInd] = a[i];
                a[i] = temp; // put smallest value at i
            }
        }
    } // O(n^2)

    public static void insertionSort(int[] a) {// inserting each value to the correct position
        int j;
        for (int i = 1; i < a.length; i++) {
            int newest = a[i];
            for (j = i-1; j>=0 && a[j] > newest; j--) { // while newest is smaller than j
                a[j+1] = a[j]; // promote each value to next index
            }
            a[j+1] = newest; // newest is no longer smaller, append it after the value that was smaller
        }
    } // O(n^2)

    public static void badBubbleSort(int[] a) {
        for (int i = a.length-1; i>0 ; i--) { // i = last index, descending. (to sort every value in array)
            for (int j = 0; j < i; j++) { // j = first index, ascending. (to check the single value with every other value)
                if (a[j] > a[j+1]) { // if value at index j is greater than num in next index
                    int temp = a[j];
                    a[j] = a[j+1]; // demote lesser value to previous index
                    a[j+1] = temp; // promote greater value to next index
                }
            }
        }
    }// idk this shit sucks tbh

}


