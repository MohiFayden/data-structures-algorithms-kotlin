package hashing

import kotlin.math.max

/**
 * 1133. Largest Unique Number
 *
 * Given an integer array nums, return the largest integer that only occurs once. If no integer occurs once, return -1.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [5,7,3,9,4,9,8,3,1]
 * Output: 8
 * Explanation: The maximum integer in the array is 9 but it is repeated. The number 8 occurs only once, so it is the answer.
 * Example 2:
 *
 * Input: nums = [9,9,8,8]
 * Output: -1
 * Explanation: There is no number that occurs only once.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 2000
 * 0 <= nums[i] <= 1000
 */

class LC1133LargestUniqueNumber {
    fun largestUniqueNumber(nums: IntArray): Int {

        // 1: Hash Table / Counting
        // Put the numbers into a hash table
        // Count up the repetitive numbers
        // At the end, return the largest number which the count for it is 1

        // 2: Sort
        // Sort the list, Start from the end of the list and move to the beginning.
        // If faced any number that is unique, return it as the answer

        return useHashTable(nums)
        // return useSorting(nums)
    }


    //----------HashTable----------
    // Time complexity: O(n)
    // Space complexity: O(n)
    private fun useHashTable(nums: IntArray): Int {
        val counts = mutableMapOf<Int, Int>()

        nums.forEach { num ->
            counts[num] = (counts[num] ?: 0) + 1
        }

        var ans = -1
        counts.filterValues { it == 1 }.keys.forEach { num ->
            ans = max(ans, num)
        }

        return ans
    }


    //----------Sorting----------
    // Time complexity: O(sort time complexity)
    // Space complexity: O(1)
    private fun useSorting(nums: IntArray): Int {
        nums.sort()

        for (i in (nums.size - 1) downTo 0) {
            if ((i == 0 || nums[i] != nums[i - 1])
                && (i == nums.size - 1 || nums[i] != nums[i + 1])
            ) {
                return nums[i]
            }
        }

        return -1
    }
}