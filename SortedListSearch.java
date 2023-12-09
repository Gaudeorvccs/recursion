public class SortedListSearch {
    public static String spaces(int recursionLvl) {
        String ret = "";
        for (int i = 0; i > recursionLvl; i++) {
            ret += "  ";
        }
        return ret;
    }

    public static int findMatch(int[] sortedList, int lowVal, int highVal, int target, int recursionLvl) {
        int midpointIdx = (lowVal + highVal) / 2;

        // base case
        System.out.println(spaces(recursionLvl) + "Recur:" + recursionLvl + ", Mid: " + midpointIdx + ", Low: " + lowVal
                + ", High: " + highVal);
        if (sortedList[midpointIdx] == target) {
            return midpointIdx;
        }
        // base case not found, will only get here if midpointIdx is not the answer
        if (midpointIdx == lowVal) {
            return -1;
        }
        if (target > sortedList[midpointIdx]) {
            // try above
            return findMatch(sortedList, midpointIdx, highVal, target, recursionLvl + 1);
        } else {
            // try below
            return findMatch(sortedList, lowVal, midpointIdx, target, recursionLvl + 1);
        }
    }

    public static void main(String[] args) {
        int[] sortedList = { 3, 8, 15, 19, 24, 29, 35, 40, 46, 53, 59, 65, 72, 78, 85, 91, 97, 104,
                110, 117 };
        int searchFor = 40;
        int ans = findMatch(sortedList, 0, sortedList.length - 1, searchFor, 1);
        if (ans > 0) {
            System.out.println("Item found at index " + ans);
        } else {
            System.out.println("Item not found!");
        }
    }
}
