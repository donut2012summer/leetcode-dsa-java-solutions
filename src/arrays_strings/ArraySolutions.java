package arrays_strings;

import java.util.HashMap;
import java.util.HashSet;

public class ArraySolutions {

    /**
     * LeetCode 88 - Merge sorted arrays
     *
     * Time:
     * Space:
     *
     * Approach:
     */
    void mergeSortedArrays(int[] nums1, int m, int[] nums2, int n) {
        int idx1 = m - 1;
        int idx2 = n - 1;
        int insertPos = m + n - 1;

        // concat nums2 into nums1, hence if nums2 is empty, do nothing
        while(idx2 >= 0){
            if(idx1 >= 0 && nums1[idx1] > nums2[idx2]){
                nums1[insertPos] = nums1[idx1];
                idx1--;
            }else{
                nums1[insertPos] = nums2[idx2];
                idx2--;
            }
            insertPos--;
        }
    }


    /**
     * LeetCode 1 - Two Sum
     *
     * Time:
     * Space:
     *
     * Approach:
     */
    int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> remainMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            int remain = target - current;

            if(remainMap.containsKey(remain)){
                return new int[]{remainMap.get(remain), i}; // O (1)
            }
            remainMap.put(current, i);
        }
        return new int[]{-1, -1};

    }

    /**
     * LeetCode 1929 - Merge sorted arrays
     *
     * Time:
     * Space:
     *
     * Approach:
     */
    int[] getConcatenation(int[] nums){
        int length = nums.length;
        int[] ansArray = new int[2 * length];

        for (int i = 0; i < length; i++){
            ansArray[i] = nums[i];
            ansArray[i + length] = nums[i];
        }
        return ansArray;
    }


    /**
     * LeetCode 217 - Contains Duplicate
     *
     * Time:
     * Space:
     *
     * Approach:
     */
    boolean containsDuplicate(int[] nums){

        HashSet<Integer> set = new HashSet<>();

        for(int num : nums){
            if(!set.add(num)){
                return true;
            }
        }

        return false;
    }





    // Test
    public static void main(String[] args) {
        ArraySolutions sol = new ArraySolutions();


    }



}
