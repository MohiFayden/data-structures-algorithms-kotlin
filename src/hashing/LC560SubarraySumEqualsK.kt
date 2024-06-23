package hashing

/**
 * 560. Subarray Sum Equals K
 *
 * Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
 *
 * A subarray is a contiguous non-empty sequence of elements within an array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,1,1], k = 2
 * Output: 2
 * Example 2:
 *
 * Input: nums = [1,2,3], k = 3
 * Output: 2
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 2 * 104
 * -1000 <= nums[i] <= 1000
 * -107 <= k <= 107
 */

class LC560SubarraySumEqualsK {
    fun subarraySum(nums: IntArray, k: Int): Int {

        // Build the prefix sum, to be able to compute the sum of each subarray in O(1)
        // For an element, if we already have the diff of the curr prefix sum and k, that means we have a valid prefix sum
        // We should count the number of occurrences of the prefix sum as we might have the same prefix sum multiple times due to the negative numbers
        // We can use a hash table to count how many times a sum occurs

        val counts = mutableMapOf<Int, Int>() // Count number of occurrences for a prefix sum
        var prefix = 0 // Prefix sum
        var ans = 0

        counts[0] = 1
        for (num in nums) {
            prefix += num
            ans += counts[prefix - k] ?: 0
            counts[prefix] = (counts[prefix] ?: 0) + 1
        }

        return ans
    }
}