package median_of_two_sorted_arrays;

import java.util.Arrays;

/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays.
 * The overall run time complexity should be O(log (m+n)).
 */
public class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] a = new int[nums1.length + nums2.length];
        int p1 = 0;
        int p2 = 0;
        int i = 0;
        // Merge these 2 arrays into 1 ordered array.
        while (i < a.length) {
            if (p1 > nums1.length - 1) {
                System.arraycopy(nums2, p2, a, i, nums2.length - p2);
                break;
            }
            if (p2 > nums2.length - 1) {
                System.arraycopy(nums1, p1, a, i, nums1.length - p1);
                break;
            }
            if (nums1[p1] <= nums2[p2]) {
                while (p1 < nums1.length && nums1[p1] <= nums2[p2]) {
                    a[i++] = nums1[p1++];
                }
            } else {
                while (p2 < nums2.length && nums2[p2] < nums1[p1]) {
                    a[i++] = nums2[p2++];
                }
            }
        }
        System.out.println(Arrays.toString(a));
        if (a.length == 0) {
            return 0;
        } else if (a.length == 1) {
            return a[0];
        } else {
            if ((a.length & 0x01) == 0) {
                int midIdx1 = a.length / 2 - 1;
                int midIdx2 = a.length / 2;
                return (a[midIdx1] + a[midIdx2]) / 2.0;
            } else {
                return a[a.length / 2];
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] a = {1, 2};
        int[] b = {2, 8, 9, 11};
        System.out.println(solution.findMedianSortedArrays(a, b));
    }
}
