package hashing

/**
 * 1512. Number of Good Pairs
 *
 * Given an array of integers nums, return the number of good pairs.
 *
 * A pair (i, j) is called good if nums[i] == nums[j] and i < j.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,1,1,3]
 * Output: 4
 * Explanation: There are 4 good pairs (0,3), (0,4), (3,4), (2,5) 0-indexed.
 * Example 2:
 *
 * Input: nums = [1,1,1,1]
 * Output: 6
 * Explanation: Each pair in the array are good.
 * Example 3:
 *
 * Input: nums = [1,2,3]
 * Output: 0
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 100
 * 1 <= nums[i] <= 100
 */

class LC1512NumberOfGoodPairs {
    fun numIdenticalPairs(nums: IntArray): Int {

        // We can use a hash table to store the elements and frequency of them to check them when visiting the next items
        // Since i < j, we can Iterate over the nums, and for each element, check if we have any occurance previously to consider them valid answer

        val counts = mutableMapOf<Int, Int>()
        var ans = 0

        for (num in nums) {
            if (counts.contains(num)) ans += counts[num]!!
            counts[num] = (counts[num] ?: 0) + 1
        }

        return ans
    }
}