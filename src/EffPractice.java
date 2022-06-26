public class EffPractice extends RecPractice {

    public EffPractice() {
//        _x1=0; // PRIVATE
        _default =0;
        _public =0;
        _protected =0;

        RecPractice r = new RecPractice();

//        r._x1=0; // PRIVATE
        r._default =0;
        r._public =0;
        r._protected =0;

        EffPractice eff = new EffPractice();
        RecPractice rec = eff;
    }

    //2017a b1 90
    public static int findSmallest(int[] a) { // O(n)
        if (a.length==0 || a[0] > 1) return 1;
        if (a.length==1 || a[1] > 2) return 2;
        if (a.length==2) return 4;
        int sum=a[0] + a[1];
        for (int i = 2; i < a.length; i++) {
            if (a[i] > sum+1) return sum+1;
            sum += a[i];
        }// all the elements are 0/1/2 steps away from each other
        return sum+1;
    }

    //2018a 91
    public static void sortMod(int[] a, int k) {

    }

    //2019b b3 93
    public static int shortestRoad(int[] road1, int[] road2) {
        int sum1=0, sum2=0;
        int from1, from2, shortWay;
        for (int i = 0; i < road1.length; i++) sum1 += road1[i];
        from1 = sum1;
        for (int i = 0; i < road2.length; i++) sum2 += road2[i];
        from2 = sum2;
        shortWay = Math.min(sum1, sum2);

        for (int i = road1.length-1; i >= 0; i--) {
            from1 = from1 - road1[i] + road2[i];
            if (from1 < shortWay) shortWay = from1;
        }

        for (int i = road2.length-1; i >= 0; i--) {
            from2 = from2 - road2[i] + road1[i];
            if (from2 < shortWay) shortWay = from2;
        }

        return shortWay;
    }

    //2019a a4 85
    public static int missingValue(int[] a) {
        int low=0, high=a.length-1, mid;
        int jump = a[1] - a[0];
        if (a[high] - a[high-1] != jump) {
            if (a[2] - a[1] != jump) return a[0] + (a[2] - a[1]);
            else // a[2] - a[1] == jump
                return a[high-1] + jump;
        } // if we're here, then we have our jump

        while (low <= high) {
            mid = (low + high)/2;

            if (a[mid] - a[mid-1] != jump) return a[mid-1] + jump;
            if (a[mid+1] - a[mid] != jump) return a[mid] + jump;

            if (a[mid] - a[low] != jump * (mid-low)) // missing number is in lower half
                high = mid-1;
            else // missing number is in higher half
                low = mid+1;
        }
        return 69420;
    }

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

    private static void swap(int[] a, int x, int y) {
        int temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }
    //Q3

    //2020a 87
    public static void printTriplets(int[] a, int num) {
        //the bullshit
    }
    //2020b 81
    public static void minimumSubK(int[] a, int k) {
        int min=0;
        int minInd=0;
        for (int i = 0; i < k; i++) {
            min += a[i];
        }
        int temp = min;
        for (int i = 0; i < a.length-k; i++) {
            temp += a[i+k] - a[i];
            if (temp<min) {
                min = temp;
                minInd = i+1;
            }
        }
        System.out.println("Min sum sub-array is (" + minInd + "," + (minInd+k-1) + ")");
    }

    //2020b 96 TODO!


    //2021a 85
    public static boolean findAverage(int[] a, double avg) {
        final int fail = 69420;
        int low = fail;
        int high = fail;
        boolean found = false;
        for (int i = 0; i < a.length-1 && !found; i++) {
            if (a[i] <= avg && a[i+1] >= avg) {
                low = i;
                high = i+1;
                found = true;
            }
        }
        if (low == fail) return false;
        if (a[low] == avg) {
            System.out.println(low + " --- " + low);
            return true;
        }
        if (a[high] == avg) {
            System.out.println(high + " --- " + high);
            return true;
        }

        double temp = (a[low] + a[high]);
        int c = 2;
        do {
            if (temp/c < avg) {
                high++;
                temp += a[high];
                c++;
            }
            if (temp/c > avg) {
                low--;
                temp += a[low];
                c++;
            }
            if (temp/c == avg) {
                System.out.println(low + " --- " + high);
                return true;
            }
        } while (low > 0 && high < a.length-1);

        return false;
    }

    //dunno
//    public static int getMedian(int[] a, int[] b) {
//        int totalLength = a.length + b.length;
//        if (a[a.length-1] <= b[0]) {
//            if (totalLength%2==0) return (a[a.length-1] + b[0])/2;
//            else return
//        }
//        if (b[b.length-1] <= a[0]) return (b[b.length-1] + a[0])/2;
//        int aMedian, bMedian;
//
//        int midA = (a.length-1)/2, midB = (b.length-1)/2;
//
//        if (a.length % 2 == 0) {
//            aMedian = (a[midA] + a[midA+1])/2;
//        }
//        else aMedian = a[midA];
//
//        int low=0, high=a.length-1, mid;
//        while (low <= high) {
//            mid = (low+high)/2;
//
//            if (aMedian)
//        }
//
//    }
}
