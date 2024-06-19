package arrays_and_strings

import kotlin.math.max

/**
 * 643. Maximum Average Subarray I
 *
 * ou are given an integer array nums consisting of n elements, and an integer k.
 *
 * Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value. Any answer with a calculation error less than 10-5 will be accepted.
 *
 *
 * Example 1:
 *
 * Input: nums = [1,12,-5,-6,50,3], k = 4
 * Output: 12.75000
 * Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75
 * Example 2:
 *
 * Input: nums = [5], k = 1
 * Output: 5.00000
 *
 *
 * Constraints:
 *
 * n == nums.length
 * 1 <= k <= n <= 105
 * -104 <= nums[i] <= 104
 */

class LC643MaximumAverageSubarrayI {
    fun findMaxAverage(nums: IntArray, k: Int): Double {
        if (k > nums.size) return 0.0

        var max = 0
        var curr = 0

        for (i in 0..<k) {
            curr += nums[i]
        }
        max = curr

        for (i in k..<nums.size) {
            curr = curr + nums[i] - nums[i - k]
            max = max(max.toDouble(), curr.toDouble()).toInt()
        }

        return max / k.toDouble()
    }
}