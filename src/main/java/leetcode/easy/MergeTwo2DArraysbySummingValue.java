package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

public class MergeTwo2DArraysbySummingValue {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        var firstPointer = 0;
        var secondPointer = 0;
        List<int[]> mergedList = new ArrayList<>();

        while (firstPointer < nums1.length && secondPointer < nums2.length) {
            if (nums1[firstPointer][0] < nums2[secondPointer][0]) {
                mergedList.add(nums1[firstPointer]);
                firstPointer++;
            } else if (nums1[firstPointer][0] > nums2[secondPointer][0]) {
                mergedList.add(nums2[secondPointer]);
                secondPointer++;
            } else {
                int mergedValue = nums1[firstPointer][1] + nums2[secondPointer][1];
                mergedList.add(new int[]{nums1[firstPointer][0], mergedValue});
                firstPointer++;
                secondPointer++;
            }
        }

        if (firstPointer < nums1.length) {
            mergedList.addAll(asList(nums1).subList(firstPointer, nums1.length));
        }

        if (secondPointer < nums2.length) {
            mergedList.addAll(asList(nums2).subList(secondPointer, nums2.length));
        }

        return mergedList.toArray(new int[0][]);
    }
}
