package hashing

/**
 * 1748. Sum of Unique Elements
 *
 * You are given an integer array nums. The unique elements of an array are the elements that appear exactly once in the array.
 *
 * Return the sum of all the unique elements of nums.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,2]
 * Output: 4
 * Explanation: The unique elements are [1,3], and the sum is 4.
 * Example 2:
 *
 * Input: nums = [1,1,1,1,1]
 * Output: 0
 * Explanation: There are no unique elements, and the sum is 0.
 * Example 3:
 *
 * Input: nums = [1,2,3,4,5]
 * Output: 15
 * Explanation: The unique elements are [1,2,3,4,5], and the sum is 15.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 100
 * 1 <= nums[i] <= 100
 */

class LC1748SumOfUniqueElements {
    fun sumOfUnique(nums: IntArray): Int {

        // We can use a hash table to count the frequency of the numbers in the array
        // Iterate over the nums
        // At each element, put the element in the counts or increment the count for that element
        // Sum up the elements that have the count of 1

        val counts = mutableMapOf<Int, Int>()
        var sum = 0

        nums.forEach { num ->
            counts[num] = (counts[num] ?: 0) + 1 // Get the previous count if it's available, otherwise, set 1
        }

        counts.filterValues { it == 1 }.keys.forEach { sum += it }

        return sum
    }
}