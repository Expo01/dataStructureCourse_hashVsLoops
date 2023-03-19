import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        //interview question: find if two lists contain the same item. Purpose here is to avoid brute force and
        // demonstrate data structure and big O knowledge

        int[] array1 = {1, 3, 5};
        int[] array2 = {2, 4, 5};
        System.out.println(itemInCommonLoop(array1, array2));

        int[] array3 = {1, 3, 5};
        int[] array4 = {2, 4, 5};
        System.out.println(itemInCommonHash(array3, array4));
    }

    public static boolean itemInCommonLoop(int[] array1, int[] array2) {
        for (int i : array1) {
            for (int j : array2) {
                if (i == j) return true;
            }
        }
        //in a nested for loop, array 2 must be iterated for each item of array 1. Not a big deal when there are only
        // 3 items such that second array is only looped 3 times, but with larger lists like 1000 items, we would have
        // to loop through the second array 1000 times. that's 999 times of redundancy
        // this is O(n^2)
        return false;
    }
    public static boolean itemInCommonHash(int[] array1, int[] array2) {
        HashMap<Integer, Boolean> myHashMap = new HashMap<Integer, Boolean>();

        for (int i : array1) {
            myHashMap.put(i, true);
            //here we have created a hashmap where each number is the key, and we've looped through the first
            // list one time to assign a value to the keys of true for all
        }

        for (int j : array2) {
            if (myHashMap.get(j) != null) return true;
        } // then we iterate through second list one time, checking if the map contains the value
        //which is best case scenario of O(1) and worst case scenario of O(n) if there are other items at that hash address

        // so first loop is O(n) and second loop is worst case O(n) = O(2n) --> O(n) which is improved over nested for loop

        return false;
    }


}



