package arrays_and_strings

/**
 * 713. Subarray Product Less Than K
 *
 * Given an array of integers nums and an integer k, return the number of contiguous subarrays where the product of all the elements in the subarray is strictly less than k.
 *
 *
 * Example 1:
 *
 * Input: nums = [10,5,2,6], k = 100
 * Output: 8
 * Explanation: The 8 subarrays that have product less than 100 are:
 * [10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6]
 * Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.
 * Example 2:
 *
 * Input: nums = [1,2,3], k = 0
 * Output: 0
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 3 * 104
 * 1 <= nums[i] <= 1000
 * 0 <= k <= 106
 */

class LC713SubarrayProductLessThanK {
    fun numSubarrayProductLessThanK(nums: IntArray, k: Int): Int {
        return slidingWindows(nums, k)
    }


    //-----Sliding Windows-----
    private fun slidingWindows(nums: IntArray, k: Int): Int {
        if(k <= 1) return 0

        var ans = 0
        var left = 0
        var curr = 1

        for(right in nums.indices){
            curr *= nums[right]
            while(curr >= k){
                curr /= nums[left]
                left++
            }

            ans += right - left + 1
        }

        return ans
    }
}