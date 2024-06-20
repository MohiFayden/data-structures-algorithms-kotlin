package arrays_and_strings

/**
 * 2540. Minimum Common Value
 * 
 * Given two integer arrays nums1 and nums2, sorted in non-decreasing order, return the minimum integer common to both arrays. If there is no common integer amongst nums1 and nums2, return -1.
 *
 * Note that an integer is said to be common to nums1 and nums2 if both arrays have at least one occurrence of that integer.
 *
 *
 *
 * Example 1:
 *
 * Input: nums1 = [1,2,3], nums2 = [2,4]
 * Output: 2
 * Explanation: The smallest element common to both arrays is 2, so we return 2.
 * Example 2:
 *
 * Input: nums1 = [1,2,3,6], nums2 = [2,3,4,5]
 * Output: 2
 * Explanation: There are two common elements in the array 2 and 3 out of which 2 is the smallest, so 2 is returned.
 *
 *
 * Constraints:
 *
 * 1 <= nums1.length, nums2.length <= 105
 * 1 <= nums1[i], nums2[j] <= 109
 * Both nums1 and nums2 are sorted in non-decreasing order.
 */

class LC2540MinimumCommonValue {
    fun getCommon(nums1: IntArray, nums2: IntArray): Int {
        // Set two pointers at the beginning of the arrays
        // Loop over the arrays until reaching the end of one of the arrays
        // Inside the loop, if the current items in the arrays are equal, update the answer and break.
        // Otherwise, increment the counter which the value of it is lower

        var ans = -1
        var i = 0
        var j = 0
        while (i < nums1.size && j < nums2.size) {
            if (nums1[i] == nums2[j]) {
                ans = nums1[i]
                break
            }

            if (nums1[i] < nums2[j]) {
                i++
            } else {
                j++
            }
        }

        return ans
    }
}