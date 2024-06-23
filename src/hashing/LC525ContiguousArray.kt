package hashing

/**
 * 525. Contiguous Array
 *
 * Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [0,1]
 * Output: 2
 * Explanation: [0, 1] is the longest contiguous subarray with an equal number of 0 and 1.
 * Example 2:
 *
 * Input: nums = [0,1,0]
 * Output: 2
 * Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * nums[i] is either 0 or 1.
 */

class LC525ContiguousArray {
    fun findMaxLength(nums: IntArray): Int {

        // Use a hash table (map) to count 0 and 1 occurrence
        // Iterate over the nums
        // In each step, if you face 0, decrement the count, otherwise, increment the count
        // Try to put this count and its index on the map
        // If you already have the same count, there is no need to update the value as the previous index gives us the longer subarray
        // Why does counting give us the answer?
        //      facing the same count means between two counts have the same number of 0 and 1
        // Don't forget to init the map[0] with -1 which means if we faced 0, the substring will start from the beginning of the list

        // nums  = [ 0,  0,  1,   0,   1,  1]
        // count = [-1, -2, -1,  -2,  -1,  0]

        val map = mutableMapOf<Int, Int>()

        var maxLength = 0
        var count = 0

        map[0] = -1

        for (i in nums.indices) {
            count += if (nums[i] == 1) 1 else -1

            if (map.containsKey(count)) {
                maxLength = maxOf(maxLength, i - map[count]!!)
            } else {
                map[count] = i
            }
        }

        return maxLength
    }
}