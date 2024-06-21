package arrays_and_strings

import kotlin.math.min

/**
 * 209. Minimum Size Subarray Sum
 *
 * Given an array of positive integers nums and a positive integer target, return the minimal length of a
 * subarray
 *  whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.
 *
 *
 *
 * Example 1:
 *
 * Input: target = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: The subarray [4,3] has the minimal length under the problem constraint.
 * Example 2:
 *
 * Input: target = 4, nums = [1,4,4]
 * Output: 1
 * Example 3:
 *
 * Input: target = 11, nums = [1,1,1,1,1,1,1,1]
 * Output: 0
 *
 *
 * Constraints:
 *
 * 1 <= target <= 109
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 104
 *
 *
 * Follow up: If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log(n)).
 */

class LC209MinimumSizeSubarraySum {
    fun minSubArrayLen(target: Int, nums: IntArray): Int {

        // Although we can sort the nums and put the pointer at the end of the list and move it left untill we find the ans
        //      In this way we have the O(n log(n)) for the sort
        // But, we can use sliding window and prefix sum technique to achieve the O(n)
        // Set two pointers at the beginning of the nums (left and right pointers)
        // Start moving the right pointer (expanding the window) and collect the sum until sum is grater than the target
        // Then, start a while loop to move the left pointer (collapsing the window) until sum is falling under the target
        //      At the same time, we update the answer and sum as well

        var sum = 0
        var left = 0
        var ans = Int.MAX_VALUE

        for (right in nums.indices) {

            sum += nums[right]

            while (sum >= target) {
                ans = min(ans, right - left + 1)
                sum -= nums[left++]
            }
        }

        return if (ans == Int.MAX_VALUE) 0 else ans
    }
}